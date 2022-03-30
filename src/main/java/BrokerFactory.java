public class BrokerFactory {

    public Broker create(UsrSelection usrSelection){// factory for creating the broker
        return new Broker(
                retrieveName(usrSelection),
                retrieveTckrLst(usrSelection),
                retrieveStrategy(usrSelection));


    }

    private String retrieveName(UsrSelection usrSelection){
        return usrSelection.getName();
    }
    // splitting the string by, to a string of interested crypto coins
    private String[] retrieveTckrLst(UsrSelection usrSelection){
        return usrSelection.getTckrLst().split(",");
    }
    private Strategy retrieveStrategy(UsrSelection usrSelection){
        StrategyFactory factory = new StrategyFactory();
        return factory.create(usrSelection.getStrategy());

         // NEED TO CREATE A STRATEGY FACTORY METHOD
    }
}
