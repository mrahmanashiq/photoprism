package com.mrahmanashiq.photoprism.repository;

import com.mrahmanashiq.photoprism.model.PhotoprismModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoprismRepository extends JpaRepository<PhotoprismModel, Integer> {
}
