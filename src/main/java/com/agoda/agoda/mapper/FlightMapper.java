package com.agoda.agoda.mapper;

import com.agoda.agoda.dtos.FlightResponse;
import com.agoda.agoda.model.Flight;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")   // makes it a Spring bean
public interface FlightMapper {
    FlightResponse toFlightResponse(Flight flight);
}