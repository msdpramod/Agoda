package com.agoda.agoda.service;

import com.agoda.agoda.model.Flight;
import com.agoda.agoda.model.FlightCabinClass;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InternationalFlightDataSource implements  FlightDataSource{
    @Override
    public List<Flight> getFlights() {
        return List.of(
                Flight.builder()
                        .id(10L).flightNumber("EK-507").airline("Emirates")
                        .origin("Delhi").destination("Dubai")
                        .departureDate(LocalDate.now().plusDays(3))
                        .departureTime(LocalDateTime.now().plusDays(3).withHour(4).withMinute(15))
                        .arrivalTime(LocalDateTime.now().plusDays(3).withHour(6).withMinute(50))
                        .arrivalDate(LocalDate.now().plusDays(3))
                        .availableSeats(200).price(28000).cabinClass(FlightCabinClass.ECONOMY)
                        .build()
        );
    }
}
