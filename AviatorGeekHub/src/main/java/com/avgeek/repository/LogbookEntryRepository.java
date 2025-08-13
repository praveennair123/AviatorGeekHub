package com.avgeek.repository;

import com.avgeek.model.LogbookEntry;
import com.avgeek.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogbookEntryRepository extends JpaRepository<LogbookEntry, Long> {
    List<LogbookEntry> findByPilot(User pilot);
    List<LogbookEntry> findByPilotOrderByFlightDateDesc(User pilot);
}
