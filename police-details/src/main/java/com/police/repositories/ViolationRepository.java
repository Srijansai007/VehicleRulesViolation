package com.police.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.police.entities.ViolationDetailsEntity;

@Repository
public interface ViolationRepository extends JpaRepository<ViolationDetailsEntity, Integer>{


}
