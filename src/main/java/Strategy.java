/**
 * @author Xavier Hill Roy
 * CS2212 - Intro to Software Engineering
 * @purpose Strategy interface that is used during the Factory implementation
 * this interface is used by the all Strategy classes
 */
public interface Strategy {

    String getName();
    StrategyResult determineExecution(String[] coinList, CoinsInfo coinDataBase, Broker broker);

}
