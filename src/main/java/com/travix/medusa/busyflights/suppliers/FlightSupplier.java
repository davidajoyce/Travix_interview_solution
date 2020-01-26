package com.travix.medusa.busyflights.suppliers;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

import java.util.List;


public interface FlightSupplier {
    List<BusyFlightsResponse> findFlights(BusyFlightsRequest request);
}
