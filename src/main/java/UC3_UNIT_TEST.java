public class UC3_UNIT_TEST {
    /*
    * 1) Create a broker List and empty tradeLog (which needs 2 observers as param)
    * 2) fill broker List with brokers with correct data
    * 3) test trade (see results in
    * 4) Add broker list with a broker without correct coins test trade

    *  */
    public static void main(String[] args) {


// 1)
        // Creating views for tradeLog
        TableViewer tableViewer = new TableViewer();
        HistogramViewer histogramViewer = new HistogramViewer();
        BrokerList brokerList = new BrokerList();
        TradeLog  tradeLog = new TradeLog(histogramViewer,tableViewer);
// 2)
        // Creating usr selection
        UsrSelection usrSelect1 = new UsrSelection("Fidelity", "BTC", "TestStrategy");
        UsrSelection usrSelect2 = new UsrSelection("CharleSchwab", "BTC,ETH", "TestStrategy");
        UsrSelection usrSelect3 = new UsrSelection("TD", "BTC,ETH", "TestStrategy");

        // Creating broker object
        BrokerFactory brokerFactory = new BrokerFactory();
        Broker fidelity = brokerFactory.create(usrSelect1);
        Broker charlesSwchawb = brokerFactory.create(usrSelect2);
        Broker tD = brokerFactory.create(usrSelect3);

        // Adding the brokers to broker list
        brokerList.addBroker(fidelity);
        brokerList.addBroker(charlesSwchawb);
        brokerList.addBroker(tD);

        for (Broker b : brokerList.getBrokerArrayList()) {
            System.out.println(b.getStrategy().getClass());

        }
//3
        brokerList.trade(tradeLog);
        for (StrategyResult s : tradeLog.getTrades()){
            System.out.println("------------------------ NEW TRADE --------------------------------------");
            System.out.println("Broker Name: "+s.getBroker().getName());
            System.out.println("Strategy used: "+s.getStrategy().getName());
            System.out.println("CryptoCoin traded: "+s.getCoin());
            System.out.println("Action: "+ s.getAction());
            System.out.println("Quantity: "+s.getQuantity());
            System.out.println("Price: "+s.getPrice());
            System.out.println("Date: "+s.getDate());
        }




    }// END OF MAIN



}
