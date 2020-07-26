package com.oocl.cultivation.test;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public CarTicket park(Car car) {
        int count = 0;
        for (int i = 0; i < super.getParkingLots().size(); i++) {
            if(super.getParkingLots().get(count).getParkingRooms().size()
                    > super.getParkingLots().get(i).getParkingRooms().size()) {
                count = i;
            }
        }
        return super.getParkingLots().get(count).park(car);
    }
}
