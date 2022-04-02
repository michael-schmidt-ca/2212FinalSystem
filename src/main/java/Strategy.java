public interface Strategy {

     StrategyResult calcStrategy(Broker b, CoinsInfo coinDataBase);
    String getName();


}
