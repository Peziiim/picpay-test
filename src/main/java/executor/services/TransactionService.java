package executor.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import executor.domain.transaction.Transaction;
import executor.domain.user.User;
import executor.dtos.TransactionDTO;
import executor.repositories.TransactionRepository;

@Service
public class TransactionService {
    
    @Autowired
    private UserService userService;

    @Autowired 
    private TransactionRepository trRepository;
    
    @Autowired
    private RestTemplate rest;

    private String mock = "https://util.devi.tools/api/v2/authorize";

    public void createTransaction(TransactionDTO transaction) throws Exception{
        User sender = this.userService.findUserById(transaction.senderId());
        User receiver = this.userService.findUserById(transaction.receiverId());

        userService.validateTransaction(sender, transaction.value());

        boolean isAuth = this.authorizeTransaction(sender, transaction.value());
        if (!isAuth) {
            throw new Exception("Transação não autorizada");
        }

        Transaction transfer = new Transaction();
        transfer.setAmount(transaction.value());
        transfer.setSender(sender);
        transfer.setReceiver(receiver);
        transfer.setTimeStamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transaction.value()));
        receiver.setBalance(receiver.getBalance().add(transaction.value()));

        trRepository.save(transfer);
        userService.saveUser(sender);
        userService.saveUser(receiver);
    } 

    public Boolean authorizeTransaction(User sender, BigDecimal amount){
     ResponseEntity<Map> responseAuth = rest.getForEntity(mock, Map.class);

     if (responseAuth.getStatusCode() == HttpStatus.OK) {
        String message = responseAuth.getBody().get("authorization").toString();
        return "true".equalsIgnoreCase(message);

     } else return false;
    }
}
