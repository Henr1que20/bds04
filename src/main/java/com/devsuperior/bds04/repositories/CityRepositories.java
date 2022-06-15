package com.devsuperior.bds04.repositories;

import com.devsuperior.bds04.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepositories extends JpaRepository<City, Long> {
}
