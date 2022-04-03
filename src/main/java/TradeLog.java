import java.util.ArrayList;
import java.util.Observer;
/*TradeLog = ConcreteSubject (Observer design pattern)
* */

public class TradeLog {


    private ArrayList<TradingObservers> observers = new ArrayList<>();
    private ArrayList<StrategyResult> trades = new ArrayList<>();


    public ArrayList<StrategyResult> getTrades() {
        return trades;
    }
    public StrategyResult getTrade(String broker, String date){

        for (StrategyResult trade: trades){
            if (trade.getDate().equals(date) && trade.getBroker().getName().equals(broker))return trade;
        }
        return null;
    }
    public void notifyObservers(){
        for (TradingObservers o : observers){
            o.update();
        }
    }
    public boolean addTrade(StrategyResult s){return trades.add(s);}
    public void attach(TradingObservers observer){
        observers.add(observer);
    }


}
