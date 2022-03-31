//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Iterator;
/*BrokerList = Controller (Observer design pattern)*/
public class BrokerList {

    private ArrayList<Broker> brokerArrayList = new ArrayList();

    BrokerList() {
    }

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
}
