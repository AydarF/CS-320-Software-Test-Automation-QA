package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService contactService;

    /**
     * Runs before each test
     */
    @BeforeEach
    public void setup() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("12345", "Aydar", "Fayzullin", "1234567890", "1 Wall St");
        contactService.addContact(contact);
        Assertions.assertEquals(contact, contactService.getContact("12345"));
    }

    @Test
    public void testAddDuplicateContact() {
        Contact c1 = new Contact("12345", "Aydar", "Fayzullin", "1234567890", "1 Wall St");
        contactService.addContact(c1);
        Contact c2 = new Contact("12345", "Alyssa", "Freeman", "9876543210", "456 Elm St");
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.addContact(c2));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("12345", "Aydar", "Fayzullin", "1234567890", "1 Wall St");
        contactService.addContact(contact);
        contactService.deleteContact("12345");
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.getContact("12345"));
    }

    @Test
    public void testDeleteNonExistingContact() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("12345"));
    }

    @Test
    public void testUpdateContactFirstName() {
        Contact contact = new Contact("12345", "Aydar", "Fayzullin", "1234567890", "1 Wall St");
        contactService.addContact(contact);
        contactService.updateContactFirstName("12345", "Alyssa");
        Contact updatedContact = contactService.getContact("12345");
        Assertions.assertEquals("Alyssa", updatedContact.getFirstName());
        Assertions.assertEquals("Fayzullin", updatedContact.getLastName());
        Assertions.assertEquals("1234567890", updatedContact.getPhone());
        Assertions.assertEquals("1 Wall St", updatedContact.getAddress());
    }

    @Test
    public void testUpdateContactLastName() {
        Contact contact = new Contact("12345", "Aydar", "Fayzullin", "1234567890", "1 Wall St");
        contactService.addContact(contact);
        contactService.updateContactLastName("12345", "Freeman");
        Contact updatedContact = contactService.getContact("12345");
        Assertions.assertEquals("Aydar", updatedContact.getFirstName());
        Assertions.assertEquals("Freeman", updatedContact.getLastName());
        Assertions.assertEquals("1234567890", updatedContact.getPhone());
        Assertions.assertEquals("1 Wall St", updatedContact.getAddress());
    }

    @Test
    public void testUpdateContactPhone() {
        Contact contact = new Contact("12345", "Aydar", "Fayzullin", "1234567890", "1 Wall St");
        contactService.addContact(contact);
        contactService.updateContactPhone("12345", "9876543210");
        Contact updatedContact = contactService.getContact("12345");
        Assertions.assertEquals("Aydar", updatedContact.getFirstName());
        Assertions.assertEquals("Fayzullin", updatedContact.getLastName());
        Assertions.assertEquals("9876543210", updatedContact.getPhone());
        Assertions.assertEquals("1 Wall St", updatedContact.getAddress());
    }

    @Test
    public void testUpdateContactAddress() {
        Contact contact = new Contact("12345", "Aydar", "Fayzullin", "1234567890", "1 Wall St");
        contactService.addContact(contact);
        contactService.updateContactAddress("12345", "456 Elm St");
        Contact updatedContact = contactService.getContact("12345");
        Assertions.assertEquals("Aydar", updatedContact.getFirstName());
        Assertions.assertEquals("Fayzullin", updatedContact.getLastName());
        Assertions.assertEquals("1234567890", updatedContact.getPhone());
        Assertions.assertEquals("456 Elm St", updatedContact.getAddress());
    }
}