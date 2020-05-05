package com.fms.repository;
import org.springframework.data.repository.CrudRepository;

import com.fms.dto.Flight;

//repository that extends CrudRepository
public interface FlightRepository extends CrudRepository<Flight, Integer>
{


}
