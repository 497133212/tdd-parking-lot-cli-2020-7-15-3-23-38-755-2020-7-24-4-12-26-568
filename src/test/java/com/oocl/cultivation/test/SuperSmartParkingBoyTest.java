package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SuperSmartParkingBoyTest {

    @Test
    void should_return_car_ticket_when_park_car_to_larger_available_position_rate_parking_lot_given_car() {
        //given
        ParkingLot parkingLotA = new ParkingLot(10);
        ParkingLot parkingLotB = new ParkingLot(20);
        ParkingLot parkingLotC = new ParkingLot(30);
        List<ParkingLot> parkingLots = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Car car = new Car();
            parkingLotA.park(car);
        }
        for (int j = 1; j <= 9; j++) {
            Car car = new Car();
            parkingLotB.park(car);
        }
        for (int k = 1; k <= 20; k++) {
            Car car = new Car();
            parkingLotC.park(car);
        }
        parkingLots.add(parkingLotA);
        parkingLots.add(parkingLotB);
        parkingLots.add(parkingLotC);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car = new Car();

        //when
        CarTicket carTicket = superSmartParkingBoy.park(car);

        //then
        assertNotNull(carTicket);
    }
}
