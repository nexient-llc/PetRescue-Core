package com.systemsinmotion.petrescue.mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/petrescue-core.xml" })
public class MailManagerTest {

	@Autowired
	MailManager mailManager;

	@Test
	public void init() {
		String[] recipients = this.mailManager.getRecipients();
		assertNotNull(recipients);
		assertEquals(3, recipients.length);
	}
}
