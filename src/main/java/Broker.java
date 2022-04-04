public class Broker {
    private String name;
    private String[] cryptoTickerList;
    private Strategy strategy;

    // setter and getter methods
    Broker(String name, String[] cryptoTickerList, Strategy strategy){
        setName(name);
        setCryptoTickerList(cryptoTickerList);
        setStrategy(strategy);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCryptoTickerList(String[] cryptoTickerList) {
        this.cryptoTickerList = cryptoTickerList;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public String getName(){
        return name;
    }
    public String[] getCryptoTickerList(){
        return cryptoTickerList; //NOTE THIS IS ACTUALLY THE FULL NAMES, NOT TICKERS
    }

    public Strategy getStrategy(){
        return strategy;
    }

    public StrategyResult determineTrade(CoinsInfo dataBase){
        return strategy.determineExecution(cryptoTickerList,dataBase,this);
    }

}
