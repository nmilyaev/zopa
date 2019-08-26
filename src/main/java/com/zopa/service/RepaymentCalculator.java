package com.zopa.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RepaymentCalculator {

    public BigDecimal calculateMonthlyRepayment(int months, int amount, double annualRate){
        double monthlyRate = annualRate/12;
        double result = amount * (monthlyRate + (monthlyRate/(Math.pow(1+monthlyRate, months)-1)));
        BigDecimal bd = BigDecimal.valueOf(result);
        bd = bd.setScale(2, RoundingMode.DOWN);
        return bd;
    }
}
