package com.oocl.cultivation.test;

public class ParkingBoy {
    private ParkingLot parkingLot;
    private String message;


    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public String getMessage() {
        return message;
    }

    public CarTicket park(Car car) {
        return this.parkingLot.park(car);
    }
    public Car fetch(CarTicket carTicket) {
        if(carTicket == null) {
            this.message = "Please provide your parking ticket.";
        }
        return this.parkingLot.fetch(carTicket);
    }
}
