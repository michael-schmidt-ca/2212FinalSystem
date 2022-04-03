public class MainSystem {

    static BrokerList brokerList = new BrokerList();
    static HistogramViewer histogram = new HistogramViewer();
    static TableViewer table = new TableViewer();

    public static void main(String[] args) {
        boolean loginValid = false;
        //Display Login UI
        LoginUI.launchLogInUI();
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

    public static void addUserSelection(String name, String coins, String strategy){
        UsrSelection newSelection = new UsrSelection(name,coins,strategy);
        //create broker factory
        BrokerFactory brokerFactory = new BrokerFactory();
        //create a broker using the user selection and the broker factory
        Broker newBroker = brokerFactory.create(newSelection);
        //add broker to list
        brokerList.addBroker(newBroker);
        //System.out.println(brokerList.getBrokerArrayList().get(0).getName()); working
    }

    public static void invokeStrategies(){
        System.out.println("In method invokeStrategies");
        histogram.update();
        table.update();
    }
}
