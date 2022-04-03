public class StrategyFactory {

    public Strategy create(String strategy){
        switch (strategy){
            case "GammaSqueeze": return new StrategyGammaSqueeze();
//            case "ValueInvestingStrategy": return new ValueInvestingStrategy();
            case "ValueInvesting": return new StrategyValueInvesting();
        }
        return null; // THIS SHOULD BE AN ERROR MESSAGE if no strategy

    }
}
