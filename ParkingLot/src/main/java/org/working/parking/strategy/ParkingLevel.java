package org.working.parking.strategy;

import org.working.parking.ParkingSpot;

import java.util.List;

public class ParkingLevel {
    private int level;
    private final List<ParkingSpot> spots;

    public ParkingLevel(int level, List<ParkingSpot> spots) {
        this.level = level;
        this.spots = spots;
    }
    //getAvailableSpotCount --> int
    //findAvailableSpot --> ParkingSpot
}
