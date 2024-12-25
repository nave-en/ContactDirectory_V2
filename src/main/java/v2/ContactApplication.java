package src.main.java.v2;

import java.util.Scanner;

import src.main.lib.User;

public class ContactApplication {
    public static void main(String[] args) {
        System.out.println("Contact directory V2 application");
        Scanner sc = new Scanner(System.in);
        User user = new User();
        System.out.println("Enter the email :");
        String userEmail = sc.nextLine();
        System.out.println("Enter the password :");
        String userPassword = sc.nextLine();
        boolean isValidCredentials = user.authenticate(userEmail, userPassword);
        if (isValidCredentials) {
            System.out.println("Successfully Login");
        } else {
            System.out.println("User name or password is incorrect");
        }

        sc.close();
    }
}