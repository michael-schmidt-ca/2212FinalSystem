
import java.util.HashMap;

public class CoinsInfo {

    private HashMap<String, Coin> coinsMap;

    public boolean updateInfo(String[] names){

        try {
            coinsMap = CoinGeckoConnector.basicCall(names, "usd", coinsMap);
        } catch (Exception infoException){
            System.out.println(infoException);
            return false;
        }

        return true;

    }

}
