package com.spring.msg.rabbitmqproject.springRabbitMQProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TalktimeData {
    public String paymentID;
    public String orderID;
    public int totalBalance;
    public String orderStatus; // payment pending , payment done - delivery initiated, delivered


    public TalktimeData(String paymentID, String orderStatus) {
        this.paymentID=paymentID;
        this.orderStatus=orderStatus;
    }
}
