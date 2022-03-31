import java.util.ArrayList;
/*TradeLog = ConcreteSubject (Observer design pattern)
* */

public class TradeLog {
    // DONT THINK I SHOULD BE CREATING OBJECTS HERE NOT SURE BUT FOR FUNCTIONALITY FOR NOW WILL DO
    private  HistogramViewer graph;
    private TableViewer tableViewer;

    private ArrayList<Observer> observers = new ArrayList<>();
    private ArrayList<StrategyResult> trades = new ArrayList<>();
    TradeLog(){
        observers.add(graph);
        observers.add(tableViewer);



    }

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
        for (Observer o : observers){
            o.update();
        }
    }

}
