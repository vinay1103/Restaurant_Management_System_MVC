package com.restaurant.factoryclass;

import com.restaurant.daos.Payment;

public class Card implements Payment {
    private float fee;

    public Card(float fee) {
        this.fee = fee;
    }

    public Card() {
    }

    @Override
    public float calculateAmount(float amount) {
        return amount + fee;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }
}