import java.io.IOException;
import java.util.Hashtable;

public class ProxyValidator implements Validator{
    private Validator validator = new RValidator();
    @Override
    public Boolean validation(String user, String pass) throws IOException {
        return validator.validation(user, pass);
    }
}
