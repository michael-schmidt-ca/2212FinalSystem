import java.time.LocalDate;

public class StrategyResult {
    // Need quantity/ coin/ action
    private int quantity;
    private String coin;
    private String action;
    private LocalDate date;
    private Double price;

    public StrategyResult(int quantity, String coin, String action, LocalDate date, Double price) {
        this.quantity = quantity;
        this.coin = coin;
        this.action = action;
        this.date = date;
        this.price = price;
    }


    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
