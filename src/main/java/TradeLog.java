import java.util.ArrayList;

public class TradeLog {
    private ArrayList<Trade> trades;

    public ArrayList<Trade> getTrades() {
        return trades;
    }
    public Trade getTrade(String broker, String date){

        for (Trade trade: trades){
            if (trade.getDate().equals(date) && trade.getBrokerName().equals(broker)) return trade;
        }
        return null;
    }

}
