package tn.esprit.IRMC.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.IRMC.persistence.EventType;

@ManagedBean
@ApplicationScoped
public class Data {
public EventType[] getLanguages(){
	return EventType.values();
}

	

}