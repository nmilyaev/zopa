package com.zopa.service;

import com.zopa.model.Lender;
import com.zopa.model.Repayment;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Setter
public class LendingService {
    public static int DEFAULT_DURATION_MONTHS = 36;
    public static String DEFAULT_CSVF_FILE = "market-data.csv";

    // TODO : NB this could all be auto-wired using IoC framework, ie Spring
    private RepaymentCalculator calculator = new RepaymentCalculator();
    private FileParser parser = new FileParser();

    public Repayment calculateMonthlyRepayment(int totalAmount, int repaymentPeriod, String filename){
        List<Lender> lenders = parser.readAndParseFile(filename);
        double annualRate = calculateLendersAndRate(totalAmount, lenders);
        BigDecimal monthlyAmount = calculator.calculateMonthlyRepayment(DEFAULT_DURATION_MONTHS, totalAmount, annualRate);
        BigDecimal totalRepayAmount = monthlyAmount.multiply(BigDecimal.valueOf(repaymentPeriod));
        return new Repayment(annualRate, monthlyAmount, totalRepayAmount);
    }

    private double calculateLendersAndRate(int totalAmount, List<Lender> lenders) {
        lenders = lenders.stream().sorted().collect(Collectors.toList());
        long remainder = totalAmount;
        long usedAMount;
        double accumulatedRate = 0;
        for (Lender curr: lenders){
            if (remainder ==0){
                break;
            }
            if (remainder >= curr.getAvailable()){
                remainder = remainder - curr.getAvailable();
                usedAMount = curr.getAvailable();
            }
            else {
                usedAMount = remainder;
            }
            accumulatedRate = accumulatedRate + usedAMount * curr.getRate();
        }
        return accumulatedRate/totalAmount;
    }
}
