package com.zopa;

import com.zopa.model.Repayment;
import com.zopa.service.LendingService;
import org.apache.commons.cli.*;

public class Runner {

    public static void main(String[] args){
        System.out.println("Hello World!" + args[0] + ": " + args[1]);
        LendingService service = new LendingService();

        String filename = "";
        int loanAmount = 0;

        try {
            filename = args[1];
            loanAmount = Integer.valueOf(args[0]);
        } catch (Exception e) {
            System.out.println(filename + " " + loanAmount);
            System.exit(1);
        }

        Repayment repayment = service.calculateMonthlyRepayment(loanAmount, LendingService.DEFAULT_DURATION_MONTHS, filename);

        System.out.println("Repayment: " + repayment.getRate() + ": " + repayment.getMonthlyAmount() + ": " + repayment.getTotalAmount());

    }
}
