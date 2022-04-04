public class StrategyMomentumInvesting implements Strategy {


        // THIS Strategy is gonna compare prices of bitcoin and eth to decide what its gonna trade
        private String name = "MomentumInvesting";
        @Override
        public StrategyResult determineExecution(String[] coinsList, CoinsInfo coinDatabase, Broker b) {


            if (coinIndex("terra", coinsList)==-1// CHECK IF COINS NOT INTERESTED LIST
                    || coinIndex("bnb",coinsList)==-1){
                System.out.println("WRONG COINS"); // NEED TO HANDLE THIS I think it creates A GGAILED STRATEGY ROW OR SMT still creates OBJECT I think
                return new StrategyResult(-1 ,null,"Fail",java.time.LocalDate.now(),0,b, b.getStrategy());
            }

            else{
                // Initialise coin objects
                Double coinAPrice = coinDatabase.getCoinInfo("terra").getPrice();
                Double coinBPrice = coinDatabase.getCoinInfo("bnb").getPrice();

                if (coinAPrice<114.0
                        && coinBPrice>445.0)
                    return new
                            StrategyResult(
                                    20, "ADA", "Sell",
                            java.time.LocalDate.now(),
                            coinDatabase.getCoinInfo("cardano").getPrice()
                            ,b, b.getStrategy());

                else return new StrategyResult(
                        20, "BTC", "Buy",
                        java.time.LocalDate.now(),
                        coinDatabase.getCoinInfo("bitcoin").getPrice(),
                        b, b.getStrategy());
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
