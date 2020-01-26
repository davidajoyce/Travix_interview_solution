package com.travix.medusa.busyflights.domain.busyflights;

import java.math.BigDecimal;

public class BusyFlightsResponse {
    private String supplier;
    private String airline;
    private String departureAirportCode;
    private String destinationAirportCode;
    private String departureDate;
    private String arrivalDate;
    private double fare;

    public boolean isValid() {
        return true;
    }

    public Integer getFare() {
        return Integer.valueOf(0);
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

}
