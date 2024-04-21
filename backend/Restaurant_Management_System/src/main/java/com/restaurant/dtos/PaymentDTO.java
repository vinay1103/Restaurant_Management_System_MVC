package com.restaurant.dtos;

public class PaymentDTO {
    private String paymentType;
    private float fee;

    public PaymentDTO() {
    }

    public PaymentDTO(String paymentType, float fee) {
        this.paymentType = paymentType;
        this.fee = fee;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }
}