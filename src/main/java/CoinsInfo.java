import java.util.HashMap;

/**
 * CoinsInfo class
 * provides storage, and efficient updates for all information regarding coins used for trading
 */
public class CoinsInfo {

    private HashMap<String, Coin> coinsMap;

    /**
     * constructor for coinsInfo, creates empty hashmap
     */
    public CoinsInfo(){
        coinsMap = new HashMap<String, Coin>();
    }

    /**
     * getter method for information on a specific coin
     * @param coinName full id of the coin
     * @return the coin object
     */
    public Coin getCoinInfo(String coinName){
        return coinsMap.get(coinName);
    }

    /**
     * determines if a coin exists within CoinGecko
     * @param coin coin to check
     * @return whether coin is valid
     */
    public boolean checkValidCoin(String coin){
        return CoinGeckoConnector.coinExists(coin);
    }

    /**
     * updates info for all coins used in trading
     * @param names string list of all coins in use
     * @return whether the update was succesful
     */
    public boolean updateInfo(String[] names){

        try {
            coinsMap = CoinGeckoConnector.basicCall(names, "usd", coinsMap);
        } catch (Exception infoException){
            System.out.println(infoException);
            return false;
        }

        return true;

    }

    /**
     * toString method for CoinsInfo
     * @return a string representation of the object
     */
    public String toString(){
        String retString = "Coin Database: \n";
        for (Object value : coinsMap.values()) {
            retString += value.toString() + "\n";
        }
        retString += "\n";
        return retString;
    }

}
