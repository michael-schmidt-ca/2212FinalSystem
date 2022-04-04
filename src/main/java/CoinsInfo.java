
import java.util.HashMap;

public class CoinsInfo {

    private HashMap<String, Coin> coinsMap;

    public CoinsInfo(){
        coinsMap = new HashMap<String, Coin>();
    }

    public Coin getCoinInfo(String coinName){
        return coinsMap.get(coinName);
    }

    public boolean checkValidCoin(String coin){
        return CoinGeckoConnector.coinExists(coin);
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
        String retString = "Coin Database: \n";
        for (Object value : coinsMap.values()) {
            retString += value.toString() + "\n";
        }
        retString += "\n";
        return retString;
    }

    public static void main(String[] args) {

        CoinsInfo bruh = new CoinsInfo();


        String [] newList = {"bitcoin","ethereum"};
        bruh.updateInfo(newList);
        System.out.println(bruh);
        System.out.println(bruh.getCoinInfo("eth").getPrice());

    }

}
