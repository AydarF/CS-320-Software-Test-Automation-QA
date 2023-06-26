/**
 * Aydar Fayzullin
 * CS-320 Software Test Automation& QA
 * 3-2 Milestone: Contact Service REVISED
 */

package org.example;

public class Contact {
    private String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private final int CHARACTER_LENGTH = 10;
    private final int CONTACT_ADDRESS_LENGTH = 30;

    /**
     * Default constructor
     */
    public Contact() {
    }

    /**
     * Parameterized constructor
     */
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        checkContactId(contactId);
        this.contactId = contactId;
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    /**
     * Getters and Setters
     */
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    /**
     * Validate contactId
     */
    private void checkContactId(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID must not be empty.");
        } else if(contactId.length() > CHARACTER_LENGTH) {
            throw new IllegalArgumentException("Contact ID must not exceed 10 characters.");
        }
    }

    /**
     * Validate firstName
     */
    private void setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("First name must not be empty.");
        } else if(firstName.length() > CHARACTER_LENGTH) {
            throw new IllegalArgumentException("First name  must not exceed 10 characters.");
        } else {
            this.firstName = firstName;
        }
    }

    /**
     * Validate lastName
     */
    private void setLastName(String lastName) {
        if (lastName == null){
            throw new IllegalArgumentException("Last name must not be null.");
        } else if(lastName.length() > CHARACTER_LENGTH) {
            throw new IllegalArgumentException("Last name must not exceed 10 characters.");
        } else {
            this.lastName = lastName;
        }
    }

    /**
     * Validate phone number
     */
    private void setPhone(String phone) {
        if (phone == null){
            throw new IllegalArgumentException("Phone number must not be null.");
        } else if(phone.length() != CHARACTER_LENGTH) {
            throw new IllegalArgumentException("Phone number must not be exactly 10 digits.");
        } else {
            try {
                Long.parseLong(phone);
                // Validate if the phone number is a numeric value
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Phone number must be numeric.");
            }
            this.phone = phone;
        }
    }

    /**
     * Validate address
     */
    private void setAddress(String address) {
        if (address == null){
            throw new IllegalArgumentException("Address must not be null.");
        } else if(address.length() > CONTACT_ADDRESS_LENGTH) {
            throw new IllegalArgumentException("Address must not exceed 30 characters.");
        } else {
            this.address = address;
        }
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + getContactId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", phone=" + getPhone() +
                ", address='" + getAddress() + '\'' +
                '}';
    }
}
