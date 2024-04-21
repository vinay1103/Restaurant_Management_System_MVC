package com.restaurant.factoryclass;

import com.restaurant.daos.Payment;

public class Cash implements Payment {
    private float fee;

    public Cash(float fee) {
        this.fee = fee;
    }

    public Cash() {
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