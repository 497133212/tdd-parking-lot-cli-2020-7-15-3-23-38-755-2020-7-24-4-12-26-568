package com.oocl.cultivation.test;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static final String NOT_ENOUGH_POSITION = "Not enough position.";
    private static final String UNRECOGNIZED_PARKING_TICKET = "Unrecognized parking ticket.";
    private Map<CarTicket, Car> parkingRooms = new HashMap<>();
    private int capacity;
    private String message;

    public ParkingLot() {
        this.capacity = 10;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getMessage() {
        return message;
    }

    public Map<CarTicket, Car> getParkingRooms() {
        return parkingRooms;
    }

    public CarTicket park(Car car) {
        if (parkingRooms.size() >= capacity) {
            this.message = NOT_ENOUGH_POSITION;
            return null;
        }
        CarTicket carTicket = new CarTicket();
        parkingRooms.put(carTicket, car);
        return carTicket;
    }

    public Car fetch(CarTicket carTicket) {
        Car car = parkingRooms.remove(carTicket);
        if (car == null) {
            this.message = UNRECOGNIZED_PARKING_TICKET;
        }
        return car;
    }
}
