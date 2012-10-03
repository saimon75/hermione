package it.hermione.example;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "CONTACT_TEL_DETAIL")
public class ContactTelDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6729361757712053218L;
	private Long id;
	private int version;
	private String telType;
	private String telNumber;
	private Contact contact;

	public ContactTelDetail(String telType, String telNumber) {
		this.telType = telType;
		this.telNumber = telNumber;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Version
	@Column(name = "VERSION")
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(name = "TEL_TYPE")
	public String getTelType() {
		return telType;
	}

	public void setTelType(String telType) {
		this.telType = telType;
	}

	@Column(name = "TEL_NUMBER")
	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Column(name = "CONTACT_ID")
	public Contact getContact() {
		return this.contact;
	}

	public String toString() {
		return "Contact Tel Contact ID: " + this.getContact().getId()
				+ ", Type: " + this.telType + ",Number: " + this.telNumber;
	}
}
