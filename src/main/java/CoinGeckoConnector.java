import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class CoinGeckoConnector {

    public static void main(String[] args) {

        String [] newList = {"bitcoin","ethereum"};
        basicCall(newList, "usd", new HashMap<String, Coin>());


    }

    public static HashMap<String, Coin> basicCall(String[] coinsList, String currencyType, HashMap<String, Coin> curMap) {
        try {

            String callString = "";
            for (int i = 0; i < coinsList.length - 1; i++) {
                callString += coinsList[i] + ",";
            }
            callString += coinsList[coinsList.length - 1];

            URL url = new URL
                    ("https://api.coingecko.com/api/v3/simple/price?ids=" + callString
                            + "&vs_currencies=" + currencyType);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            String infoString = "";
            Scanner sc = new Scanner(url.openStream());
            while (sc.hasNext()) {
                infoString = infoString + sc.nextLine();
            }
            sc.close();

            System.out.println(infoString);

            JSONParser parser = new JSONParser();
            JSONObject apiReturnJSON = (JSONObject) parser.parse(infoString);


            for (int i = 0; i < coinsList.length; i++) {

                //info on a specific coin
                JSONObject coinInfo = (JSONObject) apiReturnJSON.get(coinsList[i]);

                if (curMap.containsKey(coinsList[i])) {
                    curMap.get(coinsList[i]).setPrice((double) (coinInfo.get(currencyType)));
                } else {
                    Coin newCoin = new Coin("TICKERHOLDER", coinsList[i],
                                                ((Number)(coinInfo.get(currencyType))).doubleValue());
                    curMap.put(coinsList[i], newCoin);
                }

            }

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return curMap;
    }
}
