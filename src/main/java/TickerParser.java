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
    // MIGHT NEED to create a method that goes the other way reverses it for when it gets put into table viewer and so on
    //

}
