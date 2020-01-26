package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1")
public class BusyFlightsController {

    private final FlightService flightService;

    @Autowired
    public BusyFlightsController(FlightService flightService){
        this.flightService = flightService;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes =  APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public ResponseEntity<List<BusyFlightsResponse>> getFlights(@Valid @RequestBody BusyFlightsResponse request) throws IOException {
            List<BusyFlightsResponse> response = flightService.searchFlights(request);
            return ResponseEntity.ok(response);
    }
}
