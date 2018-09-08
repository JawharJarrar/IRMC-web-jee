package tn.esprit.IRMC.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.IRMC.persistence.Category;
import tn.esprit.IRMC.persistence.Event;
import tn.esprit.IRMC.persistence.EventType;

@Local
public interface EventServiceLocal {

	public void addEvent(Event e);
	public void updateEvent(Event e);
	public void deleteEvent(int id);
	public Event getEventbyId(int id);
	public List<Event> getEventbyCat(EventType e);

	public List<Event> getAllEvent();
	public void test();
	public List<Event> getOnHoldEvent();
	public void approvebyId(int id);




}

