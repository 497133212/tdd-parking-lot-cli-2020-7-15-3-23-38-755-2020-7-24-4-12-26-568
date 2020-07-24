package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;


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


}