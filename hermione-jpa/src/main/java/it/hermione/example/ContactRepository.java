package it.hermione.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
	
	public Contact save(Contact contact);
	
	public List<Contact> findByFirstName(String firstName);

}
