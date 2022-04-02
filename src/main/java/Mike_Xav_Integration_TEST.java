public class Mike_Xav_Integration_TEST {
    public static void main(String[] args) {
        TableViewer tableViewer = new TableViewer();
        HistogramViewer histogramViewer = new HistogramViewer();



        TradeLog  tradeLog = new TradeLog(histogramViewer,tableViewer);

        BrokerList brokerList = new BrokerList();

        // ADD MATERIAL TO BROKER LIST
        System.out.println("_________________ TEST CONNECT__________________");
        String[] coins = {"BTC", "ethereum", "dogecoin"};
        CoinsInfo coinDataBase = new CoinsInfo();
        coinDataBase.updateInfo(coins); // UPDATED



        System.out.println(coinDataBase.getCoinInfo("bitcoin").getPrice());
        UsrSelection usrSelect1 = new UsrSelection("Fidelity", "bitcoin,ethereum", "TestStrategy");
        BrokerFactory brokerFactory = new BrokerFactory();
        Broker fidelity = brokerFactory.create(usrSelect1);
//

        brokerList.addBroker(fidelity);
        String[] exaustiveCoinList = brokerList.getExhaustiveCoinList();
        for (String s: exaustiveCoinList) System.out.println(s); // COIN LIST WORKS

        //

    }
}
