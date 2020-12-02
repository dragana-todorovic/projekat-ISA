package isa.ProjectIsa.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class ScheduledTasks {

    private final RabbitMQSender rabbitMQSender;

    @Autowired
    public ScheduledTasks(RabbitMQSender rabbitMQSender) {
        this.rabbitMQSender = rabbitMQSender;
    }

  //  @Scheduled(fixedRate = 3000)
    public void sendMessage(String messageText, String phName, Date dateFrom, Date dateTo) {
       MessageDto message = new MessageDto( messageText,
               phName, dateFrom, dateTo);
        rabbitMQSender.send(message);
        System.out.println("Sent :" + message.getText() + " phName : "+ message.getPharmacyName() +" "
        		+ "from : "+ message.getDateFrom());
    }
}
