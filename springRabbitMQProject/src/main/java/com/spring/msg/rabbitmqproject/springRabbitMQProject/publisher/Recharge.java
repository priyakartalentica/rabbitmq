package com.spring.msg.rabbitmqproject.springRabbitMQProject.publisher;

import com.spring.msg.rabbitmqproject.springRabbitMQProject.config.MessagingConfiguration;
import com.spring.msg.rabbitmqproject.springRabbitMQProject.dto.Payment;
import com.spring.msg.rabbitmqproject.springRabbitMQProject.dto.TalktimeData;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/recharge")
public class Recharge {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public String RechargeData (@RequestBody Payment payment){
        System.out.println("ONE");
        payment.setPaymentID(UUID.randomUUID().toString());
        TalktimeData talktimeData=new TalktimeData(payment.getPaymentID(),"In Progress");
        System.out.println("TWO");

        rabbitTemplate.convertAndSend(MessagingConfiguration.EXCHANGE,MessagingConfiguration.ROUTINGKEY,payment);
        return "In Progress";
    }

    @GetMapping
    public Payment getpayment(){
        return new Payment("id",12,"uid",true,"orderid");
    }

}
