package com.fosskolkata.springdataoverview.repository;

import com.fosskolkata.springdataoverview.entity.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Long> {

    List<Flight> findByOrigin(String origin);
}
