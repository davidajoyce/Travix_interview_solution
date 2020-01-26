package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

import java.util.List;

public interface FlightService {
    List<BusyFlightsResponse> searchFlights(BusyFlightsRequest request);

    List<ToughJetResponse> searchFlights(ToughJetRequest request);
}
