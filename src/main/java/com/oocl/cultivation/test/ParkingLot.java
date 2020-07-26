package com.oocl.cultivation.test;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<CarTicket, Car> parkingRooms = new HashMap<>();
    private int capacity;
    private String message;

    public ParkingLot() {
        this.capacity = 10;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public String getMessage() {
        return message;
    }

    public Map<CarTicket, Car> getParkingRooms() {
        return parkingRooms;
    }

    public CarTicket park(Car car) {
        if (parkingRooms.size() >= capacity) {
            this.message = "Not enough position.";
            return null;
        }
        CarTicket carTicket = new CarTicket();
        parkingRooms.put(carTicket, car);
        return carTicket;
    }

    public Car fetch(CarTicket carTicket) {
        Car car = parkingRooms.remove(carTicket);
        if (car == null) {
            this.message = "Unrecognized parking ticket.";
        }
        return car;
    }
}
