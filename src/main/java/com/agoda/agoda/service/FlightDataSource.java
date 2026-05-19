package com.agoda.agoda.service;

import com.agoda.agoda.model.Flight;

import java.util.List;

public interface FlightDataSource {
    List<Flight> getFlights();
}