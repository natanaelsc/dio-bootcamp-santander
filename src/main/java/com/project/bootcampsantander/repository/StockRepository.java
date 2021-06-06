package com.project.bootcampsantander.repository;

import java.time.LocalDate;
import java.util.Optional;

import com.project.bootcampsantander.model.Stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> findByNameAndDate(String name, LocalDate date);
    
}
