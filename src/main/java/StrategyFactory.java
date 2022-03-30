public class StrategyFactory {

    public Strategy create(String strategy){
        switch (strategy){
            case "GammaSqueeze": return new GammaSqueeze();
            case "ValueInvestingStrategy": return new ValueInvestingStrategy();
            case "StrategyC": return new StrategyC();
        }
        return null; // THIS SHOULD BE AN ERROR MESSAGE if no strategy

    }
}
