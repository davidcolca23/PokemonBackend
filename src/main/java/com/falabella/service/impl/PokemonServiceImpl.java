package com.falabella.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falabella.model.Pokemon;
import com.falabella.repo.IGenericRepo;
import com.falabella.repo.IPokemonRepo;
import com.falabella.service.IPokemonService;

@Service
public class PokemonServiceImpl extends CRUDImpl<Pokemon, Integer> implements IPokemonService {

	@Autowired
	private IPokemonRepo repo;

	@Override
	protected IGenericRepo<Pokemon, Integer> getRepo() {
		return repo;
	}
}
