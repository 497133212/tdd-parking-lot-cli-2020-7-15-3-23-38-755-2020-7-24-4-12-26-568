package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    void should_return_no_car_when_fetch_car_from_parking_lot_given_wrong_car_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        CarTicket wrongTicket = new CarTicket();

        //when
        Car car = parkingLot.fetch(wrongTicket);

        //then
        assertNull(car);
    }

    @Test
    void should_return_no_car_when_fetch_car_from_parking_lot_given_no_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();

        //when
        Car noCar = parkingLot.fetch(null);

        //then
        assertNull(noCar);
    }


    @Test
    void should_return_no_car_when_has_fetch_car_from_parking_lot_given_has_use_car_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        CarTicket carTicket = parkingLot.park(car);
        parkingLot.fetch(carTicket);

        //when
        Car noCar = parkingLot.fetch(carTicket);

        //then
        assertNull(noCar);
    }

    @Test
    void should_return_no_ticket_when_parking_lot_reach_max_capacity_given_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        for(int i=1;i<=10;i++) {
            Car car = new Car();
            parkingLot.park(car);
        }
        Car parkCar = new Car();

        //when
        CarTicket carTicket = parkingLot.park(parkCar);

        //then
        assertNull(carTicket);
    }

    @Test
    void should_print_error_message_when_fetch_car_from_parking_lot_given_wrong_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        CarTicket carTicket = new CarTicket();
        parkingLot.fetch(carTicket);

        //when
        String errorMessage = parkingLot.getMessage();

        //then
        assertEquals("Unrecognized parking ticket", errorMessage);
    }
}
