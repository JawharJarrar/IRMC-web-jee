package tn.esprit.IRMC.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.IRMC.persistence.Category;
import tn.esprit.IRMC.persistence.Event;
@Remote
public interface CategoryServiceRemote {
	public List<Category> getAllCat();
	public Category getCatbyId(int id);
	void addCat(Category c);

}
