//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Iterator;
/*BrokerList = Controller (Observer design pattern)*/
public class BrokerList {

    private ArrayList<Broker> brokerArrayList = new ArrayList();
    private ArrayList<String> exhaustiveCoinList = new ArrayList();



    public ArrayList<Broker> getBrokerArrayList() {
        return this.brokerArrayList;
    }

    public Broker getBroker(String brokerName) {
        Iterator var2 = this.brokerArrayList.iterator();

        Broker broker;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            broker = (Broker)var2.next();
        } while(!broker.getName().equals(brokerName));

        return broker;
    }

    public boolean removeBroker(Broker b) {
        return this.brokerArrayList.remove(b);
    }

    public boolean addBroker(Broker b) {
        return this.brokerArrayList.add(b);
    }

    public void editCoinList(Broker b, String coinsEnteredToUI, UsrSelection originalSelectionObject) {
        BrokerFactory tempUpdater = new BrokerFactory();
        originalSelectionObject.setTckrLst(coinsEnteredToUI);
        String[] updatedList = tempUpdater.create(originalSelectionObject).getCryptoTickerList();
        b.setCryptoTickerList(updatedList);
    }

    public void editStrategy(Broker b, String stratEnteredToUI, UsrSelection originalSelectionObject) {
        BrokerFactory tempUpdater = new BrokerFactory();
        originalSelectionObject.setStrategy(stratEnteredToUI);
        Strategy updatedStrat = tempUpdater.create(originalSelectionObject).getStrategy();
        b.setStrategy(updatedStrat);
    }
    /*BIG DADDY TRADING METHOD */
    public void trade(TradeLog tradeLog){
        String[] coins = getExhaustiveCoinList();
        CoinsInfo coinDataBase = new CoinsInfo();
        coinDataBase.updateInfo(coins);


        for (Broker broker: brokerArrayList){
            StrategyResult result = broker.getStrategy().calcStrategy(broker,coinDataBase);
            tradeLog.addTrade(result);
        }
        tradeLog.notifyObservers();

    }
    public String[] getExhaustiveCoinList(){ // essentially implementing a set data type

        for (Broker broker: brokerArrayList){
            for (String tickerName: broker.getCryptoTickerList()){
                if (!tickerInList(tickerName)) exhaustiveCoinList.add(tickerName); // negate result of tickerInList() and adds coin name if its not in the list
            }// end of nested for loop

        }// BrokerList For loop
        return exhaustiveCoinList.toArray(new String[0]); // returns a String[] object
    }// End of method

    private boolean tickerInList(String ticker){
        for (String s : exhaustiveCoinList) {
            if (s.equals(ticker)) return true;
        }// End of loop
        return false; // Went through list and no coin
    }
}
