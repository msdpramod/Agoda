package com.agoda.agoda.service;
import com.agoda.agoda.exception.BadRequestException;
import com.agoda.agoda.exception.ResourceNotFoundException;
import com.agoda.agoda.model.Flight;
import com.agoda.agoda.model.FlightCabinClass;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {
    private final List<Flight> flights = new ArrayList<>();


    public FlightService() {
        // seed data (unchanged)
        flights.add(Flight.builder()
                .id(1L).flightNumber("AI-101").airline("Air India")
                .origin("Delhi").destination("Mumbai")
                .departureDate(LocalDate.now().plusDays(5))
                .departureTime(LocalDateTime.now().plusDays(5).withHour(6).withMinute(30))
                .arrivalTime(LocalDateTime.now().plusDays(5).withHour(8).withMinute(45))
                .arrivalDate(LocalDate.now().plusDays(5))
                .availableSeats(120).price(4200).cabinClass(FlightCabinClass.ECONOMY)
                .build());
        flights.add(Flight.builder()
                .id(2L).flightNumber("UK-860").airline("Vistara")
                .origin("Delhi").destination("Mumbai")
                .departureDate(LocalDate.now().plusDays(6))
                .departureTime(LocalDateTime.now().plusDays(6).withHour(18).withMinute(0))
                .arrivalTime(LocalDateTime.now().plusDays(6).withHour(20).withMinute(15))
                .arrivalDate(LocalDate.now().plusDays(6))
                .availableSeats(80).price(4800).cabinClass(FlightCabinClass.ECONOMY)
                .build());
        flights.add(Flight.builder()
                .id(3L).flightNumber("SG-307").airline("SpiceJet")
                .origin("Mumbai").destination("Goa")
                .departureDate(LocalDate.now().plusDays(2))
                .departureTime(LocalDateTime.now().plusDays(2).withHour(10).withMinute(15))
                .arrivalDate(LocalDate.now().plusDays(2))
                .arrivalTime(LocalDateTime.now().plusDays(2).withHour(11).withMinute(45))
                .availableSeats(45).price(3200).cabinClass(FlightCabinClass.ECONOMY)
                .build());
    }

    public List<Flight> search(String origin, String destination) {
        if (origin == null || origin.isBlank() || destination == null || destination.isBlank()) {
            throw new BadRequestException("Origin and destination must not be blank");
        }

        List<Flight> result = flights.stream()
                .filter(f -> f.getOrigin().equalsIgnoreCase(origin.trim())
                        && f.getDestination().equalsIgnoreCase(destination.trim()))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No flights found from " + origin + " to " + destination
            );
        }
        return result;
    }
}