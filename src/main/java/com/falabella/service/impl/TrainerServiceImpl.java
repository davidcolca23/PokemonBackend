package com.falabella.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falabella.model.Trainer;
import com.falabella.repo.IGenericRepo;
import com.falabella.repo.ITrainerRepo;
import com.falabella.service.ITrainerService;

@Service
public class TrainerServiceImpl extends CRUDImpl<Trainer, Integer> implements ITrainerService {

	@Autowired
	private ITrainerRepo repo;

	@Override
	protected IGenericRepo<Trainer, Integer> getRepo() {
		return repo;
	}
}
