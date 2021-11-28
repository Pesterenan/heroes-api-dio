package com.pesterenan.heroesapi.repository;

import com.pesterenan.heroesapi.documents.Heroes;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;


@EnableScan
public interface HeroesRepository extends CrudRepository<Heroes, String>{

}
