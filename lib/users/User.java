package lib.users; 
 
// Class representing members of the library 
public class User{ 
    private int userId; 
    private String fullName; 
    private int userAge; 
    public User(int userId, String fullName, int userAge) throws InvalidUserException { 
        if (userAge < 16 || userAge > 100) { 
            throw new InvalidUserException("Invalid age! Age should be between 16 and 100."); 
        } 
        if (!fullName.matches("[a-zA-Z ]+")) { 
            throw new InvalidUserException("Invalid name! Only alphabets and spaces are allowed."); 
        } 
        this.userId = userId; 
        this.fullName = fullName; 
        this.userAge = userAge; 
    } 
 
    public void displayUserInfo() { 
        System.out.println("User ID: " + userId + ", Name: " + fullName + ", Age: " + userAge); 
    } 
}