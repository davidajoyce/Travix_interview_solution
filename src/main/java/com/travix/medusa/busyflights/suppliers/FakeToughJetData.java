package com.travix.medusa.busyflights.suppliers;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

public class FakeToughJetData {
    public List<ToughJetResponse> findFlights(ToughJetRequest request) {
        ToughJetResponse firstFlight = new ToughJetResponse();
        firstFlight.setArrivalAirportName("LUT");
        firstFlight.setBasePrice(80);
        firstFlight.setCarrier("Easy Something Jet");
        firstFlight.setDepartureAirportName("DUB");
        firstFlight.setDiscount(10);
        firstFlight.setInboundDateTime(toISOLocalDateFormat("2020-01-26T15:15:00.000"));
        firstFlight.setOutboundDateTime(toISOLocalDateFormat("2020-01-26T17:00:00.000"));
        firstFlight.setTax(20);

        return Collections.singletonList(firstFlight);
    }

    private String toISOLocalDateFormat(String date) {
        return LocalDateTime.parse(date).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
