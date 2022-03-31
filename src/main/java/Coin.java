public class Coin {

    private String ticker;
    private String fullName;
    private double price;

    public Coin(String ticker, String fullName, double price){
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

    public double getPrice(){
        return price;
    }

    public void setPrice(double newPrice){
        price = newPrice;
    }

    public String toString(){
        return ("Full Name: " + ticker + "\nTicker: " + fullName + "\nPrice: " + price + "\n");
    }

}
