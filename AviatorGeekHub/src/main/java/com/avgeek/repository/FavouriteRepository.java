package com.avgeek.repository;

import com.avgeek.model.Favourite;
import com.avgeek.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Long> {
    List<Favourite> findByFan(User fan);
    Optional<Favourite> findByFanAndFlightId(User fan, Long flightId);
    boolean existsByFanAndFlightId(User fan, Long flightId);
}
