import java.util.ArrayList;
// DIDNT ADD SAVE BROKER NOT SURE HOW I WOULD
public class BrokerList {
    private ArrayList<Broker> brokerArrayList;

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

}
