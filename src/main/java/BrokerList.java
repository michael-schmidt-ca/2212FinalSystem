import java.util.ArrayList;
// DIDNT ADD SAVE BROKER NOT SURE HOW I WOULD
public class BrokerList {
    private ArrayList<Broker> brokerArrayList;
    BrokerList(){
        brokerArrayList = new ArrayList<>();
    }


    public ArrayList<Broker> getBrokerArrayList() {return brokerArrayList;}

    public Broker getBroker(String brokerName){// gets name of broker - not v efficient

        for (Broker broker: brokerArrayList){
            if (broker.getName().equals(brokerName))
                return broker;
        }
        return null;
    }
    public boolean removeBroker(Broker b){
       return brokerArrayList.remove(b);
    }

    public boolean addBroker(Broker b) {
        return brokerArrayList.add(b);
    }


    public void editCoinList(Broker b,String coinsEnteredToUI, UsrSelection originalSelectionObject){
        BrokerFactory tempUpdater = new BrokerFactory();// CREATES TEMP BROKER FACTORY JUST TO GET A STRING[] object for coinlist
        originalSelectionObject.setTckrLst(coinsEnteredToUI);// updating the object containing ui input
       String[] updatedList = tempUpdater.create(originalSelectionObject).getCryptoTickerList();
       b.setCryptoTickerList(updatedList);
    }
    public void editStrategy(Broker b,String stratEnteredToUI, UsrSelection originalSelectionObject){
        BrokerFactory tempUpdater = new BrokerFactory();
        originalSelectionObject.setStrategy(stratEnteredToUI);
        Strategy updatedStrat =tempUpdater.create(originalSelectionObject).getStrategy();
        b.setStrategy(updatedStrat);


    }

}
