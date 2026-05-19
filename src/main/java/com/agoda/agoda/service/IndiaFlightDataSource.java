package com.agoda.agoda.service;

import com.agoda.agoda.model.Flight;
import com.agoda.agoda.model.FlightCabinClass;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
class IndiaFlightDataSource implements FlightDataSource {
    @Override
    public List<Flight> getFlights() {
        return List.of(
                Flight.builder()
                        .id(1L).flightNumber("AI-101").airline("Air India")
                        .origin("Delhi").destination("Mumbai")
                        .departureDate(LocalDate.now().plusDays(5))
                        .departureTime(LocalDateTime.now().plusDays(5).withHour(6).withMinute(30))
                        .arrivalTime(LocalDateTime.now().plusDays(5).withHour(8).withMinute(45))
                        .arrivalDate(LocalDate.now().plusDays(5))
                        .availableSeats(120).price(4200).cabinClass(FlightCabinClass.ECONOMY)
                        .build(),
                Flight.builder()
                        .id(2L).flightNumber("UK-860").airline("Vistara")
                        .origin("Delhi").destination("Mumbai")
                        .departureDate(LocalDate.now().plusDays(6))
                        .departureTime(LocalDateTime.now().plusDays(6).withHour(18).withMinute(0))
                        .arrivalTime(LocalDateTime.now().plusDays(6).withHour(20).withMinute(15))
                        .arrivalDate(LocalDate.now().plusDays(6))
                        .availableSeats(80).price(4800).cabinClass(FlightCabinClass.ECONOMY)
                        .build()
        );
    }
}
