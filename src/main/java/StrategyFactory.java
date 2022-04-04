public class StrategyFactory {
    /**
     *A factory that Determines what strategy object to create based on what strategy the user has selected
     * @param strategy
     * @return appropriate subclass strategy object based on what the user enters as their desired strategy
     */
    public Strategy create(String strategy){
        return new TestStrategy();
//        switch (strategy){
//            case "GammaSqueeze": return new StrategyGammaSqueeze();
////            case "ValueInvestingStrategy": return new ValueInvestingStrategy();
//            case "ValueInvesting": return new StrategyValueInvesting();
//        }
//        return null; // THIS SHOULD BE AN ERROR MESSAGE if no strategy
    }
}
