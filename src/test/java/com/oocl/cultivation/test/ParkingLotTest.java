package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void should_fetch_multiple_car_when_fetch_multiple_car_from_parking_lot_given_multiple_car_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car firstCar = new Car();
        Car secondCar = new Car();
        Car thirdCar = new Car();
        CarTicket firstCarTicket = parkingLot.park(firstCar);
        CarTicket secondCarTicket = parkingLot.park(secondCar);
        CarTicket thirdCarTicket = parkingLot.park(thirdCar);

        //when
        Car fetchFirstCar = parkingLot.fetch(firstCarTicket);
        Car fetchSecondCar = parkingLot.fetch(secondCarTicket);
        Car fetchThirdCar = parkingLot.fetch(thirdCarTicket);

        //then
        assertNotNull(fetchFirstCar);
        assertNotNull(fetchSecondCar);
        assertNotNull(fetchThirdCar);
        assertEquals(firstCar, fetchFirstCar);
        assertEquals(secondCar, fetchSecondCar);
        assertEquals(thirdCar, fetchThirdCar);
    }

    @Test
    void should_return_no_car_when_fetch_car_from_parking_lot_given_wrong_car_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        CarTicket carTicket = parkingLot.park(car);
        CarTicket wrongTicket = new CarTicket();

        //when
        Car noCar = parkingLot.fetch(wrongTicket);

        //then
        assertNull(noCar);
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
        ParkingLot parkingLot = new ParkingLot();
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

}
