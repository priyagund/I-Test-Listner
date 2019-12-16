package com;

public class InvoiceService {
    private static final double MIN_FARE = 5.0;
    private int COST_PER_TIME = 1;
    private double MINIMUM_COST_PER_KM = 10;
    RideRepository obj = new RideRepository();

    public double calculateFare(double distance, int time) {
        double totalFare=distance*MINIMUM_COST_PER_KM + time*COST_PER_TIME;
        if(totalFare<MIN_FARE)
            return MIN_FARE;
        return totalFare;
    }

    public InvoiceSummary calculateFare(Rides[] rides) {
        double totalFare = 0;
        for (Rides ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }

    public void addRides(String userId, Rides[] rides) {
       obj.addRides(userId,rides);
    }

    public InvoiceSummary getSummary(String userId) {
        return this.calculateFare( obj.getRides(userId));
    }
}
