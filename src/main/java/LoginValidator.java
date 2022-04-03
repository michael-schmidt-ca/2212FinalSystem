import java.io.IOException;
import java.util.Hashtable;

public class LoginValidator  {

    public static Boolean validate(String user, String pass) throws IOException {

        Validator valid = new ProxyValidator();
        try {
            return valid.validation(user, pass);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}