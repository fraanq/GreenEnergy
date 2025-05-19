package com.example.Ubicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ubicacion.model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

}
