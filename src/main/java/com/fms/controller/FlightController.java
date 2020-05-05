package com.fms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fms.dto.Flight;
import com.fms.service.FlightService;

@RestController
public class FlightController {

	@Autowired
	FlightService flightService;

    //creating a get mapping that retrieves all the flights detail from the database
	@GetMapping("/flight")
	public List<Flight> getAllFlights() {
		return flightService.getAllflights();
	}

    //creating a get mapping that retrieves the detail of a specific flight  
	@GetMapping("/flight/{flightNumber}")
	private Optional<Flight> getFlights(@PathVariable("flightNumber") int flightNumber) {
		return flightService.getFlightsByFlightNumber(flightNumber);
	}

    //creating a delete mapping that deletes a specified flight 
	@DeleteMapping("/flight/{flightNumber}")
	public void deleteFlight(@PathVariable("flightNumber") int flightNumber) {
		flightService.delete(flightNumber);
	}

    //creating post mapping that post the flight detail in the database 
	@PostMapping("/flights")
	public int saveFlight(@RequestBody Flight flights) {
		flightService.saveOrUpdate(flights);
		return flights.getFlightNumber();
	}

    //creating put mapping that updates the flight detail 
	@PutMapping("/flights")
	public Flight update(@RequestBody Flight flights) {
		flightService.saveOrUpdate(flights);
		return flights;
	}
}
