//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;

/*BrokerList = Controller (Observer design pattern)*/
public class BrokerList{

    private ArrayList<Broker> brokerArrayList = new ArrayList();
    private String[] fullCoinList;
    private CoinsInfo coinDataBase = new CoinsInfo();

    /**
     * getter method for list of brokers
     * @return an array list of all active brokers
     */
    public ArrayList<Broker> getBrokerArrayList() {
        return this.brokerArrayList;
    }

    /**
     * getter method for specific broker
     * @param brokerName string id of broker
     * @return broker related to passed string
     */
    public Broker getBroker(String brokerName) {
        for (int i = 0; i < brokerArrayList.size(); i ++){
            if (brokerArrayList.get(i).getName().equals(brokerName)){
                return brokerArrayList.get(i);
            }
        }
        System.out.println("Broker DNE"); //TESTING ONLY, REMOVE ON FINAL
        return null;
    }

    /**
     * method to remove a specified broker from the list, also updates the coin list
     * @param b broker object to remove
     * @return whether the removal was succesful
     */
    public boolean removeBroker(Broker b) {
        boolean retValue = this.brokerArrayList.remove(b);
        genCoinList();
        return retValue;
    }

    /**
     * method to insert a broker into the arraylist
     * @param b broker to add
     * @return boolean representation of addition success
     */
    public boolean addBroker(Broker b) {
        boolean retValue = this.brokerArrayList.add(b);
        System.out.println("ADDED A BROKER " + b.getName());
        genCoinList();
        return retValue;
    }

    /**
     * method to update the full coin list.
     * will loop through all brokers and determine
     */
    private void genCoinList(){ //UPDATES THE FULL COIN LIST WHENEVER A CHANGE IS MADE TO THE BROKER LIST
        ArrayList<String> startList = new ArrayList<>(); //list of coins
        for (int i = 0; i < brokerArrayList.size(); i ++){ //loop through brokers
            for (int j = 0; j < brokerArrayList.get(i).getCryptoTickerList().length; j ++){ //loop through broker coinlist
                if (!startList.contains(brokerArrayList.get(i).getCryptoTickerList()[j])){ //ignore duplicates
                    startList.add(brokerArrayList.get(i).getCryptoTickerList()[j]); //add to list
                }
            }
        }
        this.fullCoinList = new String[startList.size()];
        for (int i = 0; i < fullCoinList.length; i ++){
            fullCoinList[i] = startList.get(i);
        }
    }

    //does this edit a brokers coin list????
    public void editCoinList(Broker b, String[] coinsEnteredToUI, UsrSelection originalSelectionObject) {
        BrokerFactory tempUpdater = new BrokerFactory();
        originalSelectionObject.setTckrLst(coinsEnteredToUI);
        String[] updatedList = tempUpdater.create(originalSelectionObject).getCryptoTickerList();
        b.setCryptoTickerList(updatedList);
        genCoinList();
    }

    //does this edit a brokers strategy? i will assume that this works
    public void editStrategy(Broker b, String stratEnteredToUI, UsrSelection originalSelectionObject) {
        BrokerFactory tempUpdater = new BrokerFactory();
        originalSelectionObject.setStrategy(stratEnteredToUI);
        Strategy updatedStrat = tempUpdater.create(originalSelectionObject).getStrategy();
        b.setStrategy(updatedStrat);
    }

    /*BIG DADDY TRADING METHOD */
    public void trade(TradeLog tradeLog){

        coinDataBase.updateInfo(fullCoinList);
        for (int i = 0; i < brokerArrayList.size(); i ++){
            StrategyResult result = brokerArrayList.get(i).determineTrade(coinDataBase);
            System.out.println("Added trade for broker #" + brokerArrayList.get(i).getName());
            tradeLog.addTrade(result);
        }
//        for (Broker broker: brokerArrayList){
//            StrategyResult result = broker.getStrategy().calcStrategy(broker,coinDataBase);
//            tradeLog.addTrade(result);
//        }
        tradeLog.notifyObservers();

    }

    private boolean tickerInList(String ticker){
        for (int i = 0; i < fullCoinList.length; i ++){
            if (fullCoinList[i].equals(ticker)){
                return true;
            }
        }
        return false;
    }

    public void clearBrokerList(){
        this.brokerArrayList.clear();
    }

    public String[] getExhaustiveCoinList(){
        return fullCoinList;
    }
}
