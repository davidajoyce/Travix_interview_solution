package com.travix.medusa.busyflights.suppliers;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

import java.util.List;


public interface FlightSupplier {
    List<BusyFlightsResponse> findFlights(BusyFlightsRequest request);

    List<ToughJetResponse> findToughJetFlights(ToughJetRequest request);

    String getSupplierName();
}
