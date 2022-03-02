package com.falabella.service.impl;

import java.util.List;

import com.falabella.repo.IGenericRepo;
import com.falabella.service.ICRUD;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

	protected abstract IGenericRepo<T, ID> getRepo();

	@Override
	public T save(T t) throws Exception {
		return getRepo().save(t);
	}

	@Override
	public T update(T t) throws Exception {
		return getRepo().save(t);
	}

	@Override
	public List<T> findAll() throws Exception {
		return getRepo().findAll();
	}

	@Override
	public T findById(ID id) throws Exception {
		return getRepo().findById(id).orElse(null);
	}

	@Override
	public void deleteById(ID id) throws Exception {
		getRepo().deleteById(id);
	}
}
