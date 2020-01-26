package com.travix.medusa.busyflights.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.suppliers.FlightSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BusyFlightService implements FlightService{

    private final List<FlightSupplier> flightSuppliers;
    private final ObjectMapper objectMapper;

    public BusyFlightService(List<FlightSupplier> suppliers, ObjectMapper objectMapper) {
        this.flightSuppliers = suppliers;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<BusyFlightsResponse> searchFlights(BusyFlightsRequest request) {

        if(!request.isValid()){
            throw new IllegalArgumentException("Invalid request");
        }

        List<BusyFlightsResponse> responses = flightSuppliers.stream()
                                                .map(s -> s.findFlights(request))
                                                .flatMap(List::stream)
                                                .collect(Collectors.toList());

        return responses.stream().sorted(Comparator.comparing(BusyFlightsResponse::getFare)).collect(Collectors.toList());
    }
}
