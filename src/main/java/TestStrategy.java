import java.time.LocalDate;
import java.util.Locale;

public class TestStrategy implements Strategy{
    private final String stratName = "TESTSTRAT";
    private final String strategyCoin1 = "bitcoin";
    private final String strategyCoin2 = "dogecoin";
    @Override
    public String getName() {
        return stratName;
    }

    @Override
    public StrategyResult determineExecution(String[] coinList, CoinsInfo coinDataBase, Broker broker) {


         // if the required coins are not present the strategy will return a
        if (!validateUsrCoins(coinList)) return new StrategyResult(-1 ,null,"Fail",java.time.LocalDate.now(),-1,broker, broker.getStrategy());

        if (coinDataBase.getCoinInfo(coinList[0]).getPrice() > coinDataBase.getCoinInfo(coinList[1]).getPrice()){
            StrategyResult testResult = new StrategyResult(1000, coinList[0],"Buy", LocalDate.now(),
                     coinDataBase.getCoinInfo(coinList[0]).getPrice(),
                                                            broker, this);

            return testResult;
        } else {
            StrategyResult testResult = new StrategyResult(0, coinList[0],"Buy", LocalDate.now(),
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
    private String[] getRequiredCoins(){
        return new String[]{strategyCoin1,strategyCoin2};
    }
    private boolean validateUsrCoins(String[] coinList){
        for (String coin: coinList){
            if (!(linearSearch(coin,getRequiredCoins()))|| coinList.length < getRequiredCoins().length) { // if coin not found or not enough coins
                System.out.println("WRONG COIN INFO");
                /*
                call the mainUI class with something like:
                MainUI.catchCoinError(True);
                    then in the MainUI you have a method that will open a window
                    in this window it will prompt you that there was an error
                    and then passes a value to the MainSystem that will write to the table
                 */
                return false;
            }
                 // if the coin is not found in the linear search return false
        }
      return true; // Both coins have been found
    }

}
