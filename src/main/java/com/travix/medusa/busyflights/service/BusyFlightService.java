package com.travix.medusa.busyflights.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.suppliers.FlightSupplier;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BusyFlightService implements FlightService{

    private final List<FlightSupplier> flightSuppliers;

    public BusyFlightService(List<FlightSupplier> suppliers, ObjectMapper objectMapper) {
        this.flightSuppliers = suppliers;
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

    @Override
    public List<ToughJetResponse> searchFlights(ToughJetRequest request) {

        if(!request.isValid()){
            throw new IllegalArgumentException("Invalid request");
        }

        // add an enum for the supplier name instead of using a string here
        List<ToughJetResponse> responses = flightSuppliers.stream()
                .filter(flightSupplier -> flightSupplier.getSupplierName().equals("ToughJet"))
                .map(s -> s.findToughJetFlights(request))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        return responses.stream().sorted(Comparator.comparing(ToughJetResponse::getBasePrice)).collect(Collectors.toList());
    }
}
