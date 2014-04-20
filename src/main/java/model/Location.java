package model;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the location database table.
 * 
 */
@Entity
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String city;

	private String country;

	private String region;

	//bi-directional many-to-one association to Pet
	@OneToMany(mappedBy="location")
	private List<Pet> pets;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="location")
	private List<User> users;

	public Location() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public List<Pet> getPets() {
		return this.pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public Pet addPet(Pet pet) {
		getPets().add(pet);
		pet.setLocation(this);

		return pet;
	}

	public Pet removePet(Pet pet) {
		getPets().remove(pet);
		pet.setLocation(null);

		return pet;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setLocation(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setLocation(null);

		return user;
	}

}