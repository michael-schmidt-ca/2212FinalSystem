import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;


public class APITester {
    public static void main(String[] args) {

        try{
            URL url = new URL("https://api.coingecko.com/api/v3/coins/bitcoin");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int response = connection.getResponseCode();
            if (response != 200){
                throw  new Exception("blah");
            } else {
                String infoString = new String();
                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNext()){
                    infoString = infoString + sc.nextLine();
                }
                sc.close();
                //System.out.println(infoString);
                JSONParser parser = new JSONParser();
                JSONObject json = (JSONObject) parser.parse(infoString);

                JSONObject marketData = (JSONObject)json.get("market_data");
                JSONObject currentPriceData = (JSONObject) marketData.get("current_price");
                System.out.println(currentPriceData.get("usd"));

            }

        } catch(Exception blah){
            System.out.println(blah);
        }


    }
}
