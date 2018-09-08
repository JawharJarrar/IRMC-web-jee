package tn.esprit.IRMC.persistence;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
	import java.util.List;


	/**
	 * Entity implementation class for Entity: Event
	 *
	 */
	@Entity
	@Table(name = "evenement")

	public class Event implements Serializable {

		
		
		
		
		
		
	@Override
		public String toString() {
			return "Event [id=" + idEvent + ", nom=" + nom +  type + ", DateDebut=" + debut
					+ ", resume=" + resume + "]";
		}



	


	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEvent;
	private String nom;

	
	





	private String file;
	private String image;





	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public String getFile() {
		return file;
	}



	public void setFile(String file) {
		this.file = file;
	}



	@Enumerated(EnumType.STRING)
	private EventType type;

	
	

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date debut;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")

	private Date fin;
	private String address;
	private Float longitude;
	private boolean approved;
	public boolean isApproved() {
		return approved;
	}



	public void setApproved(boolean approved) {
		this.approved = approved;
	}



	private Float altitude;

	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public Float getLongitude() {
		return longitude;
	}



	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}



	public Float getAltitude() {
		return altitude;
	}



	public void setAltitude(Float altitude) {
		this.altitude = altitude;
	}



	public Date getFin() {
		return fin;
	}



	public void setFin(Date fin) {
		this.fin = fin;
	}



	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}







	private String resume;
	
	@JsonIgnore
	@OneToOne
	private Category category;
		public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int id) {
		this.idEvent = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

		private static final long serialVersionUID = 1L;

		public Event() {
			super();
		}

		public Category getCategory() {
			return category;
		}



public void setCategory(Category category) {
			this.category = category;
		}

		public void setImage1(String pic) {
			// TODO Auto-generated method stub
			
		}
	   
	}
