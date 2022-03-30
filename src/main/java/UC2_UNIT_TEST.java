public class UC2_UNIT_TEST {
    /*
    * 1) CREATE A USER SELECTION OBJECT
    * 2) CREATE A BROKER FACTORY (THIS SHOULD CALL THE STRATEGY FACTORY)
    * 3) Create 2 brokers
    * 4) ADD BROKERS INSTANCE TO BROKER LOG
    * 5) CHANGE THE COINS
    * 6) CHANGE THE STRATEGY
    * 7) DELETE THE BROKER
    * */
    public static void main(String[] args) {
        // CREATING THE BROKER CONTAINER
        BrokerList brokerList = new BrokerList();

// 1)
        UsrSelection usrSelect1 = new UsrSelection("Fidelity","BTC,ETH","GammaSqueeze");
        UsrSelection usrSelect2 = new UsrSelection("CharleSchwab","COINA,COINB","ValueInvestingStrategy");
// 2)
        BrokerFactory brokerFactory = new BrokerFactory();  // 2)

// 3)
        Broker fidelity = brokerFactory.create(usrSelect1); // CREATING A BROKER
        Broker charlesSchwab = brokerFactory.create(usrSelect2); // second broker
// 4)
        brokerList.addBroker(fidelity); // ADDING BROKER TO LIST
        brokerList.addBroker(charlesSchwab);




    }
}
