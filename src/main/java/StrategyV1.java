public interface StrategyV1 {

    StrategyResult calcStrategy(Broker b, CoinsInfo coinDataBase);
    String getName();

}
