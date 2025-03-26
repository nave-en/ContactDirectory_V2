package src.main.lib;

import java.util.ArrayList;
import java.util.TreeMap;

public class Contact {
    private TreeMap<String, ArrayList<String>> contacts;
    public Contact() {
        System.out.println("Contact class constructor");
        contacts = new TreeMap<>();
    }

    /**
     * Display the contact details
     * 
     * @param name the name of the contact to display
     * @return {@code void}
     * @author nave-en
     * @date 2025-Mar-26
     */
    public void displayContact(String name) {
        if (contacts.containsKey(name)) {
            System.out.println("Name : " + name + " Phone : " + contacts.get(name));
        } else {
            System.out.println("Contact not found");
        }
    }

    /**
     * Add the contact details
     * 
     * @param name the name of the contact to add
     * @param phone the phone number of the contact to add
     * @return {@code void}
     * @author nave-en
     * @date 2025-Mar-26
     */
    public void addContact(String name, String phone) {
        if (contacts.containsKey(name)) {
            ArrayList<String> phoneNumbers = contacts.get(name);
            phoneNumbers.add(phone);
            contacts.put(name, phoneNumbers);
        } else {
            ArrayList<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phone);
            contacts.put(name, phoneNumbers);
        }
    }

    /**
     * Display all the contacts
     * 
     * @return {@code void}
     * @author nave-en
     * @date 2025-Mar-26
     */
    public void displayAllContacts() {
        if (contacts.size() == 0) {
            System.out.println("No contacts found");
            return;
        }

        for (String key : contacts.keySet()) {
            System.out.println("Name : " + key + " Phone : " + contacts.get(key));
        }
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
        if (contacts.size() == 0) {
            System.out.println("No contacts found");
            return;
        }

        boolean isFound = false;
        for (String key : contacts.keySet()) {
            if (key.toLowerCase().equals(name) ||   key.toLowerCase().contains(name)){
                System.out.println("Name : " + key + " Phone : " + contacts.get(key));
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("Contact not found");
        }
    }
}
