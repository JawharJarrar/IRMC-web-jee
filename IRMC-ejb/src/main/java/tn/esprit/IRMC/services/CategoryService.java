package tn.esprit.IRMC.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.IRMC.persistence.Category;
import tn.esprit.IRMC.persistence.Event;
@Stateless
public class CategoryService implements CategoryServiceLocal,CategoryServiceRemote{
	@PersistenceContext
	EntityManager em;
		@Override
		public void addCat(Category c) {
	em.persist(c);		
		}
		@Override
		public Category getCatbyId(int id) {
			return em.find(Category.class,id);

		}
		@Override
		public List<Category> getAllCat() {
			Query q = em.createQuery("select e from Category e",Category.class);
			return q.getResultList();
		}}