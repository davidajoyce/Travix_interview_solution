package com.travix.medusa.busyflights.suppliers;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ToughJetSupplier implements FlightSupplier {
    private FakeToughJetData fakeToughtJet;

    private static final String SUPPLIER= "ToughJet";


    @Override
    public List<BusyFlightsResponse> findFlights(BusyFlightsRequest request) {
        ToughJetRequest toughJetRequest = changeToRequest(request);
        List<ToughJetResponse> flights = fakeToughtJet.findFlights(toughJetRequest);
    
        return flights.stream().map(this::changeToResponse).collect(Collectors.toList());
    }

    private ToughJetRequest changeToRequest(BusyFlightsRequest request) {
        ToughJetRequest toughJetRequest = new ToughJetRequest();
        toughJetRequest.setFrom(request.getOrigin());
        toughJetRequest.setTo(request.getDestination());
        toughJetRequest.setTo(request.getDepartureDate());
        toughJetRequest.setInboundDate(request.getReturnDate());
        toughJetRequest.setNumberOfAdults(request.getNumberOfPassengers());

        return toughJetRequest;
    }

    private BusyFlightsResponse changeToResponse(ToughJetResponse response) {
        BusyFlightsResponse busyFlightsResponse = new BusyFlightsResponse();
        busyFlightsResponse.setSupplier(getSupplierName());

        busyFlightsResponse.setAirline(response.getCarrier());

        busyFlightsResponse.setDepartureAirportCode(response.getDepartureAirportName());
        busyFlightsResponse.setDepartureDate(response.getOutboundDateTime());

        busyFlightsResponse.setDestinationAirportCode(response.getArrivalAirportName());
        busyFlightsResponse.setArrivalDate(response.getInboundDateTime());

        busyFlightsResponse.setFare(evaluatePrice(response.getBasePrice(), response.getTax(), response.getDiscount()));

        return busyFlightsResponse;
    }

    private double evaluatePrice(double basePrice, double tax, double discountPercentage) {
        double fullPrice = basePrice + tax;
        double discountMult = (100.0 - discountPercentage)/100;
        return fullPrice * discountMult;
    }

    private String getSupplierName() {
        return SUPPLIER;
    }
}
