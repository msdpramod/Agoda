package com.agoda.agoda.Controller;

import com.agoda.agoda.dtos.SearchRequest;
import com.agoda.agoda.model.Flight;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/flights")
public class HelloController {
        @GetMapping("/v1")
        public String hello(){
            return "Hello to Agoda";
        }

        @GetMapping("/sample")
        public Flight getSampleFlight() {
            return new Flight(1L, "Delhi", "Mumbai", LocalDate.now().plusDays(10), 4500.00);
        }
        @GetMapping("/search")
        public String searchFlights(
                @RequestParam String origin,
                @RequestParam String destination) {
            return "Searching flights from " + origin + " to " + destination;
        }

        @PostMapping("/flights/search")
        public String searchFlightsPost(@Valid @RequestBody SearchRequest request) {
            return "Searching (POST) from " + request.getOrigin() + " to " + request.getDestination();
        }


}
