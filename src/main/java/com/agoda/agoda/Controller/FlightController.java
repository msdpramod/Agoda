package com.agoda.agoda.Controller;


import com.agoda.agoda.model.Flight;
import com.agoda.agoda.service.FlightService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> search(@RequestParam String origin,
                               @RequestParam String destination) {
        return flightService.search(origin, destination);
    }
}
