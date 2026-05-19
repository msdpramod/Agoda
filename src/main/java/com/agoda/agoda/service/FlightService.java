package com.agoda.agoda.service;
import com.agoda.agoda.model.Flight;
import com.agoda.agoda.model.FlightCabinClass;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightService {
    private final List<Flight> flights = new ArrayList<>();

    public FlightService() {
        flights.add(Flight.builder()
                .id(1L)
                .flightNumber("AI-101")
                .airline("Air India")
                .origin("Delhi")
                .destination("Mumbai")
                .departureDate(LocalDate.now().plusDays(5))
                .arrivalDate(LocalDate.now().plusDays(6))
                .arrivalTime(LocalDateTime.now().plusDays(6))
                .departureTime(LocalDateTime.now().plusDays(5))
                .availableSeats(120)
                .price(4200)
                .cabinClass(FlightCabinClass.ECONOMY)
                .build());
        flights.add(Flight.builder()
                .id(2L)
                .flightNumber("UK-860")
                .airline("Vistara")
                .origin("Delhi")
                .destination("Mumbai")
                .departureDate(LocalDate.now().plusDays(6))
                .arrivalDate(LocalDate.now().plusDays(7))
                .arrivalTime(LocalDateTime.now().plusDays(7))
                .departureTime(LocalDateTime.now().plusDays(6))
                .availableSeats(80)
                .price(4800)
                .cabinClass(FlightCabinClass.ECONOMY)
                .build());

        flights.add(Flight.builder()
                .id(3L)
                .flightNumber("SG-307")
                .airline("SpiceJet")
                .origin("Mumbai")
                .destination("Goa")
                .departureDate(LocalDate.now().plusDays(2))
                .arrivalDate(LocalDate.now().plusDays(3))
                .arrivalTime(LocalDateTime.now().plusDays(3))
                .availableSeats(45)
                .price(3200)
                .cabinClass(FlightCabinClass.ECONOMY)
                .build());
    }
    public Optional<List<Flight>> search(String origin, String destination) {
        // Guard against null or blank inputs
        if (origin == null || origin.isBlank() || destination == null || destination.isBlank()) {
            return Optional.empty();  // or throw IllegalArgumentException, but we'll handle in controller
        }

        List<Flight> result = flights.stream()
                .filter(f -> f.getOrigin().equalsIgnoreCase(origin.trim())
                        && f.getDestination().equalsIgnoreCase(destination.trim()))
                .collect(Collectors.toList());

        return result.isEmpty() ? Optional.empty() : Optional.of(result);
    }
}