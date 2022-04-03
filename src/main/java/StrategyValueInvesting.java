public class StrategyValueInvesting implements Strategy{



        // THIS Strategy is gonna compare prices of bitcoin and eth to decide what its gonna trade
        private final String name ="ValueInvesting";
    @Override
        public StrategyResult calcStrategy(Broker b, CoinsInfo coinDataBase) {

            String[] coinList = b.getCryptoTickerList();


            if (coinIndex("bitcoin", coinList)==-1// CHECK IF COINS NOT INTERESTED LIST
                    || coinIndex("ethereum",coinList)==-1){
                System.out.println("WRONG COINS"); // NEED TO HANDLE THIS I think it creates A GGAILED STRATEGY ROW OR SMT still creates OBJECT I think
                return new StrategyResult(-1 ,null,"Fail",java.time.LocalDate.now(),null,b, b.getStrategy());
            }

            else{
                // Initialise coin objects
//                Double coinAPrice = cInfo.getCoinInfo("Bitcoin").getPrice();
//                Double coinBPrice = cInfo.getCoinInfo("ethereum").getPrice();\
                double coinAPrice = coinDataBase.getCoinInfo("bitcoin").getPrice();
                double coinBPrice = coinDataBase.getCoinInfo("ethereum").getPrice();


                if (coinAPrice>46188.00
                        && coinBPrice<3446.88)
                    return new
                            StrategyResult(1000000,
                            "BTC", "Sell",
                            java.time.LocalDate.now(),100000.0//
                            ,b, b.getStrategy());

                else return new
                        StrategyResult(
                                1000000,
                        "ETH",
                        "BUY",
                        java.time.LocalDate.now(),
                        coinBPrice,
                        b,
                        b.getStrategy());
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

        public String getName(){
            return name;
        }



}
