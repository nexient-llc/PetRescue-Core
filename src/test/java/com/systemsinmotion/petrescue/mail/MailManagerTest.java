package com.systemsinmotion.petrescue.mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.petfinder.entity.AnimalType;
import org.petfinder.entity.PetfinderPetRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.systemsinmotion.petrescue.web.bean.AdoptionApplication;
import com.systemsinmotion.petrescue.web.bean.Entities;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/petrescue-core.xml" })
public class MailManagerTest {

	@Autowired
	MailManager mailManager;

	private Properties props;

	private Session session;

	private AdoptionApplication application;

	private PetfinderPetRecord pet;
	
	private	MimeMessage message;


	@Before
	public void init() {
		props = mailManager.createMailProperties();
		session = mailManager.createSession(props);
		message = new MimeMessage(session);
		application = Entities.getApplication();
		pet = Entities.getPet();
	}

	@Test
	public void shelterRecipients() {
		String[] recipients = this.mailManager.getShelterRecipients();
		assertNotNull(recipients);
		assertEquals(3, recipients.length);
	}

	@Test
	public void adminRecipients() {
		String[] recipients = this.mailManager.getAdminRecipients();
		assertNotNull(recipients);
		assertEquals(1, recipients.length);
	}

	@Test
	public void shelterCatRecipients() {
		String[] recipients = this.mailManager.getShelterCatRecipients();
		assertNotNull(recipients);
		assertEquals(4, recipients.length);
	}

	@Test
	public void shelterDogRecipients() {
		String[] recipients = this.mailManager.getShelterDogRecipients();
		assertNotNull(recipients);
		assertEquals(3, recipients.length);
	}

	@Test
	public void addRecipientsOther() throws AddressException, MessagingException {
		pet.setAnimal(AnimalType.HORSE);
		mailManager.addRecipients(message, application, pet);
		Address[] messageRecipients = message.getAllRecipients();
		String[] expectedRecipients = mailManager.getShelterRecipients();
		
		assertEquals("Expected recipients list to be the same length", expectedRecipients.length,
				messageRecipients.length);
		for (int i = 0; i < expectedRecipients.length; i++)
			assertEquals("Element " + i + " in message recipients does not match", expectedRecipients[i], messageRecipients[i].toString());
	}
	
	@Test
	public void addRecipientsCat() throws AddressException, MessagingException {
		pet.setAnimal(AnimalType.CAT);
		mailManager.addRecipients(message, application, pet);
		Address[] messageRecipients = message.getAllRecipients();
		String[] expectedRecipients = mailManager.getShelterCatRecipients();
		
		assertEquals("Expected recipients list to be the same length", expectedRecipients.length,
				messageRecipients.length);
		for (int i = 0; i < expectedRecipients.length; i++)
			assertEquals("Element " + i + " in message recipients does not match", expectedRecipients[i], messageRecipients[i].toString());
	}

	@Test
	public void addRecipientsDog() throws AddressException, MessagingException {
		pet.setAnimal(AnimalType.DOG);
		mailManager.addRecipients(message, application, pet);
		Address[] messageRecipients = message.getAllRecipients();
		String[] expectedRecipients = mailManager.getShelterDogRecipients();
		
		assertEquals("Expected recipients list to be the same length", expectedRecipients.length,
				messageRecipients.length);
		for (int i = 0; i < expectedRecipients.length; i++)
			assertEquals("Element " + i + " in message recipients does not match", expectedRecipients[i], messageRecipients[i].toString());
	}

	@Test
	public void addRecipientsAdmin() throws AddressException, MessagingException {
		String expectedRecipient = mailManager.getAdminRecipients()[0];
		application.setEmail(expectedRecipient);
		mailManager.addRecipients(message, application, pet);
		Address[] messageRecipients = message.getAllRecipients();
		
		assertEquals(1, messageRecipients.length);
		assertEquals(expectedRecipient, messageRecipients[0].toString());
	}
	
	@Test
	public void addSubject() throws MessagingException {
		application.setPetName("PetName" + Math.random());
		application.setFirstName("FirstName" + Math.random());
		application.setLastName("LastName" + Math.random());
		mailManager.addSubject(message, application);
		String expectedSubject = String.format("%s %s wants to adopt %s", application.getFirstName(), application.getLastName(), application.getPetName());
		
		assertEquals(expectedSubject, message.getSubject());
	}
	
	@Test
	public void getText() throws MessagingException {
		String messageText = mailManager.getText(application, pet);
		
		assertTrue("Did not contain HTML information", messageText.contains("<html>"));
	}
}
