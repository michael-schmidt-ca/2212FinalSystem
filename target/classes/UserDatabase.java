import java.io.*;
import java.util.Hashtable;

public class UserDatabase {

    public static Hashtable<String, String> userData = new Hashtable<String, String>();;

    private static void setUserData() throws IOException {
        try {
            File file = new File("userandpass.txt");
            FileReader reader = new FileReader(file);
            BufferedReader buffRead = new BufferedReader(reader);

            String readLine = buffRead.readLine(); // neglect first line
            while((readLine = buffRead.readLine()) != null){
                String[] split = readLine.split(":");
                userData.put(split[0].toLowerCase().replaceAll(" ", ""), split[1].replaceAll(" ", ""));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Hashtable<String, String> getDatabase() throws IOException{
        setUserData();
        if(!userData.isEmpty())
            return userData;
        else
            return null;
    }
}
