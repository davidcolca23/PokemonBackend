package com.falabella;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.falabella.model.Pokemon;
import com.falabella.repo.IPokemonRepo;

@SpringBootTest
class PokemonBackendApplicationTests {

	@Autowired
	private IPokemonRepo repo;

	@Test
	void contextLoads() {
		Pokemon pokemon = new Pokemon();
		pokemon.setName("Pikachu");
		pokemon.setPower("Electricidad");

		Pokemon pokemonBD = repo.save(pokemon);

		assertTrue(pokemonBD.getName().equals(pokemon.getName()));
	}
}
