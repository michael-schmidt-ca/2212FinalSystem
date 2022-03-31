public class ValueInvestingStrategy implements Strategy{
    // STRATEGY NEED TO CHANGE TO ACTUAL CRYPTO COINS
    // NEED TO WATCH OUT FOR NULL POINTER EXCEPTION HERE - NEED TO HANDLE
    @Override
    public StrategyResult calcStrategy(String[] coinList, Double[] coinPriceList,Broker b) {
        if (coinIndex("COINA", coinList)==-1// CHECK IF COINS NOT INTERESTED LIST
                || coinIndex("COIN B",coinList)==-1)
            System.out.println("WRONG COINS"); // NEED TO HANDLE THIS I think it creates A GGAILED STRATEGY ROW OR SMT still creates OBJECT I think
        else{
            if (getCoinPrice("COINA",coinList,coinPriceList)>80000
                    && getCoinPrice("COINB",coinList,coinPriceList)<2000)
                return new StrategyResult(1000000, "COINA", "BUY", java.time.LocalDate.now(),getCoinPrice("COINA",coinList,coinPriceList),b);

            else return new StrategyResult(100, "COINB", "BUY", java.time.LocalDate.now(),getCoinPrice("COINB",coinList,coinPriceList),b);
        }


        return null;
    }
    // METHOD RETURNS its index in the list if present and -1 if not in list
    private int coinIndex(String name, String[] list){
        int count = 0;
        for (String n : list){
            count ++;
            if (n.equals(name)) return count;
        }
        return -1;

    }
    /*METHOD GETS THE COIN In the list-
    BIG ASSUMPTION THAT COIN PRICE AT SAME INDEx AS THE COIN NAME e.g.
    CoinList = {"BTC", "ETH"},coinPriceList = {60000.84,3000.32} where coinPriceList[0]= is the price of BTC AND coinPriceList[1] = price of ETH
    */
    private Double getCoinPrice(String name, String[] coinList, Double[] coinPriceList){
        int coinIndex = coinIndex(name, coinList);
        if (coinIndex == -1) {
            System.out.println(" NOT ENOUGH INFO - need to do smt specific here I think");
            return null;
        }
        else return coinPriceList[coinIndex];
    }
}
