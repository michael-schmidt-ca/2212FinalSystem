public class StrategyGammaSqueeze implements Strategy{

    /*
    * In: dogecoin and tether
    * if the price dogecoin is more than 18 cents and if tether is more than 1 dollar:
    *    Output: Sell 300 dogecoins
    * else:
    *   Output: Sell 100 Tether coins */
    private String name = "GammaSqueeze";
    @Override
    public StrategyResult calcStrategy(Broker b, CoinsInfo coinDatabase) {
        CoinsInfo cInfo = new CoinsInfo();
        String[] coinList = b.getCryptoTickerList();


        if (coinIndex("dogecoin", coinList)==-1// CHECK IF COINS NOT INTERESTED LIST
                || coinIndex("tether",coinList)==-1){
            System.out.println("WRONG COINS"); // NEED TO HANDLE THIS I think it creates A GGAILED STRATEGY ROW OR SMT still creates OBJECT I think
        return new StrategyResult(-1 ,null,"Fail",java.time.LocalDate.now(),null,b, b.getStrategy());
        }

        else{
            // Initialise coin objects
            double coinAPrice = cInfo.getCoinInfo("dogecoin").getPrice();
           double  coinBPrice = cInfo.getCoinInfo("tether").getPrice();

            if (coinAPrice>0.18
                    && coinBPrice<1.0)
                return new
                        StrategyResult(300,
                        "DogeCoin", "Sell",
                        java.time.LocalDate.now(),coinAPrice
                        ,b, b.getStrategy());

            else return new StrategyResult(100, "Tether", "Sell", java.time.LocalDate.now(),coinBPrice,b, b.getStrategy());
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
    public String getName(){
    return name;
    }

}
