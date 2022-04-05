public class MainSystem {

    static BrokerList brokerList = new BrokerList();
    static TradeLog tradeLog= new TradeLog();

    static HistogramViewer histogram = new HistogramViewer(tradeLog);
    static TableViewer table = new TableViewer(tradeLog); // NEED TO ATTACH THESE TO THE VIEWER

    public static void main(String[] args) {

        //Display Login UI
        LoginUI.launchLogInUI();
        // attach observers
        attachObservers();
    }

    //If login UI returns false exit system
    //Else start Main UI
    public static void loginCheck(Boolean valid){
        if(valid){
            MainUI.LaunchMainUI();
        }
        else{
            System.exit(0);
        }
    }

    public static void addUserSelection(String name, String[] coins, String strategy){
        UsrSelection newSelection = new UsrSelection(name,coins,strategy);
        //create broker factory
        BrokerFactory brokerFactory = new BrokerFactory();
        //create a broker using the user selection and the broker factory
        Broker newBroker = brokerFactory.create(newSelection);
        //add broker to list
        brokerList.addBroker(newBroker);
    }

    // Creating method for attaching observers not sure if this is right?
    public static void invokeStrategies(){

        brokerList.trade(tradeLog);

    }
    public static void attachObservers(){
        tradeLog.attach(histogram);
        tradeLog.attach(table);
    }

    public static void clearBrokerList(){
        brokerList.clearBrokerList();
    }
}
