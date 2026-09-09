package org.working.parking;

import org.working.parking.strategy.DefaultPricingImpl;
import org.working.parking.strategy.ParkingLevel;
import org.working.parking.strategy.PricingStrategy;

import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ParkingLot {
    private final List<ParkingSpot> parkingSpotList;
    private final Set<Integer> unavailableSlot;
    private final Map<String,Ticket> validTicket;
    private PricingStrategy pricingStrategy;
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();


    public ParkingLot(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
        this.unavailableSlot = new HashSet<>();
        this.validTicket = new HashMap<>();
    }

    //synchronized - good option, reterrent lock best option
    public Ticket enter(VehicleType vehicleType){
        while (true) {
            ParkingSpot spot = findAvailableSpot(vehicleType);
            if(spot == null){
                throw  new RuntimeException("No Spot available");
            }
            rwLock.writeLock().lock();
            try {
                if (!this.unavailableSlot.contains(spot.getSpotId())) {
                    this.unavailableSlot.add(spot.getSpotId());
                    Ticket ticket = new Ticket(generateUniqueId(), spot.getSpotId(), System.currentTimeMillis(), vehicleType);
                    this.validTicket.put(ticket.getTicketId(), ticket);
                    System.out.println(vehicleType.toString() + " got entry at spot: " + spot.getSpotId());
                    return ticket;
                }
            }
            finally {
                rwLock.writeLock().unlock();
            }
        }
    }

    private ParkingSpot findAvailableSpot(VehicleType vehicleType){
        SpotType spotType = getParkingSlotByVehicleTypeMap(vehicleType);
        rwLock.readLock().lock();
        try {
            for(ParkingSpot spot: this.parkingSpotList) {
                if (spot.getSpotType().equals(spotType) && !this.unavailableSlot.contains(spot.getSpotId())) {
                    return spot;
                }
            }
            return null;
        } finally {
            rwLock.readLock().unlock();
        }

    }

    public long exit(String ticketId){
        if(ticketId == null || ticketId.isEmpty()){
            throw new RuntimeException("Invalid Ticket Id");
        }
        Ticket ticket = this.validTicket.get(ticketId);
        if(ticket == null){
            throw new RuntimeException("Ticket not found or already used");
        }
       long price = getPricingStrategy(ticket.getVehicleType()).calculatePrice(ticket);
        this.unavailableSlot.remove(ticket.getSpotId());
        this.validTicket.remove(ticketId);
        System.out.println(ticket.getVehicleType().toString() +" got away from spot: "+ticket.getSpotId());
        return price;




    }

    private SpotType getParkingSlotByVehicleTypeMap(VehicleType vehicleType){
        switch (vehicleType){
            case VehicleType.MOTORCYCLE:
                  return SpotType.MOTORCYCLE;
            case VehicleType.CAR:
                return SpotType.CAR;
            case VehicleType.LARGE:
                return SpotType.LARGE;
            default:
                return null;
        }
    }
    private String generateUniqueId(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    private PricingStrategy getPricingStrategy(VehicleType vehicleType){
        return new DefaultPricingImpl();
    }
}
