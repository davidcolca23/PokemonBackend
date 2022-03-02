package com.falabella.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tbl_trainer")
public class Trainer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTrainer;

	@NotEmpty(message = "Trainer Name cannot be empty!")
	@Column(name = "name", nullable = false, length = 20)
	private String name;

	public Integer getIdTrainer() {
		return idTrainer;
	}

	public void setIdTrainer(Integer idTrainer) {
		this.idTrainer = idTrainer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
