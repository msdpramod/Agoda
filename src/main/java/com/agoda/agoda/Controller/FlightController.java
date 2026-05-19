package com.agoda.agoda.Controller;


import com.agoda.agoda.dtos.FlightResponse;
import com.agoda.agoda.dtos.SearchRequest;
import com.agoda.agoda.mapper.FlightMapper;
import com.agoda.agoda.model.Flight;
import com.agoda.agoda.service.FlightService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/flights")
@Validated
public class FlightController {

    private final FlightService flightService;
    private final FlightMapper flightMapper;

    public FlightController(FlightService flightService, FlightMapper flightMapper) {
        this.flightService = flightService;
        this.flightMapper = flightMapper;
    }

    @GetMapping
    public ResponseEntity<List<FlightResponse>> search(
            @RequestParam @NotBlank String origin,
            @RequestParam @NotBlank String destination) {
        List<Flight> flights = flightService.search(origin, destination);
        List<FlightResponse> response = flights.stream()
                .map(flightMapper::toFlightResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/search")
    public ResponseEntity<?> searchPost(@Valid @RequestBody SearchRequest request) {
        // This remains the same as before, but we'll unify error handling next
        Optional<List<Flight>> result = Optional.ofNullable(flightService.search(request.getOrigin(), request.getDestination()));
        if (result.isEmpty()) {
            return ResponseEntity.status(404)
                    .body("No flights found for " + request.getOrigin() + " → " + request.getDestination());
        }
        List<FlightResponse> responseList = result.get().stream()
                .map(this::toFlightResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }


    private FlightResponse toFlightResponse(Flight flight) {
        return FlightResponse.builder()
                .id(flight.getId())
                .flightNumber(flight.getFlightNumber())
                .airline(flight.getAirline())
                .origin(flight.getOrigin())
                .destination(flight.getDestination())
                .departureTime(flight.getDepartureTime())
                .departureDate(flight.getDepartureDate())
                .arrivalDate(flight.getArrivalDate())
                .arrivalTime(flight.getArrivalTime())
                .availableSeats(flight.getAvailableSeats())
                .price(flight.getPrice())
                .cabinClass(flight.getCabinClass())
                .build();
    }
}
