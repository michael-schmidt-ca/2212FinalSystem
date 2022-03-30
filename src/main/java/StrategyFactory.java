public class StrategyFactory {

    public Strategy create(String strategy){
        switch (strategy){
            case "StrategyA": return new GammaSqueeze();
            case "StrategyB": return new StrategyB();
            case "StrategyC": return new StrategyC();
        }
        return null; // THIS SHOULD BE AN ERROR MESSAGE if no strategy

    }
}
