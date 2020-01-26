package com.travix.medusa.busyflights.suppliers;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

import java.util.List;

public class AbstractFlightSupplier implements FlightSupplier {
    @Override
    public List<BusyFlightsResponse> findFlights(BusyFlightsRequest request) {
        return null;
    }

    @Override
    public List<ToughJetResponse> findToughJetFlights(ToughJetRequest request) {
        return null;
    }

    @Override
    public String getSupplierName() {
        return null;
    }
}
