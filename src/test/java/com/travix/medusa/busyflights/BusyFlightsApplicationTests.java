package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.controller.BusyFlightsController;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusyFlightsApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webAppCont;

	@Autowired
	private BusyFlightsController busyFlightsController;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webAppCont).dispatchOptions(true).build();
	}

	@Test
	public void testGetRequest() {
		List<BusyFlightsResponse> flights = busyFlightsController.getFlights(new BusyFlightsRequest());
		assertEquals(1, flights.size());
	}

}
