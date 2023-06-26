package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void testContactClass(){
        Contact contact = new Contact("12345", "Aydar", "Fayzullin", "1234567890", "1 Wall St");
        Assertions.assertTrue(contact.getContactId().equals("12345"));
        Assertions.assertTrue(contact.getFirstName().equals("Aydar"));
        Assertions.assertTrue(contact.getLastName().equals("Fayzullin"));
        Assertions.assertTrue(contact.getPhone().equals("1234567890"));
        Assertions.assertTrue(contact.getAddress().equals("1 Wall St"));
    }

    @Test
    public void testInvalidContactId_Null() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Contact(null, "Aydar", "Fayzullin", "1234567890", "1 Wall St")
        );
    }

    @Test
    public void testInvalidContactId_TooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345678901", "Aydar", "Fayzullin", "1234567890", "1 Wall St")
        );
    }

    @Test
    public void testInvalidFirstName_Null() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", null, "Fayzullin", "1234567890", "1 Wall St")
        );
    }

    @Test
    public void testInvalidFirstName_TooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "AydarAydarAydar", "Fayzullin", "1234567890", "1 Wall St")
        );
    }

    @Test
    public void testInvalidLastName_Null() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Aydar", null, "1234567890", "1 Wall St")
        );
    }

    @Test
    public void testInvalidLastName_TooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Aydar", "FayzullinFayzullin", "1234567890", "1 Wall St")
        );
    }

    @Test
    public void testInvalidPhone_Null() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Aydar", "Fayzullin", null, "1 Wall St")
        );
    }

    @Test
    public void testInvalidPhone_TooShort() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Aydar", "Fayzullin", "12345", "1 Wall St")
        );
    }

    @Test
    public void testInvalidPhone_TooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Aydar", "Fayzullin", "12345678901", "1 Wall St")
        );
    }


    @Test
    public void testInvalidAddress_Null() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Aydar", "Fayzullin", "1234567890", null)
        );
    }

    @Test
    public void testInvalidAddress_TooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Aydar", "Fayzullin", "1234567890", "1 Wall St, Apartment 456, New York City")
        );
    }
}