package tn.esprit.IRMC.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.IRMC.persistence.Todo;

@Local
public interface TodoServiceLocal {
	
	void create(Todo todo);
	List<Todo> findAll();

}
