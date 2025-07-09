package utfpr.arq.Order.Service.management.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

    private final RabbitTemplate rabbitTemplate;

    @Value("${broker.queue.email.name}")
    private String emailQueue;

    public EmailSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendEmail(Object emailDTO) {
        rabbitTemplate.convertAndSend(emailQueue, emailDTO);
    }
}
