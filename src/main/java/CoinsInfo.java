
import java.util.HashMap;

public class CoinsInfo {

    private HashMap<String, Coin> coinsMap;
    private String dataBaseIdentifier;

    public CoinsInfo(){
        coinsMap = new HashMap<String, Coin>();
        dataBaseIdentifier = "TEST DATABASE";
    }

    public Coin getCoinInfo(String coinName){
        return coinsMap.get(coinName);
    }

    public boolean updateInfo(String[] names){

        try {
            coinsMap = CoinGeckoConnector.basicCall(names, "usd", coinsMap);
        } catch (Exception infoException){
            System.out.println(infoException);
            return false;
        }

        return true;

    }

    public String toString(){
        String retString = dataBaseIdentifier + "\n";
        for (Object value : coinsMap.values()) {
            retString += value.toString() + "\n";
        }
        retString += "\n";
        return retString;
    }

    public static void main(String[] args) {

        CoinsInfo coinDatabase = new CoinsInfo();

        String [] newList = {"bitcoin","ethereum","dogecoin"};

        coinDatabase.updateInfo(newList);

        System.out.println();
        System.out.println(coinDatabase);

    }

}
