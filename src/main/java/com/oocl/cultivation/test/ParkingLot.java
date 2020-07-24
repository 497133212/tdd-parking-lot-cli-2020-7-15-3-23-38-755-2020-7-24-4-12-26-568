package com.oocl.cultivation.test;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<CarTicket, Car> parkingRooms = new HashMap<>();
    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket();
        parkingRooms.put(carTicket, car);
        return carTicket;
    }

    public Car fetch(CarTicket carTicket) {
        return null;
    }
}
