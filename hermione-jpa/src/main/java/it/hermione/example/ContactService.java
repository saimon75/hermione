package it.hermione.example;

import java.util.List;

public interface ContactService {

	public Contact save(Contact contact);

	public List<Contact> findAll();

	public List<Contact> findByFirstName(String firstName);

}
