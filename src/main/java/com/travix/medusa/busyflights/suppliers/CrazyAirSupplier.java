package com.travix.medusa.busyflights.suppliers;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CrazyAirSupplier extends AbstractFlightSupplier {

    private static final String SUPPLIER = "CrazyAir";

    @Override
    public List<BusyFlightsResponse> findFlights(BusyFlightsRequest request) {
        CrazyAirRequest crazyAirRequest = changeToRequest(request);
        List<CrazyAirResponse> flights = searchForFlights(crazyAirRequest);
        return flights.stream().map(this::changeToResponse).collect(Collectors.toList());
    }

    @Override
    public List<ToughJetResponse> findToughJetFlights(ToughJetRequest request) {
        return null;
    }

    private BusyFlightsResponse changeToResponse(CrazyAirResponse crazyAirResponse) {
        BusyFlightsResponse busyFlightsResponse = new BusyFlightsResponse();
        busyFlightsResponse.setAirline(crazyAirResponse.getAirline());
        busyFlightsResponse.setSupplier(getSupplierName());
        busyFlightsResponse.setFare(crazyAirResponse.getPrice());
        busyFlightsResponse.setDepartureAirportCode(crazyAirResponse.getDestinationAirportCode());
        busyFlightsResponse.setDestinationAirportCode(crazyAirResponse.getDestinationAirportCode());
        busyFlightsResponse.setDepartureDate(crazyAirResponse.getDepartureDate());
        busyFlightsResponse.setArrivalDate(crazyAirResponse.getArrivalDate());

        return busyFlightsResponse;
    }

    @Override
    public String getSupplierName() {
        return SUPPLIER;
    }

    private List<CrazyAirResponse> searchForFlights(CrazyAirRequest crazyAirRequest) {
        // create fake data for the crazy air flight
        return Collections.emptyList();
    }

    private CrazyAirRequest changeToRequest(BusyFlightsRequest request) {
        CrazyAirRequest crazyAirRequest = new CrazyAirRequest();
        crazyAirRequest.setOrigin(request.getOrigin());
        crazyAirRequest.setDestination(request.getDestination());
        crazyAirRequest.setDepartureDate(request.getDepartureDate());
        crazyAirRequest.setReturnDate(request.getReturnDate());
        crazyAirRequest.setPassengerCount(request.getNumberOfPassengers());

        return crazyAirRequest;
    }
}
