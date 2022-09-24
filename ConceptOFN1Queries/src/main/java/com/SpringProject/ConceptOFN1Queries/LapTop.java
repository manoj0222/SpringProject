package com.SpringProject.ConceptOFN1Queries;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class LapTop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private  String lapTopCompanyName;
	
	@ManyToOne
	private Person personName;

	

	@Override
	public String toString() {
		return "LapTop [id=" + id + ", lapTopCompanyName=" + lapTopCompanyName + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLapTopCompanyName() {
		return lapTopCompanyName;
	}

	public void setLapTopCompanyName(String lapTopCompanyName) {
		this.lapTopCompanyName = lapTopCompanyName;
	}

	public Person getPersonName() {
		return personName;
	}

	public void setPersonName(Person personName) {
		this.personName = personName;
	}
	
	
}
