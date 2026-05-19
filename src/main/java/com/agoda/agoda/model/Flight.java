package com.agoda.agoda.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flight {
    private Long id;

    @NotBlank(message =  "Flight Number Required")
    private String flightNumber;

    @NotBlank(message = "Airline Required")
    private String airline;

    @NotBlank(message = "Origin Required")
    private String origin;

    @NotBlank(message = "Destination Required")
    private String destination;

    @NotNull
    private LocalDate departureDate;

    @NotNull
    private LocalDate arrivalDate;

    @Positive
    private double price;

    @NotNull
    private LocalDateTime arrivalTime;

    @NotNull
    private LocalDateTime departureTime;

    @NotNull
    @Min(value = 1, message = "Minimum seats should be 1")
    private Integer availableSeats;

    @NotNull
    private FlightCabinClass cabinClass = FlightCabinClass.ECONOMY; //default value



}
