public interface Strategy {

    String getName();
    StrategyResult determineExecution(String[] coinList, CoinsInfo coinDataBase, Broker broker);

}
