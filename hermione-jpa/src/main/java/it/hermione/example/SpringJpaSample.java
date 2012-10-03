package it.hermione.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class SpringJpaSample {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:META-INF/spring/app-context.xml");
		String date = "1975/12/12";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/DD/MM");
		Date utilDate = formatter.parse(date);
		Contact dave = new Contact("Dave", "Matthews", utilDate);
		Contact carter = new Contact("Carter", "aaaaa", utilDate);

		System.out.println(ctx.getBean(ContactService.class).toString());
		createDB();
		ContactService contactService = ctx.getBean(ContactService.class);
		contactService.save(carter);
		contactService.save(dave);
		List<Contact> contacts = contactService.findByFirstName("Carter");
		listContacts(contacts);
		List<Contact> allContacts = contactService.findAll();
		listContacts(allContacts);
	}

	private static void listContacts(List<Contact> contacts) {
		System.out.println("LIST CONTACTS");
		for (Contact contact : contacts) {
			System.out.println("first name " + contact.getFirstName());
		}

	}

	private static void createDB() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		builder.setType(EmbeddedDatabaseType.H2)
				.addScript(new ClassPathResource("schema.sql").getFilename())
				.addScript("test-data.sql").build();
	}
}
