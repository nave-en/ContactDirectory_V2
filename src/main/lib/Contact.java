package src.main.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.TreeMap;

public class Contact {
    private TreeMap<String, List<String>> contacts;
    public Contact() {
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
            List<String> phoneNumbers = contacts.get(name);
            phoneNumbers.add(phone);
            contacts.put(name, phoneNumbers);
        } else {
            contacts.computeIfAbsent(name, k -> new ArrayList<>()).add(phone);
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

    /**
     * Search the contact by number
     *
     * @param number the number of the contact to search
     * @return {@code void}
     * @author nave-en
     * @date 2025-Mar-26
     */
    public void searchByContactNumber(String number) {
        if (contacts.size() == 0) {
            System.out.println("No contacts found");
            return;
        }

        boolean isFound = false;
        for (String key : contacts.keySet()) {
            List<String> phoneNumbers = contacts.get(key);
            for (String phone : phoneNumbers) {
                if (phone.contains(number)) {
                    System.out.println("Name : " + key + " Phone : " + phone);
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            System.out.println("Contact not found");
        }
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
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            System.out.println("Contact deleted successfully");
        } else {
            System.out.println("Contact not found");
        }
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
        if (currName.equals(newName)) {
            System.out.println("Both names are same");
            return;
        }

        if (contacts.containsKey(newName)) {
            System.out.println("Contact already exists with the name " + newName);
            return;
        }

        if (contacts.containsKey(currName)) {
            List<String> phoneNumbers = contacts.get(currName);
            contacts.put(newName, phoneNumbers);
            contacts.remove(currName);
            System.out.println("Contact updated successfully");
        } else {
            System.out.println("Contact not found");
        }
    }

    /**
     * Show the duplicate contacts
     *
     * @return {@code void}
     * @author nave-en
     * @date 2025-Mar-26
     */
    public void showDuplicateContacts() {
        if (contacts.size() == 0) {
            System.out.println("No contacts found");
            return;
        }

        HashMap<String, List<String>> duplicateContacts = this.getDuplicateContacts();

        boolean isFound = false;
        for (String key : duplicateContacts.keySet()) {
            List<String> names = duplicateContacts.get(key);
            if (names.size() > 1) {
                isFound = true;
                System.out.println("Phone : " + key + " Names : " + names);
            }
        }
        if (!isFound) {
            System.out.println("No duplicate contacts found");
        }
    }

    /**
     * Merge the duplicate contacts
     *
     * @return {@code void}
     * @author nave-en
     * @date 2025-Mar-26
     */
    public void mergeDuplicateContacts() {
        if (contacts.size() == 0) {
            System.out.println("No contacts found");
            return;
        }

        HashMap<String, List<String>> duplicateContacts = this.getDuplicateContacts();
        for (String key:duplicateContacts.keySet()) {
            List<String> names = duplicateContacts.get(key);
            if (names.size() > 1) {
                for (int i = 1; i < names.size(); i++) {
                    String oldName = names.get(i);
                    List<String> oldPhoneNumbers = contacts.get(oldName);
                    oldPhoneNumbers.remove(key);
                    if (oldPhoneNumbers.size() == 0) {
                        contacts.remove(oldName);
                    }
                }
            }
        }
    }

    /**
     * Get the duplicate contacts
     *
     * @return {@code HashMap<String, List<String>>} the duplicate contacts
     * @author nave-en
     * @date 2025-Mar-26
     */
    private HashMap<String, List<String>> getDuplicateContacts() {
        HashMap<String, List<String>> duplicateContacts = new HashMap<>();
        for(String key: contacts.keySet()) {
            List<String> phoneNumbers = contacts.get(key);
            for(String phone: phoneNumbers) {
                if(duplicateContacts.containsKey(phone)) {
                    List<String> names = duplicateContacts.get(phone);
                    names.add(key);
                    duplicateContacts.put(phone, names);
                } else {
                    List<String> names = new ArrayList<>();
                    names.add(key);
                    duplicateContacts.put(phone, names);
                }
            }
        }

        return duplicateContacts;
    }
}
