package src.main.lib;

import java.util.HashMap;

public class User {
    private HashMap<String, String> userCredentials = new HashMap<>();
    Contact contact;
    public User() {
        // adding some default user information
        userCredentials.put("superstar@gmail.com", "1234qwer");
        contact = new Contact();
    }

    /**
     * Validate the user credentials
     * 
     * @param email the email of the user to authenticate
     * @param String password the password of the user to authenticate
     * @return {@code true} if credentials are valid, {@code false} otherwise
     * @author nave-en
     * @date 2024-Dec-25
     */
    public boolean authenticate(String email, String password) {
        if (!userCredentials.containsKey(email)) {
            return false;
        }

        String passwordInHM = userCredentials.get(email);
        if (password.equals(passwordInHM)) {
            return true;
        }

        return false;
    }

    /**
     * Display all the contacts
     * 
     * @return {@code void}
     * @author nave-en
     * @date 2025-Mar-26
     */
    public void displayAllContacts() {
        contact.displayAllContacts();
    }

    /**
     * Add the contact details
     * 
     * @param name the name of the contact to add
     * @param phoneNumber the phone number of the contact to add
     * @return {@code void}
     * @author nave-en
     * @date 2025-Mar-26
     */
    public void addContact(String name, String phoneNumber) {
        contact.addContact(name, phoneNumber);
    }

    /**
     * Search the contact by name
     * 
     * @param name the name of the contact to search
     * @return {@code void}
     * @author nave-en
     * @date 2025-Mar-26
     */
    public void searchByContactName(String name) {
        contact.searchByContactName(name.toLowerCase());
    }

    /**
     * Search the contact by number
     *
     * @param number the number of the contact to search
     * @return {@code void}
     * @author nave-en
     * @date 2025-Mar-26
     */
    public void searchByContactNumber(String number) {
        contact.searchByContactNumber(number);
    }

    /**
     * Delete the contact
     *
     * @param name the name of the contact to delete
     * @return {@code void}
     * @author nave-en
     * @date 2025-Mar-26
     */
    public void deleteContact(String name) {
        contact.deleteContact(name);
    }

    /**
     * Update the contact
     *
     * @param currName the current name of the contact
     * @param newName the new name of the contact
     * @return {@code void}
     * @author nave-en
     * @date 2025-Mar-26
     */
    public void updateContact(String currName, String newName) {
        contact.updateContact(currName, newName);
    }

    /**
     * Show the duplicate contacts
     *
     * @return {@code void}
     * @author nave-en
     * @date 2025-Mar-26
     */
    public void showDuplicateContacts() {
        contact.showDuplicateContacts();
    }

    /**
     * Merge the duplicate contacts
     *
     * @return {@code void}
     * @author nave-en
     * @date 2025-Mar-26
     */
    public void mergeDuplicateContacts() {
        contact.mergeDuplicateContacts();
    }
}
