package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    Map<String, ArrayList<Rides>> userName;

    public RideRepository() {
        this.userName = new HashMap<>();
    }


    public Rides[] getRides(String userId) {
        return this.userName.get(userId).toArray(new Rides[0]);
    }

    public void addRides(String userId, Rides[] rides) {
        this.userName.put(userId, new ArrayList<>(Arrays.asList(rides)));
    }

}
