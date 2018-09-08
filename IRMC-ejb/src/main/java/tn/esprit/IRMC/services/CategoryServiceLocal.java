package tn.esprit.IRMC.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.IRMC.persistence.Category;
import tn.esprit.IRMC.persistence.Event;
@Local
public interface CategoryServiceLocal {
	public List<Category> getAllCat();
	public Category getCatbyId(int id);
	void addCat(Category c);

}
