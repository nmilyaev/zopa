package com.zopa.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RepaymentCalculatorTest {

    @InjectMocks
    RepaymentCalculator calculator;

    @Test
    public void shouldCalculateRateforExample(){
        BigDecimal repayment = calculator.calculateMonthlyRepayment(36, 1000, 0.07f);
        assertEquals(30.78f, repayment.floatValue(), 0.01d);
    }
}