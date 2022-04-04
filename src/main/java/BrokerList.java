//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;


public class BrokerList{

    private ArrayList<Broker> brokerArrayList = new ArrayList();
    private String[] fullCoinList;
    private CoinsInfo coinDataBase = new CoinsInfo();

    /**
     * getter method for the brokerList
     * @return the brokerList containing all brokers the user has added
     */
    public ArrayList<Broker> getBrokerArrayList() {
        return this.brokerArrayList;
    }

    /**
     * Getter method for a specific broker in the brokerList
     * @param brokerName
     * @return Broker object if the broker is in the brokerList else null
     */
    public Broker getBroker(String brokerName) {
        for (int i = 0; i < brokerArrayList.size(); i ++){
            if (brokerArrayList.get(i).getName().equals(brokerName)){
                return brokerArrayList.get(i);
            }
        }
        return null;
    }

    /**
     * Removes target broker from broker list
     * @param b
     * @return true if the broker has been removed properly
     */
    public boolean removeBroker(Broker b) {
        boolean retValue = this.brokerArrayList.remove(b);
        genCoinList();
        return retValue;
    }

    /**
     * If the broker is not already in the broker list it is added to the list, if the broker is already present it wont add it
     * @param b
     * @return true if the broker was added properly false if the broker couldnt be added
     */
    public boolean addBroker(Broker b) {
        if (getBroker(b.getName())==null) {
            boolean retValue = this.brokerArrayList.add(b);
            System.out.println("ADDED A BROKER " + b.getName());
            //throw new RuntimeException(); if broker exist should not add the broker
            genCoinList();
            return retValue;
        }
        else {
            System.out.println("BROKER NOT ADDED ");
            return false;
        }
    }
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

    //does this edit a brokers coin list???? / yes it does
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
