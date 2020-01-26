package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

import java.util.List;

public interface FlightService {
    List<BusyFlightsResponse> searchFlights(BusyFlightsResponse request);
}
