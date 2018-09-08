package tn.esprit.IRMC.presentation.resources;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import tn.esprit.IRMC.persistence.Event;
import tn.esprit.IRMC.services.CategoryServiceRemote;
import tn.esprit.IRMC.services.EventServiceRemote;

@Path("events")
@RequestScoped
public class EventRessources {

	private String content;
	private List<Event> events;
	protected Event e;
	@EJB
	EventServiceRemote service;
	@EJB
	CategoryServiceRemote service1;
	
	@GET
	@Path("{id}")

	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEvents(@PathParam("id") int id) {
		if ( id == 0) {
			return Response.ok(service.getAllEvent()).build();
		}
		return Response.ok(service.getEventbyId(id)).build();
	}
	@GET
	@Path("all")

	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEvents() {
		
			return Response.ok(service.getAllEvent()).build();
		
	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setEvent(Event e) {
		 service.addEvent(e);
		//if (state != 0)
			return Response.status(Status.OK).entity("Ajout du video avec succes").build();
		//return Response.status(Status.NOT_FOUND).entity("Erreur lors de l'ajout").build();
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteEvent(@PathParam("id") Integer id) {
		service.deleteEvent(id);
		return Response.status(Status.OK).entity("Event Deleted succesfully!!!").build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(value="{id}")
	public Response modifEvent(@PathParam(value="id") Integer i,Event ev) {
		if (i!=null) {
			e = service.getEventbyId(i);
			if (e != null) {
				service.updateEvent(ev);
				 return Response.status(Status.OK).entity("event modifier avec succes").build();
			}
			 return Response.status(Status.NO_CONTENT).entity("Not found").build();

		}
		return Response.status(Status.NOT_FOUND).entity("Erreur lors de modification").build();
	}
	
	
	

}
