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
//        String[] tickers = usrSelection.getTckrLst().split(","); // CH
//        TickerParser tickerConverter = new TickerParser();
//        String[] realNames = new String[tickers.length];
//
//
//        for (int index = 0; index < tickers.length; index++){
//           realNames[index] = tickerConverter.getCoinName(tickers[index]); // changes all the tickers to the real name of the coin
//
//
//        }

//        return realNames;
        return usrSelection.getTckrLst().split(",");
    }
    private Strategy retrieveStrategy(UsrSelection usrSelection){
        StrategyFactory factory = new StrategyFactory();
        return factory.create(usrSelection.getStrategy());


    }
}
