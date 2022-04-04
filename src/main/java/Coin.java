public class Coin {

    private String ticker;
    private String fullName;
    private long price;

    public Coin(String ticker, String fullName, long price){
        this.fullName = fullName;
        this.ticker = ticker;
        this.price = price;
    }

    public String getTicker(){
        return ticker;
    }

    public String getFullName(){
        return fullName;
    }

    public long getPrice(){
        return price;
    }

    public void setPrice(long newPrice){
        price = newPrice;
    }

    public String toString(){
        return ("Full Name: " + fullName + "\nTicker: " + ticker + "\nPrice: " + price + "\n");
    }

}
