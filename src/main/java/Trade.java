public class Trade {
    private int quantity;
    private String action;
    private String date;
    private Double price;
    private String brokerName;
    private Strategy strategy;

    public int getQuantity() {
        return quantity;
    }
    public String getAction(){
        return action;
    }

    public String getBrokerName() {
        return brokerName;
    }
    public Double getPrice(){
        return price;
    }
    public Strategy getStrategy(){
        return strategy;
    }

    public String getDate() {
        return date;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // PROBABLY WILL NEED TO ADD THE DO TRADE THING HERE- that actually does the trade
}
