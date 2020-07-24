package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_given_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        CarTicket ticket = parkingLot.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_fetch_car_when_fetch_from_parking_lot_given_car_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        CarTicket carTicket = parkingLot.park(car);

        //when
        Car fetchCar = parkingLot.fetch(carTicket);

        //then
        assertNotNull(car);
        assertEquals(car, fetchCar);

    }

    @Test
    void should_paking_multiple_car_when_park_given_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car firstCar = new Car();
        Car secondCar = new Car();
        Car thirdCar = new Car();

        //when
        CarTicket firstCarTicket = parkingLot.park(firstCar);
        CarTicket secondCarTicket = parkingLot.park(secondCar);
        CarTicket thirdCarTicket = parkingLot.park(thirdCar);


        //then
        assertNotNull(firstCarTicket);
        assertNotNull(secondCarTicket);
        assertNotNull(thirdCarTicket);
    }
}
