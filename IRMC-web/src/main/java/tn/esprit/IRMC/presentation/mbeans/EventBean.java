package tn.esprit.IRMC.presentation.mbeans;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import tn.esprit.IRMC.persistence.Category;
import tn.esprit.IRMC.persistence.Event;
import tn.esprit.IRMC.persistence.EventType;
import tn.esprit.IRMC.services.CategoryServiceLocal;
import tn.esprit.IRMC.services.EventServiceLocal;

@ManagedBean
@SessionScoped
public class EventBean  {
	

	@EJB
	EventServiceLocal ev;
	
	@EJB
	CategoryServiceLocal sc;
	private Event event;
	private List<Event> events ;
	private String textSearch="";
	private Boolean accepted ;
    private String catSearch; 
    private Date dateMin;
    private Event EventToShow;
    private Event EventToUpdate;
    private MapModel simpleModel;
    private MapModel pleasework;
    private Marker marker;

	
	public Marker getMarker() {
		return marker;
	}
	public void setMarker(Marker marker) {
		this.marker = marker;
	}
	private UploadedFile image;
	private int hold=0;

    public int getHold() {
		return hold;
	}
	public void setHold(int hold) {
		this.hold = hold;
	}
	String fichier;
    String pic;



	public UploadedFile getFile() {
		return file;
	}
	public void setFile(UploadedFile file) {
		this.file = file;
	}
private UploadedFile file;
public void imageFileUpload(FileUploadEvent e1) throws Exception{

	
	
	this.image=e1.getFile();


	image.write("C:\\wamp64\\www\\IRMC\\"+image.getFileName());


	pic = image.getFileName();


	
	
	}



public void fileUploadListener(FileUploadEvent e) throws Exception{

		
		
		this.file = e.getFile();
		
	 
		
		file.write("C:\\wamp64\\www\\IRMC\\"+file.getFileName());
		

		fichier = file.getFileName();
		
		
		}


    
    private int test;
    public int getTest() {
		return test;
	}
	public Event getEventToUpdate() {
		return EventToUpdate;
	}
	public void setEventToUpdate(Event eventToUpdate) {
		EventToUpdate = eventToUpdate;
	}
	public void setTest(int test) {
		this.test = test;
	}
	public Event getEventToShow() {
		return EventToShow;
	}
	public void setEventToShow(Event eventToShow) {
		EventToShow = eventToShow;
	}
	public Date getDateMin() {
		return dateMin;
	}
	public void setDateMin(Date dateMin) {
		this.dateMin = dateMin;
	}
	private EventType type;
	
	
	public EventType getType() {
		return type;
	}
	public void setType(EventType type) {
		this.type = type;
	}
	public String getCatSearch() {
		return catSearch;
	}
	public void setCatSearch(String catSearch) {
		this.catSearch = catSearch;
	}
	public String getTextSearch() {
		return textSearch;
	}
	public void setTextSearch(String textSearch) {
		this.textSearch = textSearch;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	private List<Category> categories;
	private int categ;
	
	public int getCateg() {
		return categ;
	}
	public void setCateg(int categ) {
		this.categ = categ;
	}
	private EventType[] types;
	
	
	
	
	
	
	
	public EventType[] getTypes() {
		return EventType.values();
	}
	public void setTypes(EventType[] types) {
		this.types = types;
	}
	
	public EventServiceLocal getEv() {
		return ev;
	}
	public void setEv(EventServiceLocal ev) {
		this.ev = ev;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	@PostConstruct
	public void init(){
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, +4);
		pleasework = new DefaultMapModel();

		dateMin = cal.getTime();
             events=ev.getAllEvent();
		 for ( Event ex : events) {
			 if (ex.isApproved()==false);
			 this.hold++;
			 
			 
		 }
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, hold+"New Events", "new events need to be treated"));


		
		categories=sc.getAllCat();
		this.getTypes();
		event = new Event();
	}
	public CategoryServiceLocal getSc() {
		return sc;
	}
	public void setSc(CategoryServiceLocal sc) {
		this.sc = sc;
	}
	public void ajouter() throws Exception{
		

		
		Category c = new Category();

		c =sc.getCatbyId(categ);
		
		  
		event.setFile(this.fichier);
		event.setImage(this.pic);
		//event.setCategory(c);
	
ev.addEvent(event);		
ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
ec.invalidateSession();

ec.redirect(ec.getRequestContextPath() + "/pages/event/allEvent.jsf");
	}
	public UploadedFile getImage() {
		return image;
	}
	public void setImage(UploadedFile image) {
		this.image = image;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		events = events;
	}
	public void List(){
		
		System.out.println();

		
		Category c = new Category();
		 c =sc.getCatbyId(categ);
	//event.setCategory(c);
	event.setApproved(true);
	System.out.println("filename"+file.getSize());
ev.addEvent(event);		
	}
	public void accept(Event e){
      event=ev.getEventbyId(e.getIdEvent());	
      event.setApproved(true);
      ev.updateEvent(event);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You've accepted this event successfully"));

      events=ev.getAllEvent();

	}
	public void preUpdate(int id) throws IOException{
		  EventToUpdate=ev.getEventbyId(id);
			
			FacesContext fContext = FacesContext.getCurrentInstance();
			ExternalContext extContext = fContext.getExternalContext();
			extContext.redirect(extContext.getRequestContextPath() + "/pages/event/modifierEvent.jsf");
			
		
	
		}
	public void Update(){
	      ev.updateEvent(EventToUpdate);
	      try {
				 
				 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
				 ec.invalidateSession();
				 ec.redirect(ec.getRequestContextPath() + "/pages/event/allEvent.jsf");
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	      
	 

	
	public void remove(Event e ){
		ev.deleteEvent(e.getIdEvent());	
		FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Successful",  "deleted successfully " ) );

		events=ev.getAllEvent();
		
	}
	public void search(){
		events=ev.getEventbyCat(type);
	}
	

	
	
	
	
	public void backToList() throws IOException{
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.invalidateSession();

	ec.redirect(ec.getRequestContextPath() + "/pages/event/allEvent.jsf");
		
	}
	
	
	
	
	
	
	
	
	public void show(int id)  throws IOException  {
       EventToShow=ev.getEventbyId(id);
       simpleModel = new DefaultMapModel();
       LatLng coord1 = new LatLng(EventToShow.getAltitude(), EventToShow.getLongitude());

	simpleModel.addOverlay(new Marker(coord1, EventToShow.getNom()+":starts"+EventToShow.getDebut()));
		System.out.println(EventToShow.getIdEvent());
		FacesContext fContext = FacesContext.getCurrentInstance();
		ExternalContext extContext = fContext.getExternalContext();
		extContext.redirect(extContext.getRequestContextPath() + "/pages/event/showEvent.jsf");
		
	

	}
	
	   public void onMarkerSelect(OverlaySelectEvent evento) {
	        marker = (Marker) evento.getOverlay();
	    }
	public void showAll()  throws IOException  {
	       
	       simpleModel = new DefaultMapModel();
	       LatLng coord1;
	       for(Event em:events){
	    	   if (em.getAltitude()!=null){
	    	   coord1 = new LatLng(em.getAltitude(), em.getLongitude());

	   		simpleModel.addOverlay(new Marker(coord1,em.getNom()+":starts at"+em.getDebut(),"http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));
	   		}
	       }
	       
		
			FacesContext fContext = FacesContext.getCurrentInstance();
			ExternalContext extContext = fContext.getExternalContext();
			extContext.redirect(extContext.getRequestContextPath() + "/pages/event/allmap.jsf");
			
		

		}
	
	


	

	
	public MapModel getPleasework() {
		return pleasework;
	}
	public void setPleasework(MapModel pleasework) {
		this.pleasework = pleasework;
	}
	public MapModel getSimpleModel() {
		return simpleModel;
	}
	public void setSimpleModel(MapModel simpleModel) {
		this.simpleModel = simpleModel;
	}
	public Boolean getAccepted() {
		return accepted;
	}
	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}
	 public void info() {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", hold+"Events need to be approved "));
	    }

}

