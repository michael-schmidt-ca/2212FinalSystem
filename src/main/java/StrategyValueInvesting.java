
import java.time.LocalDate;
import java.util.Locale;

public class StrategyValueInvesting implements Strategy{

    private final String stratName = "GAMMASTRAT";
    private final String strategyCoin1 = "litecoin";
    private final String strategyCoin2 = "ethereum";
    @Override
    public String getName() {
        return stratName;
    }

    @Override
    public StrategyResult determineExecution(String[] coinList, CoinsInfo coinDataBase, Broker broker) {


        // if the required coins are not present the strategy will return a
        if (!validateUsrCoins(coinList)) {
            MainUI.catchCoinError();
            return new StrategyResult(-1 ,null,"Fail",java.time.LocalDate.now(),-1,broker, broker.getStrategy());
        }

        if (coinDataBase.getCoinInfo(coinList[0]).getPrice() > 3000){
            StrategyResult testResult = new StrategyResult(600, coinList[0],"Buy", LocalDate.now(),
                    coinDataBase.getCoinInfo(coinList[0]).getPrice(),
                    broker, this);

            return testResult;
        } else {
            StrategyResult testResult = new StrategyResult(300, coinList[1],"Sell", LocalDate.now(),
                    coinDataBase.getCoinInfo(coinList[0]).getPrice(),
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
                System.out.println("WRONG COIN INFO");
                return false;
            }
            // if the coin is not found in the linear search return false
        }
        return true; // Both coins have been found
    }

}
