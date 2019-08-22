package com.bursac.TravelApp.models.data;

import com.bursac.TravelApp.models.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface CityDao extends CrudRepository<City, Integer> {
}
