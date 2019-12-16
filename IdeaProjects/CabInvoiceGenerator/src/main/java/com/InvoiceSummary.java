package com;

import java.util.Objects;

public class InvoiceSummary {
    private final int noOfRides;
    private final double fare;
    private final int avergaeFare;

    public InvoiceSummary(int noOfRides, double fare) {
        this.noOfRides = noOfRides;
        this.fare = fare;
        this.avergaeFare = (int) (fare/noOfRides);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return noOfRides == that.noOfRides &&
                Double.compare(that.fare, fare) == 0 &&
                avergaeFare == that.avergaeFare;
    }

}
