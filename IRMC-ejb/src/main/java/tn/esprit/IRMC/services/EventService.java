package tn.esprit.IRMC.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.print.attribute.standard.MediaSize.ISO;

import tn.esprit.IRMC.persistence.Event;
import tn.esprit.IRMC.persistence.EventType;
@Stateless
public class EventService implements EventServiceRemote,EventServiceLocal{
@PersistenceContext

EntityManager em;
	@Override
public void addEvent(Event e) {
em.persist(e);

	}

	@Override
	public void updateEvent(Event e) {
em.merge(e);
	}

	@Override
	public void deleteEvent(int id) {
em.remove(getEventbyId(id));		
	}

	@Override
	public Event getEventbyId(int id) {
		return em.find(Event.class, id);

	}
	@Override
	public void approvebyId(int id) {
         Event e =this.getEventbyId(id);
         e.setApproved(true);
	}

	@Override
	public List<Event> getAllEvent() {
		Query q = em.createQuery("select e from Event e",Event.class);


		return q.getResultList();


	}
	
	
	@Override
	public List<Event> getOnHoldEvent() {
		Query q = em.createQuery("select e from Event e  where e.approved=:x  and e.debut > CURRENT_TIMESTAMP",Event.class);
		q.setParameter("x",false);

                return q.getResultList();


	}
	
	
	

	@Override
	public void test() {
		System.out.println("test");
		
	}

	@Override
	public List<Event> getEventbyCat(EventType et) {
		
		
			
		Query q = em.createQuery("select e from Event e  where  e.type=:y ",Event.class);
		q.setParameter("y",et);
		
        return q.getResultList();

		
	}
}
