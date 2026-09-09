package org.working.parking.strategy;

import org.working.parking.Ticket;
import org.working.parking.VehicleType;

public class DefaultPricingImpl implements PricingStrategy{
    private final long hourlyRate = 10;

    public DefaultPricingImpl() {
    }

    @Override
    public long calculatePrice(Ticket ticket) {
        long currentTime = System.currentTimeMillis();
        long entryTime = ticket.getEntryTime();
        long hour = entryTime/currentTime;
        if(entryTime%currentTime >0){
            hour++;
        }
        return hour*this.hourlyRate;
    }
}
