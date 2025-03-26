package src.main.java.v2;

import java.util.Scanner;

import src.main.lib.User;

public class ContactApplication {
    public static void main(String[] args) {
        System.out.println("Contact directory V2 application");
        Scanner sc = new Scanner(System.in);
        User user = new User();
        System.out.println("Enter the email :");
        String userEmail = sc.nextLine().trim();
        System.out.println("Enter the password :");
        String userPassword = sc.nextLine().trim();
        if (userEmail.length() == 0 || userPassword.length() == 0) {
            System.out.println("Please enter the email and password");
            return;
        }

        boolean isValidCredentials = user.authenticate(userEmail, userPassword);
        if (isValidCredentials) {
            System.out.println("Successfully Login");
        } else {
            System.out.println("User name or password is incorrect");
        }

        // list down all the contacts for that user
        System.out.println("Listing all contacts");
        // Adding the contacts
        System.out.println("Adding contacts");
        System.out.println("Adding Naveen, Phone : 1234567890");
        System.out.println("Adding Raj, Phone : 0987654321");
        System.out.println("Adding Kumar, Phone : 1234509876");
        user.addContact("Naveen", "1234567890");
        user.addContact("Raj", "0987654321");
        user.addContact("Kumar", "1234509876");
        user.addContact("Naveen", "1234567891");

        System.out.println("Displaying all contacts in sorted order");
        user.displayAllContacts();
        System.out.println("Searching for Naveen");
        user.searchByContactName("Naveen");
        System.out.println("Searching for Raj");
        user.searchByContactName("Raj");
        System.out.println("Searching for Kumar in small case");
        user.searchByContactName("kumar");
        System.out.println("Searching for Anand");
        user.searchByContactName("Anand");
        System.out.println("Adding Dinesh Kumar, Phone : 1234509777");
        user.addContact("Dinesh Kumar","1234509777");
        System.out.println("Searching for Kumar in small case");
        user.searchByContactName("kumar");

        sc.close();
    }
}