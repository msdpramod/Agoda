package com.agoda.agoda.service;
import com.agoda.agoda.exception.BadRequestException;
import com.agoda.agoda.exception.ResourceNotFoundException;
import com.agoda.agoda.model.Flight;
import com.agoda.agoda.model.FlightCabinClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

    private static final Logger log = LoggerFactory.getLogger(FlightService.class);
    private final FlightDataSource flightDataSource;


    public FlightService(@Qualifier("indiaFlightDataSource") FlightDataSource flightDataSource) {
        // seed data (unchanged)
        this.flightDataSource = flightDataSource;
    }

    public List<Flight> search(String origin, String destination) {
        log.info("Searching flights from {} to {}", origin, destination);
        if (origin == null || origin.isBlank() || destination == null || destination.isBlank()) {
            throw new BadRequestException("Origin and destination must not be blank");
        }

        List<Flight> allFlights = flightDataSource.getFlights();
        List<Flight> result = allFlights.stream()
                .filter(f -> f.getOrigin().equalsIgnoreCase(origin.trim())
                        && f.getDestination().equalsIgnoreCase(destination.trim()))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            log.warn("No flights found for {} -> {}", origin, destination);
            throw new ResourceNotFoundException(
                    "No flights found from " + origin + " to " + destination);
        }
        log.info("Found {} flights", result.size());
        return result;
    }
}