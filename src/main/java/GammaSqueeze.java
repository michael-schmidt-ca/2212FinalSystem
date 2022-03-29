public class GammaSqueeze implements Strategy{

    // THIS Strategy is gonna compare prices of bitcoin and eth to decide what its gonna trade
    @Override
    public StrategyResult calcStrategy(String[] coinList, Double[] coinPriceList) {
        if (coinIndex("BTC", coinList)==-1// CHECK IF COINS NOT INTERESTED LIST
                || coinIndex("ETH",coinList)==-1)
            System.out.println("WRONG COINS"); // NEED TO HANDLE THIS I think it prints out failed strategy or smt
        else{
            if (getCoinPrice("btc",coinList,coinPriceList)>60000
                    && getCoinPrice("eth",coinList,coinPriceList)<4000)
                return new StrategyResult(1000000, "BTC", "Sell", java.time.LocalDate.now(),getCoinPrice("BTC",coinList,coinPriceList));

            else return new StrategyResult(1000000, "ETH", "Sell", java.time.LocalDate.now(),getCoinPrice("eth",coinList,coinPriceList));
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
    // METHOD GETS THE COIN In the list
    private Double getCoinPrice(String name, String[] coinList, Double[] coinPriceList){
        int coinIndex = coinIndex(name, coinList);
        if (coinIndex == -1) {
            System.out.println(" NOT ENOUGH INFO - need to do smt specific here I think");
            return null;
        }
        else return coinPriceList[coinIndex];
    }

}
