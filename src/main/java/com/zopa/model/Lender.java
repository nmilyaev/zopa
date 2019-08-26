package com.zopa.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Lender implements Comparable<Lender> {

    private String name;
    private float rate;
    private long available;

    @Override
    public int compareTo(Lender o) {
        return this.rate < o.rate ? -1
                : this.rate > o.rate ? 1
                : 0;
    }
}
