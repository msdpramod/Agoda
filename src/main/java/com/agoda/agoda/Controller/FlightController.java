package com.agoda.agoda.Controller;


import com.agoda.agoda.model.Flight;
import com.agoda.agoda.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public ResponseEntity<?> search(@RequestParam String origin,
                                    @RequestParam String destination) {
        Optional<List<Flight>> result = flightService.search(origin, destination);

        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.status(404)
                    .body("No flights found for " + origin + " → " + destination);
        }
    }
}
