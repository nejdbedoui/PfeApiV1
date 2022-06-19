package com.bprice.bpapipos.repository;

import com.bprice.persistance.model.PubliciteMobile;
import com.bprice.persistance.model.PubliciteSMS;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IPubliciteMobileRepository extends MongoRepository<PubliciteMobile, String> {
List<PubliciteMobile> findAllByFrequenceNotLike(int frequence);
int countAllByFrequenceGreaterThan(int frequence);
PubliciteMobile findByActiveEquals( boolean active);
}
