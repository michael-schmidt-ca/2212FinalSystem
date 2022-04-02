public class GammaSqueeze implements Strategy{

    // THIS Strategy is gonna compare prices of bitcoin and eth to decide what its gonna trade
    private String name = "GammaSqueeze";
    @Override
    public StrategyResult calcStrategy(Broker b, CoinsInfo coinDatabase) {
        CoinsInfo cInfo = new CoinsInfo();
        String[] coinList = b.getCryptoTickerList();


        if (coinIndex("BTC", coinList)==-1// CHECK IF COINS NOT INTERESTED LIST
                || coinIndex("ETH",coinList)==-1){
            System.out.println("WRONG COINS"); // NEED TO HANDLE THIS I think it creates A GGAILED STRATEGY ROW OR SMT still creates OBJECT I think
        return new StrategyResult(-1 ,null,"Fail",java.time.LocalDate.now(),null,b, b.getStrategy());
        }

        else{
            // Initialise coin objects
            Double coinAPrice = cInfo.getCoinInfo("Bitcoin").getPrice();
           Double coinBPrice = cInfo.getCoinInfo("ethereum").getPrice();

            if (coinAPrice>60000
                    && coinBPrice<4000)
                return new
                        StrategyResult(1000000,
                        "BTC", "Sell",
                        java.time.LocalDate.now(),coinAPrice
                        ,b, b.getStrategy());

            else return new StrategyResult(1000000, "ETH", "Sell", java.time.LocalDate.now(),coinBPrice,b, b.getStrategy());
        }

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
    public String getName(){
    return name;
    }

}
