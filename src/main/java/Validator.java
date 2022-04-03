import java.io.IOException;

public interface Validator {

    public Boolean validation(String user, String pass) throws IOException;
}
