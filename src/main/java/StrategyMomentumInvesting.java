
import java.time.LocalDate;
import java.util.Locale;

public class StrategyMomentumInvesting implements Strategy{

    private final String stratName = "MOMENTUMSTRAT";
    private final String strategyCoin1 = "ethereum";
    private final String strategyCoin2 = "litecoin";
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

        if (coinDataBase.getCoinInfo(strategyCoin1).getPrice() > coinDataBase.getCoinInfo(strategyCoin2).getPrice() * 10){
            StrategyResult testResult = new StrategyResult(500, strategyCoin1,"Buy", LocalDate.now(),
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
                System.out.println("WRONG COIN INFO");
                return false;
            }
            // if the coin is not found in the linear search return false
        }
        return true; // Both coins have been found
    }

}
