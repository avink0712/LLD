package org.working.parking;

public class Ticket {

    private String ticketId;
    private int spotId;
    private long entryTime;
    private VehicleType vehicleType;

    public Ticket(String ticketId, int spotId, long entryTime, VehicleType vehicleType) {
        this.ticketId = ticketId;
        this.spotId = spotId;
        this.entryTime = entryTime;
        this.vehicleType = vehicleType;
    }

    public String getTicketId() {
        return ticketId;
    }

    public int getSpotId() {
        return spotId;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
