import java.io.IOException;
import java.util.Hashtable;

public class RValidator implements Validator{

    @Override
    public Boolean validation(String user, String pass) throws IOException {
        try {
            Hashtable<String, String> userData = UserDatabase.getDatabase();
            System.out.println(userData);
            if(userData != null && !userData.isEmpty()){ //check if the hashtable is either null or not empty
                if(userData.get(user) != null){ //if there is a password
                    return userData.get(user).equals(pass); //return if the password matches
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
