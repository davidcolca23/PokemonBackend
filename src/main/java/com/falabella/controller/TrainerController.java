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

import com.falabella.model.Trainer;
import com.falabella.service.ITrainerService;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

	@Autowired
	private ITrainerService service;

	@GetMapping
	public ResponseEntity<List<Trainer>> findAll() throws Exception {

		List<Trainer> trainers = service.findAll();

		return new ResponseEntity<>(trainers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Trainer> findById(@PathVariable("id") Integer idTrainer) throws Exception {

		Trainer trainer = service.findById(idTrainer);

		if (trainer == null) {
			throw new Exception("Trainer ID " + idTrainer + " not found");
		}

		return new ResponseEntity<>(trainer, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Trainer> save(@Valid @RequestBody Trainer trainerRequest) throws Exception {

		Trainer trainer = service.save(trainerRequest);

		return new ResponseEntity<>(trainer, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Trainer> update(@Valid @RequestBody Trainer trainerRequest) throws Exception {

		Trainer trainerDB = service.findById(trainerRequest.getIdTrainer());

		if (trainerDB == null) {
			throw new Exception("Trainer ID " + trainerRequest.getIdTrainer() + " not found");
		}

		Trainer trainer = service.update(trainerRequest);

		return new ResponseEntity<>(trainer, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Integer idTrainer) throws Exception {

		Trainer trainer = service.findById(idTrainer);

		if (trainer == null) {
			throw new Exception("Trainer ID " + idTrainer + " not found");
		}

		service.deleteById(idTrainer);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
