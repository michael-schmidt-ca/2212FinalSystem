public class TickerParser { // THIS CLASS I IN CHARGE OF CONVERTING TICKER TO ACTUAL NAME SO coingheko can make a call

    public String getCoinName(String ticker){
        switch (ticker){
            case "BTC": return "bitcoin";
            case "ETH": return "ethereum"
        }
    }
}
