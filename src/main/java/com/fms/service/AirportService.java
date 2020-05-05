package com.fms.service;
import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.dto.Airport;
import com.fms.repository.AirportRepository;

//defining the business logic
@Service
public class AirportService 
{
@Autowired
AirportRepository airportRepository;
//getting all books record by using the method findaAll() of CrudRepository
public List<Airport> getAllAirports() 
{
List<Airport> airports = new ArrayList<Airport>();
airportRepository.findAll().forEach(airport1 -> airports.add(airport1));
return airports;
}
//getting a specific record by using the method findById() of CrudRepository
public Airport getAirportById(String airportCode) 
{
return airportRepository.findById(airportCode).get();
}

}