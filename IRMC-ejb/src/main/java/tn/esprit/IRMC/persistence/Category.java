package tn.esprit.IRMC.persistence;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity





public class Category implements Serializable {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idCategory;



public int getIdCategory() {
	return idCategory;
}

public void setIdCategory(int idCategory) {
	this.idCategory = idCategory;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}
private String nom;
	
	private static final long serialVersionUID = 1L;

	public Category() {
		super();
	}
   
}

