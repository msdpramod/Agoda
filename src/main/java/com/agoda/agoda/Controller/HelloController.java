package com.agoda.agoda.Controller;

import com.agoda.agoda.model.Flight;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController("/flights")
public class HelloController {
        @GetMapping("/v1")
        public String hello(){
            return "Hello to Agoda";
        }

    @GetMapping("/flights/sample")
    public Flight getSampleFlight() {
        return new Flight(1L, "Delhi", "Mumbai", LocalDate.now().plusDays(10), 4500.00);
    }

}
