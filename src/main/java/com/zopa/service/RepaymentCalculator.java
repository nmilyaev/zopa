package com.zopa.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RepaymentCalculator {

    public BigDecimal calculateMonthlyRepayment(int months, int amount, double annualRate) {
        BigDecimal monthlyRate = convert(annualRate).divide(convert(12));
        BigDecimal total = convert(amount);
        BigDecimal result = total.multiply(monthlyRate.add(monthlyRate.divide(
                convert(Math.pow(1 + monthlyRate.intValue(), months) - 1)
        )));
        return result;
    }

    private BigDecimal convert(int value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal convert(double value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP);
    }
}
