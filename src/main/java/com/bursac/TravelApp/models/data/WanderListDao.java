package com.bursac.TravelApp.models.data;

import com.bursac.TravelApp.models.WanderList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface WanderListDao extends CrudRepository<WanderList, Integer> {
}
