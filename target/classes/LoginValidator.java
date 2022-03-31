import java.io.IOException;
import java.util.Hashtable;

public class LoginValidator extends UserDatabase{
    /*
    pretty much a helper class that will take the user and pass from the UI and compare it to the dictionary to find a valid combo of user and pass
    TODO: call the UserDatabase and create a dictionary with the textFile
    TODO: create a method that that cycles thru the dict and finds the right combo
        this the above method will return true or false depending if its found the items or not.
        the UI will take the trie or false and open/ continue to prompt if the login was incorrect
     */

    public static Boolean validate(String user, String password){
       try {
            Hashtable<String, String> userData = UserDatabase.getDatabase();
            System.out.println(userData);
            if(userData != null && !userData.isEmpty()){ //check if the hashtable is either null or not empty
                if(userData.get(user) != null){ //if there is a password
                    return userData.get(user).equals(password); //return if the password matches
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
