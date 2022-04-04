//public class StrategyFactorInvesting implements StrategyV1 {
//
//
//        // THIS Strategy is gonna compare prices of bitcoin and eth to decide what its gonna trade
//        private String name = "FactorInvesting";
//        @Override
//        public StrategyResult calcStrategy(Broker b, CoinsInfo coinDatabase) {
//            CoinsInfo cInfo = new CoinsInfo();
//            String[] coinList = b.getCryptoTickerList();
//
//
//            if (coinIndex("xrp", coinList)==-1// CHECK IF COINS NOT INTERESTED LIST
//                    || coinIndex("avalanche",coinList)==-1){
//                System.out.println("WRONG COINS"); // NEED TO HANDLE THIS I think it creates A GGAILED STRATEGY ROW OR SMT still creates OBJECT I think
//                return new StrategyResult(-1 ,null,"Fail",java.time.LocalDate.now(),null,b, b.getStrategy());
//            }
//
//            else{
//                // Initialise coin objects
//                Double coinAPrice = cInfo.getCoinInfo("xrp").getPrice();
//                Double coinBPrice = cInfo.getCoinInfo("avalanche").getPrice();
//
//                if (coinAPrice>0.8
//                        && coinBPrice<100.0)
//                    return new
//                            StrategyResult(300,
//                            "XRP", "Sell",
//                            java.time.LocalDate.now(),coinAPrice
//                            ,b, b.getStrategy());
//
//                else return new StrategyResult(100, "AVAX", "Sell", java.time.LocalDate.now(),coinBPrice,b, b.getStrategy());
//            }
//
//        }
//        // METHOD RETURNS its index in the list if present and -1 if not in list
//        private int coinIndex(String name, String[] list){
//            int count = 0;
//            for (String n : list){
//                count ++;
//                if (n.equals(name)) return count;
//            }
//            return -1;
//        }
//
//
//        public String getName(){
//            return name;
//        }
//
//
//
//}
