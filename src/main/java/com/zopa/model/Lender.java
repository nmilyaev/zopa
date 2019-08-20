package com.zopa.model;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Lender {

    private String name;
    private float rate;
    private long available;
}
