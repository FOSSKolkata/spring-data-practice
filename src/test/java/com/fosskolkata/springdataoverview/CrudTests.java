package com.fosskolkata.springdataoverview;

import com.fosskolkata.springdataoverview.entity.Flight;
import com.fosskolkata.springdataoverview.repository.FlightRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class CrudTests {


	@Autowired
	private FlightRepository flightRepository;


	@Test
	void shouldPerformCrudOperations () {
		final Flight flight =new Flight();
		flight.setOrigin("Bangalore");
		flight.setDestination("Kolkata");
		flight.setScheduledAt(LocalDateTime.parse("2023-12-13T12:12:00"));

		flightRepository.save(flight);

		assertThat(flightRepository.findAll())
				.hasSize(1)
				.first()
				.isEqualTo(flight);

		assertThat(flightRepository.findByOrigin("Bangalore"))
				.hasSize(1)
				.first()
				.isEqualTo(flight);

		flightRepository.deleteById(flight.getId());

		assertThat(flightRepository.count()).isZero();


	}
}
