package com.fosskolkata.springdataoverview;

import com.fosskolkata.springdataoverview.entity.Flight;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class SpringDataOverviewApplicationTests {

	@Autowired
	private EntityManager entityManager;


	@Test
	void verifyFlightCanBeSaved () {
		final Flight flight = new Flight();
		flight.setOrigin ("Amsterdam");
		flight.setDestination ("New York");
		flight.setScheduledAt (LocalDateTime.parse("2011-12-13T12:12:00"));
		entityManager.persist (flight);

		final TypedQuery<Flight> results = entityManager
				.createQuery("SELECT f FROM Flight f", Flight.class);

		final List<Flight> resultList = results.getResultList();

		assertThat(resultList)
				.hasSize(1)
				.first()
				.isEqualTo(flight);
	}
}
