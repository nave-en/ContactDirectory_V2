package src.main.lib;

import java.util.HashMap;

public class User {
    private HashMap<String, String> userCredentials = new HashMap<>();
    Contact contact;
    public User() {
        // adding some default user information
        userCredentials.put("superstar@gmail.com", "1234qwer");
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
}
