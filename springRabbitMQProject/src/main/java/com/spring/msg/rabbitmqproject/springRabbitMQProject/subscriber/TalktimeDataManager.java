package com.spring.msg.rabbitmqproject.springRabbitMQProject.subscriber;

import com.spring.msg.rabbitmqproject.springRabbitMQProject.config.MessagingConfiguration;
import com.spring.msg.rabbitmqproject.springRabbitMQProject.dto.Payment;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.stereotype.Component;

@Component
public class TalktimeDataManager {

    @RabbitListener(queues = MessagingConfiguration.QUEUE)
    public void comsumeMessageFromQueue(Payment payment){
        System.out.println("Message received from queue : "+ payment.toString());
    }
}
