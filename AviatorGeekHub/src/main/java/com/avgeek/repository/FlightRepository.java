package com.avgeek.repository;

import com.avgeek.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByStatus(String status);
    List<Flight> findByOriginContainingIgnoreCaseOrDestinationContainingIgnoreCase(String origin, String destination);
}
