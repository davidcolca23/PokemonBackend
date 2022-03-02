package com.falabella.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.falabella.model.Pokemon;
import com.falabella.service.IPokemonService;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

	@Autowired
	private IPokemonService service;

	@GetMapping
	public ResponseEntity<List<Pokemon>> findAll() throws Exception {

		List<Pokemon> pokemons = service.findAll();

		return new ResponseEntity<>(pokemons, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pokemon> findById(@PathVariable("id") Integer idPokemon) throws Exception {

		Pokemon pokemon = service.findById(idPokemon);

		if (pokemon == null) {
			throw new Exception("Pokemon ID " + idPokemon + " not found");
		}

		return new ResponseEntity<>(pokemon, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Pokemon> save(@Valid @RequestBody Pokemon pokemonRequest) throws Exception {

		Pokemon pokemon = service.save(pokemonRequest);

		return new ResponseEntity<>(pokemon, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Pokemon> update(@Valid @RequestBody Pokemon pokemonRequest) throws Exception {

		Pokemon pokemonDB = service.findById(pokemonRequest.getIdPokemon());

		if (pokemonDB == null) {
			throw new Exception("Pokemon ID " + pokemonRequest.getIdPokemon() + " not found");
		}

		Pokemon pokemon = service.update(pokemonRequest);

		return new ResponseEntity<>(pokemon, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Integer idPokemon) throws Exception {

		Pokemon pokemon = service.findById(idPokemon);

		if (pokemon == null) {
			throw new Exception("Pokemon ID " + idPokemon + " not found");
		}

		service.deleteById(idPokemon);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
