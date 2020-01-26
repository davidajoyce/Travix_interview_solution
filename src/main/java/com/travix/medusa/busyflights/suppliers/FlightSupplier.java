package com.travix.medusa.busyflights.suppliers;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

public interface FlightSupplier {
    BusyFlightsResponse findFlights(BusyFlightsResponse request);
}
