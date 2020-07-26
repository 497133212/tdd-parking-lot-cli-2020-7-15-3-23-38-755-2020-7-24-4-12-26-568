package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SmartParkingBoyTest {
    @Test
    void should_return_car_ticket_when_park_car_to_more_empty_positions_parking_lot_given_car() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLotA = new ParkingLot(10);
        ParkingLot parkingLotB = new ParkingLot(10);
        ParkingLot parkingLotC = new ParkingLot(10);
        parkingLots.add(parkingLotA);
        parkingLots.add(parkingLotB);
        parkingLots.add(parkingLotC);
        for (int i = 1; i <= 6; i++) {
            Car car = new Car();
            parkingLotA.park(car);
        }
        for (int j = 1; j <= 4; j++) {
            Car car = new Car();
            parkingLotB.park(car);
        }
        for (int j = 1; j <= 8; j++) {
            Car car = new Car();
            parkingLotC.park(car);
        }
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        //when
        CarTicket carTicket = smartParkingBoy.park(car);

        //then
        assertNotNull(carTicket);
    }
}
