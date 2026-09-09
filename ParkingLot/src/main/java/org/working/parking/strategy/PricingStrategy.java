package org.working.parking.strategy;

import org.working.parking.Ticket;
import org.working.parking.VehicleType;

public interface PricingStrategy {
    long calculatePrice(Ticket ticket);
}
