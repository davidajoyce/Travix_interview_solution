package com.travix.medusa.busyflights.suppliers;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ToughJetSupplier extends AbstractFlightSupplier {
    @Autowired
    private FakeToughJetData fakeToughtJet;

    private static final String SUPPLIER= "ToughJet";

    @Override
    public List<BusyFlightsResponse> findFlights(BusyFlightsRequest request) {
        ToughJetRequest toughJetRequest = changeToRequest(request);
        List<ToughJetResponse> flights = fakeToughtJet.findFlights(toughJetRequest);
        return flights.stream().map(this::changeToResponse).collect(Collectors.toList());
    }

    @Override
    public List<ToughJetResponse> findToughJetFlights(ToughJetRequest request) {
        List<ToughJetResponse> flights = fakeToughtJet.findFlights(request);
        return flights;
    }

    private ToughJetRequest changeToRequest(BusyFlightsRequest request) {
        ToughJetRequest toughJetRequest = new ToughJetRequest();
        toughJetRequest.setFrom(request.getOrigin());
        toughJetRequest.setTo(request.getDestination());
        toughJetRequest.setOutboundDate(request.getDepartureDate());
        toughJetRequest.setInboundDate(request.getReturnDate());
        toughJetRequest.setNumberOfAdults(request.getNumberOfPassengers());

        return toughJetRequest;
    }

    private BusyFlightsResponse changeToResponse(ToughJetResponse response) {
        BusyFlightsResponse busyFlightsResponse = new BusyFlightsResponse();
        busyFlightsResponse.setAirline(response.getCarrier());
        busyFlightsResponse.setSupplier(getSupplierName());
        busyFlightsResponse.setFare(evaluateFare(response.getBasePrice(), response.getTax(), response.getDiscount()));
        busyFlightsResponse.setDepartureAirportCode(response.getDepartureAirportName());
        busyFlightsResponse.setDepartureDate(response.getOutboundDateTime());
        busyFlightsResponse.setDestinationAirportCode(response.getArrivalAirportName());
        busyFlightsResponse.setArrivalDate(response.getInboundDateTime());

        return busyFlightsResponse;
    }

    public double evaluateFare(double basePrice, double tax, double discountPercentage) {
        double fullPrice = basePrice + tax;
        double discountMult = (100.0 - discountPercentage)/100;
        return fullPrice * discountMult;
    }

    @Override
    public String getSupplierName() {
        return SUPPLIER;
    }
}
