package com.bursac.TravelApp.models.data;


import com.bursac.TravelApp.models.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ActivityDao extends CrudRepository<Activity, Integer> {
}

