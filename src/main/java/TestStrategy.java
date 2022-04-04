import java.time.LocalDate;

public class TestStrategy implements Strategy{
    private String stratName = "TESTSTRAT";

    @Override
    public String getName() {
        return stratName;
    }

    @Override
    public StrategyResult determineExecution(String[] coinList, CoinsInfo coinDataBase, Broker broker) {
        if (coinDataBase.getCoinInfo(coinList[0]).getPrice() > coinDataBase.getCoinInfo(coinList[1]).getPrice()){
            StrategyResult testResult = new StrategyResult(1000, coinList[0],"Buy", LocalDate.now(),
                                                            coinDataBase.getCoinInfo(coinList[0]).getPrice(),
                                                            broker, this);

            return testResult;
        } else {
            StrategyResult testResult = new StrategyResult(0, coinList[0],"Buy", LocalDate.now(),
                                                            coinDataBase.getCoinInfo(coinList[0]).getPrice(),
                                                            broker, this);
            return testResult;
        }

    }
}
