
import java.time.LocalDate;
import java.util.Locale;

public class StrategyFactorInvesting implements Strategy{

    private final String stratName = "FACTORSTRAT";
    private final String strategyCoin1 = "bitcoin";
    private final String strategyCoin2 = "dogecoin";
    @Override
    public String getName() {
        return stratName;
    }

    @Override
    public StrategyResult determineExecution(String[] coinList, CoinsInfo coinDataBase, Broker broker) {


        // if the required coins are not present the strategy will return a
        if (!validateUsrCoins(coinList)) {
            MainUI.catchCoinError(broker);
            return new StrategyResult(-1 ,null,"Fail",java.time.LocalDate.now(),-1,broker, broker.getStrategy());
        }

        if (coinDataBase.getCoinInfo(strategyCoin1).getPrice()/40 > coinDataBase.getCoinInfo(strategyCoin2).getPrice()){
            StrategyResult testResult = new StrategyResult(10, strategyCoin1,"Sell", LocalDate.now(),
                    coinDataBase.getCoinInfo(strategyCoin1).getPrice(),
                    broker, this);

            return testResult;
        } else {
            StrategyResult testResult = new StrategyResult(400, strategyCoin2,"Buy", LocalDate.now(),
                    coinDataBase.getCoinInfo(strategyCoin1).getPrice(),
                    broker, this);
            return testResult;
        }

    }
    private boolean linearSearch(String targetCoin, String[] coins){ // simple linear search algo to find coin
        for (String coin: coins){
            if (targetCoin.toLowerCase(Locale.ROOT).equals(coin))
                return true;
        }// end of loop
        return false;
    }

    public String[] getRequiredCoins(){
        return new String[]{strategyCoin1,strategyCoin2};
    }

    private boolean validateUsrCoins(String[] coinList){
        for (String coin: coinList){
            if (!(linearSearch(coin,getRequiredCoins()))|| coinList.length < getRequiredCoins().length) { // if coin not found or not enough coins
                return false;
            }
            // if the coin is not found in the linear search return false
        }
        return true; // Both coins have been found
    }

}
