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
public class ArticleServiceImpl implements ArticleService,ArticleServiceRemote {
	
	@PersistenceContext
	EntityManager em;
	@EJB
	ArticleService se;

	@Override
	public Article addArticle(Article a) {
		em.persist(a);
		return a ;
		
	}

	@Override
	public void updateArticle(Article a) {
   em.merge(a);		
	}


	@Override
	public List<Article> getAllArticle() {
		Query q = em.createQuery("select d from Article d",Article.class);
		return q.getResultList();

	}

	@Override
	public void deleteArticle(Integer id) {
		em.remove(getArticlebyid(id));		
	}

	@Override
	public Article getArticlebyid(Integer id) {
		return em.find(Article.class, id);
	}

	@Override
	public void affecterAuteurArticle(Auteur a, Article b) {

		b.getAuteurs().add(a);
		em.merge(b);
		em.flush();
	}

	@Override
	public void affecterReferenceArticle(Reference r, Article b) {
		r.setArticle(b);
		em.merge(r);
		em.flush();
	}

	@Override
	public void affecterTagArticle(Tag t, Article b) {
		b.getTags().add(t);
		em.merge(b);
		em.flush();
		
	}

}
