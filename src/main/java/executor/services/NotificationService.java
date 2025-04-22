package executor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import executor.domain.user.User;
import executor.dtos.NotificationDTO;

@Service
public class NotificationService {
    
    @Autowired
    private RestTemplate rest;

    private String url = "https://util.devi.tools/api/v1/notify";

    public void sendNotification(User user, String message) throws Exception{
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, message);

       ResponseEntity<String> responseString = rest.postForEntity(url, notificationRequest, String.class);

      if(!(responseString.getStatusCode() == HttpStatus.OK)){
        System.out.println("erro ao enviar notificação");
        throw new Exception("Falha ao enviar notificação!");
      }
    }
}
