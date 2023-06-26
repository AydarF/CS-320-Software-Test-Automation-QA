/**
 * Aydar Fayzullin
 * CS-320 Software Test Automation& QA
 * 3-2 Milestone: Contact Service REVISED
 */
package org.example;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts;
	private final int CHARACTER_LENGTH = 10;
	private final int PHONE_LENGTH = 10;
    private final int CONTACT_ADDRESS_LENGTH = 30;

    /**
     * Default constructor
     */
    public ContactService() {
        this.contacts = new HashMap<>();
    }

    /**
     * This function checks if the contact already exists and adds contacts with a unique ID.
     */
    public void addContact(Contact contact) {
        String contactId = contact.getContactId();
        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with this ID " + contactId + " already exists.");
        }
        contacts.put(contactId, contact);
    }

    /**
     * This function checks if the contact exists and deletes the contact.
     */
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with this ID " + contactId + " does not exist.");
        }
        contacts.remove(contactId);
    }

    /**
     * This function validates the contact and updates the contact fields per contact ID.
     */
    /** public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with this ID " + contactId + " does not exist.");
        }
        Contact contact = contacts.get(contactId);
        // Update fields if the new values are not null
        if (firstName != null) {
            checkFirstName(firstName);
            contact = new Contact(contact.getContactId(), firstName, contact.getLastName(), contact.getPhone(), contact.getAddress());
        }
        if (lastName != null) {
            checkLastName(lastName);
            contact = new Contact(contact.getContactId(), contact.getFirstName(), lastName, contact.getPhone(), contact.getAddress());
        }
        if (phone != null) {
            checkPhone(phone);
            contact = new Contact(contact.getContactId(), contact.getFirstName(), contact.getLastName(), phone, contact.getAddress());
        }
        if (address != null) {
            checkAddress(address);
            contact = new Contact(contact.getContactId(), contact.getFirstName(), contact.getLastName(), contact.getPhone(), address);
        }
        contacts.put(contactId, contact);
    } */
	
	
	/**
     * This function checks if the contact's id exists in the contact's hash map
		validates the contact's first name and updates the contact's first name per contact ID.
     */
	public void updateContactFirstName(String contactId, String firstName){
		if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with this ID " + contactId + " does not exist.");
        }
        Contact contact = contacts.get(contactId);
        // Update fields if the new values are not null
        if (firstName != null) {
            checkFirstName(firstName);
            contact = new Contact(contact.getContactId(), firstName, contact.getLastName(), contact.getPhone(), contact.getAddress());
        }
		contacts.put(contactId, contact);
	}
	
	/**
     * This function checks if the contact's id exists in the contact's hash map
		validates the contact's last name and updates the contact's last name per contact ID.
     */
	public void updateContactLastName(String contactId, String lastName){
		if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with this ID " + contactId + " does not exist.");
        }
        Contact contact = contacts.get(contactId);
        // Update fields if the new values are not null
		 if (lastName != null) {
            checkLastName(lastName);
            contact = new Contact(contact.getContactId(), contact.getFirstName(), lastName, contact.getPhone(), contact.getAddress());
        }
		contacts.put(contactId, contact);
	}
	
	/**
     * This function checks if the contact's id exists in the contact's hash map
		validates the contact's phone and updates the contact's phone per contact ID.
     */
	public void updateContactPhone(String contactId, String phone){
		if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with this ID " + contactId + " does not exist.");
        }
        Contact contact = contacts.get(contactId);
        // Update fields if the new values are not null
		if (phone != null) {
            checkPhone(phone);
            contact = new Contact(contact.getContactId(), contact.getFirstName(), contact.getLastName(), phone, contact.getAddress());
        }
		contacts.put(contactId, contact);
	}
	
	/**
     * This function checks if the contact's id exists in the contact's hash map
		validates the contact's address and updates the contact's address per contact ID.
     */
	public void updateContactAddress(String contactId, String address){
		if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with this ID " + contactId + " does not exist.");
        }
        Contact contact = contacts.get(contactId);
        // Update fields if the new values are not null
		if (address != null) {
            checkAddress(address);
            contact = new Contact(contact.getContactId(), contact.getFirstName(), contact.getLastName(), contact.getPhone(), address);
        }
        contacts.put(contactId, contact);
	}

    public Contact getContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with this ID " + contactId + " does not exist.");
        }
        return contacts.get(contactId);
    }

    /**
     * The following methods validate the contact's details
     */
    private void checkFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("First name must not be empty.");
        } else if(firstName.length() > CHARACTER_LENGTH) {
            throw new IllegalArgumentException("First name  must not exceed " + CHARACTER_LENGTH + " characters.");
        }
    }

    private void checkLastName(String lastName) {
        if (lastName == null){
            throw new IllegalArgumentException("Last name must not be null.");
        } else if(lastName.length() > CHARACTER_LENGTH) {
            throw new IllegalArgumentException("Last name must not exceed " + CHARACTER_LENGTH +  " characters.");
        }
    }

    private void checkPhone(String phone) {
        if (phone == null){
            throw new IllegalArgumentException("Phone number must not be null.");
        } else if(phone.length() != PHONE_LENGTH) {
            throw new IllegalArgumentException("Phone number must be exactly " + PHONE_LENGTH + " digits.");
        } else {
            try {
                // Validate if the phone number is numeric
                Long.parseLong(phone);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Phone number must be numeric.");
            }
        }
    }

    private void checkAddress(String address) {
        if (address == null){
            throw new IllegalArgumentException("Address must not be null.");
        } else if(address.length() > CONTACT_ADDRESS_LENGTH) {
            throw new IllegalArgumentException("Address must not exceed " + CONTACT_ADDRESS_LENGTH + " characters.");
        }
    }
}