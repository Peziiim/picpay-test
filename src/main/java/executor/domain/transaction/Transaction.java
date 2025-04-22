package executor.domain.transaction;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import executor.domain.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name="transactions")
@Table(name="transactions")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;
    
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;


    private LocalDateTime timeStamp;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public BigDecimal getAmount() {
        return amount;
    }


    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public User getSender() {
        return sender;
    }


    public void setSender(User sender) {
        this.sender = sender;
    }


    public User getReceiver() {
        return receiver;
    }


    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }


    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }


    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    
}
