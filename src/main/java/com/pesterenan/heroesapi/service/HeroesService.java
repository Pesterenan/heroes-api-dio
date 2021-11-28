package com.pesterenan.heroesapi.service;

import org.springframework.stereotype.Service;

import com.pesterenan.heroesapi.documents.Heroes;
import com.pesterenan.heroesapi.repository.HeroesRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HeroesService {
	private final HeroesRepository heroRepo;

	public HeroesService(HeroesRepository heroRepo) {
		this.heroRepo = heroRepo;
	}

	public Flux<Heroes> findAll() {
		return Flux.fromIterable(this.heroRepo.findAll());
	}

	public Mono<Heroes> findById(String id) {
		return Mono.justOrEmpty(this.heroRepo.findById(id));
	}

	public Mono<Heroes> save(Heroes heroes){
		return Mono.justOrEmpty(this.heroRepo.save(heroes));
	}
	
	public Mono<Boolean> deleteById(String id){
		this.heroRepo.deleteById(id);
		return Mono.just(true);
		
	}
}
