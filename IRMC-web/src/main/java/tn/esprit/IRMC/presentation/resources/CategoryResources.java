package tn.esprit.IRMC.presentation.resources;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.IRMC.persistence.Category;
import tn.esprit.IRMC.persistence.Event;
import tn.esprit.IRMC.services.CategoryServiceRemote;
import tn.esprit.IRMC.services.EventServiceRemote;
@Path("cat")
@RequestScoped
public class CategoryResources {
	private String content;
	private List<Category> Categories;

	@EJB
	CategoryServiceRemote service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCats() {
			return Response.ok(service.getAllCat()).build();
		
	}
	

}
