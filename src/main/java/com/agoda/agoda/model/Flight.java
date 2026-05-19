package com.agoda.agoda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    private long id;
    private String origin;
    private String destination;
    private LocalDate departureDate;
    private double price;
}
