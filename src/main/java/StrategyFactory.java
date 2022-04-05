public class StrategyFactory {
    /**
     *A factory that Determines what strategy object to create based on what strategy the user has selected
     * @param strategy
     * @return appropriate subclass strategy object based on what the user enters as their desired strategy
     */
    public Strategy create(String strategy){
        System.out.println("The chosen strat is :" + strategy);
        switch (strategy){
            case "GammaSqueeze": return new StrategyGammaSqueeze();
            case "FactorInvesting": return new StrategyFactorInvesting();
            case "ValueInvesting": return new StrategyValueInvesting();
            case "MomentumInvesting": return new StrategyMomentumInvesting();
        }
        return new TestStrategy(); // THIS SHOULD BE AN ERROR MESSAGE if no strategy
    }
}
