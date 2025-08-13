package com.avgeek.repository;

import com.avgeek.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    List<Resource> findByCategory(String category);
    List<Resource> findByResourceType(String resourceType);
}
