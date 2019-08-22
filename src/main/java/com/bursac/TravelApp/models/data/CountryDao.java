package com.bursac.TravelApp.models.data;

import com.bursac.TravelApp.models.Country;
import com.bursac.TravelApp.models.WanderList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CountryDao extends CrudRepository<Country, Integer> {
}

