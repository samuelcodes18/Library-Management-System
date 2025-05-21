package lib.users; 
 
// User defined exception for invalid user details 
public class InvalidUserException extends Exception{ 
    public InvalidUserException(String msggg) { 
        super(msggg); 
    } 
}