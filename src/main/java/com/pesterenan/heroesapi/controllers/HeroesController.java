package com.pesterenan.heroesapi.controllers;

import static com.pesterenan.heroesapi.constants.HeroesConstant.HEROES_ENDPOINT_LOCAL;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pesterenan.heroesapi.documents.Heroes;
import com.pesterenan.heroesapi.service.HeroesService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class HeroesController {

	HeroesService heroServ;
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(HeroesController.class);

	public HeroesController(HeroesService heroServ) {
		this.heroServ = heroServ;
	}

	@GetMapping(HEROES_ENDPOINT_LOCAL)
	public Flux<Heroes> getAllItems() {
		log.info("Requesting list of all heroes");
		return heroServ.findAll();
	}

	@GetMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
	public Mono<ResponseEntity<Heroes>> findHeroById(@PathVariable String id) {
		log.info("Requesting hero by id: {}", id);
		return heroServ.findById(id).map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping(HEROES_ENDPOINT_LOCAL)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Mono<Heroes> createHero(@RequestBody Heroes hero) {
		log.info("A new hero was created");
		return heroServ.save(hero);
	}

	@DeleteMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Mono<HttpStatus> deleteHeroById(@PathVariable String id) {
		try {
			heroServ.deleteById(id);
			log.info("Deleting a hero with id: {}", id);
		} catch (EmptyResultDataAccessException e) {
			log.info("The hero with id {} doesn't exists.", id);
		}

		return Mono.just(HttpStatus.NOT_FOUND);
	}
}
