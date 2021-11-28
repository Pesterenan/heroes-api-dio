package com.pesterenan.heroesapi.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.pesterenan.heroesapi.documents.Heroes;


@EnableScan
public interface HeroesRepository extends CrudRepository<Heroes, String>{

}
