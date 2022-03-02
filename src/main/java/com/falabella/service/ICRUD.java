package com.falabella.service;

import java.util.List;

public interface ICRUD<T, ID> {

	T save(T t) throws Exception;

	T update(T t) throws Exception;

	List<T> findAll() throws Exception;

	T findById(ID id) throws Exception;

	void deleteById(ID id) throws Exception;
}
