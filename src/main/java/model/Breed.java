package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the breed database table.
 * 
 */
@Entity
@NamedQuery(name="Breed.findAll", query="SELECT b FROM Breed b")
public class Breed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String description;

	private String title;

	//bi-directional many-to-many association to Pet
	@ManyToMany
	@JoinTable(
		name="pet_has_breed"
		, joinColumns={
			@JoinColumn(name="breed_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="pet_id")
			}
		)
	private List<Pet> pets;

	public Breed() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Pet> getPets() {
		return this.pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

}