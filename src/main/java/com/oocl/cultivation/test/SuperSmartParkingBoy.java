package com.oocl.cultivation.test;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public CarTicket park(Car car) {
        int count = 0;
        for (int i = 1; i < super.getParkingLots().size(); i++)
            if (((double) (super.getParkingLots().get(i).getCapacity() - super.getParkingLots().get(i).getParkingRooms().size()) / (double) super.getParkingLots().get(i).getCapacity())
                    > ((double) (super.getParkingLots().get(count).getCapacity() - super.getParkingLots().get(count).getParkingRooms().size()) / (double) super.getParkingLots().get(count).getCapacity())) {
                count = i;
            }
        return super.getParkingLots().get(count).park(car);
    }
}
