package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingBoyTest {
    @Test
    void should_return_ticket_when_park_given_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();

        //when
        CarTicket ticket = parkingBoy.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_fetch_car_when_fetch_from_parking_lot_given_car_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        CarTicket carTicket = parkingBoy.park(car);

        //when
        Car fetchCar = parkingBoy.fetch(carTicket);

        //then
        assertNotNull(car);
        assertEquals(car, fetchCar);
    }

    @Test
    void should_parking_multiple_car_when_park_given_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car carA = new Car();
        Car carB = new Car();

        //when
        CarTicket carATicket = parkingBoy.park(carA);
        CarTicket carBTicket = parkingBoy.park(carB);

        //then
        assertNotNull(carATicket);
        assertNotNull(carBTicket);
    }

    @Test
    void should_fetch_multiple_car_when_fetch_multiple_car_from_parking_lot_given_multiple_car_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car carA = new Car();
        Car carB = new Car();
        CarTicket carATicket = parkingBoy.park(carA);
        CarTicket carBTicket = parkingBoy.park(carB);

        //when
        Car fetchCarA = parkingBoy.fetch(carATicket);
        Car fetchCarB = parkingBoy.fetch(carBTicket);

        //then
        assertNotNull(fetchCarA);
        assertNotNull(fetchCarB);
        assertEquals(carA, fetchCarA);
        assertEquals(carB, fetchCarB);
    }

    @Test
    void should_print_error_message_when_fetch_car_from_parking_lot_given_no_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.fetch(null);

        //when
        String message = parkingBoy.getMessage();

        //then
        assertEquals("Please provide your parking ticket.", message);
    }

    @Test
    void should_return_car_ticket_when_park_car_in_multiple_parking_lot_given_Car() {
        //given
        ParkingLot parkingLotA = new ParkingLot();
        ParkingLot parkingLotB = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLotA);
        parkingLots.add(parkingLotB);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (int i = 1; i < 17; i++) {
            Car car = new Car();
            parkingBoy.park(car);
        }
        Car parkCar = new Car();

        //when
        CarTicket carTicket = parkingBoy.park(parkCar);

        //then
        assertNotNull(carTicket);
    }
}
