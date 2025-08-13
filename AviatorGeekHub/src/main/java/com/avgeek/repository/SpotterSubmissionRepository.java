package com.avgeek.repository;

import com.avgeek.model.SpotterSubmission;
import com.avgeek.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpotterSubmissionRepository extends JpaRepository<SpotterSubmission, Long> {
    List<SpotterSubmission> findBySpotter(User spotter);
    List<SpotterSubmission> findByApproved(boolean approved);
    List<SpotterSubmission> findBySpotterOrderBySubmissionDateDesc(User spotter);
}
