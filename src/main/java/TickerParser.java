public class TickerParser { // THIS CLASS I IN CHARGE OF CONVERTING TICKER TO ACTUAL NAME SO coingheko can make a call
    // Parser that acts as an intermediate between mikes and i code
    public String getCoinName(String ticker){
        switch (ticker){
            case "BTC": return "bitcoin";
            case "ETH": return "ethereum";
            case "USDT": return "tether";
            case "BNB": return "BNB";
            case "SOL": return "solana";
            default:{
                System.out.println(ticker+" : Not supported");
                return null;
            }
        }
    }

}
