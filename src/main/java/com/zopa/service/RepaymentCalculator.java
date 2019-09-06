package com.zopa.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RepaymentCalculator {

    public BigDecimal calculateMonthlyRepayment(int months, int amount, double annualRate) {
        double monthlyRate = annualRate/12;
        double div = monthlyRate/(Math.pow(1+monthlyRate, months)-1);
        double result = amount * (monthlyRate + (div));
        return convert(result);
    }

    private BigDecimal convert(int value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal convert(double value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP);
    }
}
