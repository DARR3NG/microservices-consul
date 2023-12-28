package com.elkastali.voitureservice.repository;

import com.elkastali.voitureservice.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
