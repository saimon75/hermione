package it.hermione.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

@Service("springJpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public Contact save(Contact contact) {

		if (contact.getId() == null) {
			em.persist(contact);
			return contact;
		} else {
			return em.merge(contact);
		}
	}

	@Transactional(readOnly = true)
	public List<Contact> findAll() {
		System.out.println("findAll");
		return Lists.newArrayList(contactRepository.findAll());
	}

	@Transactional(readOnly = true)
	public List<Contact> findByFirstName(String firstName) {
		System.out.println("first name " + firstName);
		return contactRepository.findByFirstName(firstName);
	}

}
