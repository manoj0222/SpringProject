package com.SpringProject.ConceptOFN1Queries;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	private String personName;
	
	@OneToMany(mappedBy = "personName")
	private List<LapTop> listOfLapList;

	@Override
	public String toString() {
		return "Person [id=" + id + ", personName=" + personName + ", listOfLapList=" + listOfLapList + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public List<LapTop> getListOfLapList() {
		return listOfLapList;
	}

	public void setListOfLapList(List<LapTop> listOfLapList) {
		this.listOfLapList = listOfLapList;
	}

}
