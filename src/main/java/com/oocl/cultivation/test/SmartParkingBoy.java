package com.oocl.cultivation.test;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public CarTicket park(Car car) {
        int count = 0;
        for(int i=0;i<super.getParkingLots().size()-1;i++) {
            count = (super.getParkingLots().get(i).getParkingRooms().size() > super.getParkingLots().get(i+1).getParkingRooms().size()) ? (i + 1) : i;
        }
        return super.getParkingLots().get(count).park(car);
    }
}
