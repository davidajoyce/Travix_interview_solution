package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class BusyFlightsController {

    private final FlightService flightService;

    @Autowired
    public BusyFlightsController(FlightService flightService){
        this.flightService = flightService;
    }

    @RequestMapping(value = "/getBusyFlightDetails" )
    public List<BusyFlightsResponse> getBusyFlights(@RequestBody BusyFlightsRequest request){
            List<BusyFlightsResponse> response = flightService.searchFlights(request);
            return response;
    }

    @RequestMapping(value = "/getToughJetDetails" )
    public List<ToughJetResponse> getToughFlights(@RequestBody ToughJetRequest request){
        List<ToughJetResponse> response = flightService.searchFlights(request);
        return response;
    }
}
