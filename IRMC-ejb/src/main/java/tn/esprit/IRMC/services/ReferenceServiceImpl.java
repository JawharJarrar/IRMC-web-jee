package tn.esprit.IRMC.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.IRMC.persistence.Article;
import tn.esprit.IRMC.persistence.Auteur;
import tn.esprit.IRMC.persistence.Reference;
import tn.esprit.IRMC.persistence.Tag;

@Stateless
@LocalBean
public class ReferenceServiceImpl implements ReferenceService,ReferenceServiceRemote {
	
	@PersistenceContext
	EntityManager em;
	@EJB
	ReferenceService se;

	



	@Override
	public Reference addReference(Reference r) {
		em.persist(r);
		return r ;
	
	}



	@Override
	public List<Reference> getAllReference() {
		Query q = em.createQuery("select d from reference d",Reference.class);
		return q.getResultList();
	}



	@Override
	public Tag addTag(Tag t) {
		em.persist(t);
		return t ;
		
	}



	@Override
	public List<Tag> getAllTag() {
		Query q = em.createQuery("select d from Tag d",Tag.class);
		return q.getResultList();	}

}
