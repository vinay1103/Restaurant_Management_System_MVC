package com.restaurant.factory;

import com.restaurant.daos.Payment;
import com.restaurant.dtos.PaymentDTO;
import com.restaurant.factoryclass.Card;
import com.restaurant.factoryclass.Cash;

public class PaymentFactory {
    public static Payment getPayment(PaymentDTO paymentDTO) {
        switch (paymentDTO.getPaymentType()) {
            case "Cash":
                return new Cash(paymentDTO.getFee());
            case "Card":
                return new Card(paymentDTO.getFee());
            default:
                throw new IllegalArgumentException("Invalid payment type");
        }
    }
}