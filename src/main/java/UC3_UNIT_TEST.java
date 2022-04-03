public class UC3_UNIT_TEST {
    /*
    * 1) Create a broker List and empty tradeLog (which needs 2 observers as param)
    * 2) fill broker List with brokers with correct data
    * 3) test trade (see results in
    * 4) Add broker list with a broker without correct coins test trade

    *  */
    public static void main(String[] args) {
        BrokerList brokerList = new BrokerList();
        System.out.println("_________________ TEST CONNECT__________________");


// 1)
        // Creating views for tradeLog
        TradeLog  tradeLog = new TradeLog();
        tradeLog.attach((TradingObservers) new TableViewer(tradeLog));

        HistogramViewer histogramViewer = new HistogramViewer(tradeLog);







// 2)
        // Creating usr selection
        UsrSelection usrSelect1 = new UsrSelection("Fidelity", "BTC,ETH", "TestStrategy");


        // Creating broker object
        BrokerFactory brokerFactory = new BrokerFactory();
        Broker fidelity = brokerFactory.create(usrSelect1);
//        Broker charlesSwchawb = brokerFactory.create(usrSelect2);
//        Broker tD = brokerFactory.create(usrSelect3);

        // Adding the brokers to broker list
        brokerList.addBroker(fidelity);
//        brokerList.addBroker(charlesSwchawb);
//        brokerList.addBroker(tD);
        // INTERLUDE TEST: testing creating exhaustive list of coins to get info on
        System.out.println("\n-----------------------------------EXHAUSTIVE COIN LIST INTERLUDE----------------------------------------\n");
        System.out.println("-----------------------------------START----------------------------------------\n");
//        String[] exaustiveCoinList = brokerList.getExhaustiveCoinList();
        CoinsInfo coinDataBase = new CoinsInfo();
        String[] exaustiveCoinList = brokerList.getExhaustiveCoinList();
        coinDataBase.updateInfo(exaustiveCoinList);

        System.out.println(coinDataBase.getCoinInfo("bitcoin").getPrice());

        for (String s: exaustiveCoinList) System.out.println(s);




        System.out.println("-----------------------------------END----------------------------------------");
        System.out.println("\n-----------------------------------EXHAUSTIVE COIN LIST INTERLUDE----------------------------------------\n");


        for (Broker b : brokerList.getBrokerArrayList()) {
            System.out.println(b.getStrategy().getClass());

        }
//3
        brokerList.trade(tradeLog);
        for (StrategyResult s : tradeLog.getTradeLog()){
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
