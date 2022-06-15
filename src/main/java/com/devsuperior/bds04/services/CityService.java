package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repositories.CityRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepositories cityRepositories;

    @Transactional(readOnly = true)
    public List<CityDTO> findAll() {
        List<City> list = cityRepositories.findAll();
        return list.stream().map(x -> new CityDTO(x)).collect(Collectors.toList());

    }

    @Transactional
    public CityDTO insert(CityDTO dto) {
        City entity = new City();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity = cityRepositories.save(entity);
        return new CityDTO(entity);
    }
}
