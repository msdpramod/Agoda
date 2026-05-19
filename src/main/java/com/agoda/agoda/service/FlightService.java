package com.agoda.agoda.service;
import com.agoda.agoda.model.Flight;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {
    private final List<Flight> flights = new ArrayList<>();

    public FlightService() {
        // seed data
        flights.add(new Flight(1L, "Delhi", "Mumbai", LocalDate.now().plusDays(5), 4200));
        flights.add(new Flight(2L, "Delhi", "Mumbai", LocalDate.now().plusDays(6), 4800));
        flights.add(new Flight(3L, "Mumbai", "Goa", LocalDate.now().plusDays(2), 3200));
    }

    public List<Flight> search(String origin, String destination) {
        return flights.stream()
                .filter(f -> f.getOrigin().equalsIgnoreCase(origin)
                        && f.getDestination().equalsIgnoreCase(destination))
                .collect(Collectors.toList());
    }
}