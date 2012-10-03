package it.hermione.example;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hobby")
public class Hobby implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7593606429714003463L;
	private String hobbyId;
	private Set<Contact> contacts = new HashSet<Contact>();
	
	
	@Id
	@Column (name = "HOBBY_ID")
	public String getHobbyId() {
		return hobbyId;
	}

	public void setHobbyId(String hobbyId) {
		this.hobbyId = hobbyId;
	}
	
	public String toString() {
		return "Hobby: " + getHobbyId();
	}

	@ManyToMany
	@JoinTable (name = "CONTACT_HOBBY_DETAIL", joinColumns = @JoinColumn(name = "HOBBY_ID"), inverseJoinColumns = @JoinColumn(name = "CONTACT_ID"))
	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	
}
