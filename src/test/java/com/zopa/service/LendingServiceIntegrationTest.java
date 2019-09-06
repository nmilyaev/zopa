package com.zopa.service;

import com.zopa.model.Repayment;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.net.URL;

import static org.junit.Assert.*;

public class LendingServiceIntegrationTest {

    // TODO : calculator and parser could be injected using Spring
    private LendingService service;

    @Before
    public void setup(){
        service = new LendingService();
    }

    @Test
    public void shouldCalculateRepaymentFiguresFor1000(){
        int totalAmount = 1000;
        int repaymentPeriod = 36;
        URL resource = getClass().getClassLoader().getResource("market-data.csv");
        String filename = resource.getPath();
        Repayment repayment = service.calculateMonthlyRepayment(totalAmount, repaymentPeriod, filename);
        assertEquals(30.78, repayment.getMonthlyAmount().doubleValue(), 0.1);
        assertEquals(0.07, repayment.getRate().doubleValue(), 0.001);
        assertEquals(1108.10, repayment.getTotalAmount().doubleValue(), 0.01);
    }

    // TODO - add tests for more test cases
}