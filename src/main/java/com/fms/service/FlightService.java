package com.fms.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.dto.Flight;
import com.fms.repository.FlightRepository;

//defining the business logic 
@Service
public class FlightService 
{
@Autowired
FlightRepository flightRepository;
//getting all flights record by using the method findaAll() of CrudRepository

public List<Flight> getAllflights() 
{
List<Flight> flights = new ArrayList<>();
flightRepository.findAll().forEach(flight1 -> flights.add(flight1));
return flights;
}

//getting a specific flight by using the method findById() of CrudRepository
public Optional<Flight>  getFlightsByFlightNumber(int flightNumber1) 
{
	
return flightRepository.findById(flightNumber1);
}

//saving a specific flight by using the method save() of CrudRepository  
public void saveOrUpdate(Flight flight) 
{
flightRepository.save(flight);
}

//deleting a specific flight by using the method deleteById() of CrudRepository 
public void delete(int flightNumber1) 
{
flightRepository.deleteById(flightNumber1);
}

//updating a flight
public void update(Flight flights, int flightNumber) 
{
flightRepository.save(flights);
}
}