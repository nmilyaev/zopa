package com.zopa.model;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
public class Repayment {
    private BigDecimal rate;
    private BigDecimal monthlyAmount;
    private BigDecimal totalAmount;

    public Repayment(double rate, BigDecimal monthlyAmount, BigDecimal totalAmount) {
        this.rate = BigDecimal.valueOf(rate);
        this.rate.setScale(2, RoundingMode.HALF_UP);
        this.monthlyAmount = monthlyAmount;
        monthlyAmount.setScale(2, RoundingMode.HALF_UP);
        this.totalAmount = totalAmount;
        this.totalAmount.setScale(2, RoundingMode.HALF_UP);
    }
}
