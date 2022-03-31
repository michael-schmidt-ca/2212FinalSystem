import java.util.ArrayList;
/*TradeLog = ConcreteSubject (Observer design pattern)
* */

public class TradeLog {

    private ArrayList<StrategyResult> trades;

    public ArrayList<StrategyResult> getTrades() {
        return trades;
    }
    public StrategyResult getTrade(String broker, String date){

        for (StrategyResult trade: trades){
            if (trade.getDate().equals(date) && trade.getBroker().getName().equals(broker))return trade;
        }
        return null;
    }

}
