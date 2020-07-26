package com.oocl.cultivation.test;

import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;
    private String message;


    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public String getMessage() {
        return message;
    }

    public CarTicket park(Car car) {
        int i = 0;
        ParkingLot parkingLot = this.parkingLots.get(i);
        if(parkingLot.getParkingRooms().size()>=10) {
            ++i;
            parkingLot = this.parkingLots.get(i);
        }
        return parkingLot.park(car);
    }

    public Car fetch(CarTicket carTicket) {
        if (carTicket == null) {
            this.message = "Please provide your parking ticket.";
        }
        Car car = null;
        for (ParkingLot parkingLot : parkingLots) {
            car = parkingLot.fetch(carTicket);
        }
        return car;
    }
}
