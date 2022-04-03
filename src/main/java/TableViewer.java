import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class TableViewer implements Observer{
    /*Table viewer = Observer 2 (observer design pattern)*/
    @Override
    public void update() {
        createTableOutput();
    }

    private void createTableOutput() {
        System.out.println("In method createTableOutput");
        // Dummy dates for demo purposes. These should come from selection menu
        Object[] columnNames = {"Trader","Strategy","CryptoCoin","Action","Quantity","Price","Date"};

        // Dummy data for demo purposes. These should come from actual fetcher
        Object[][] data = {
                {"Trader-1", "Strategy-A", "ETH", "Buy", "500", "150.3","13-January-2022"},
                {"Trader-2", "Strategy-B", "BTC", "Sell", "200", "50.2","13-January-2022"},
                {"Trader-3", "Strategy-C", "USDT", "Buy", "1000", "2.59","15-January-2022"},
                {"Trader-1", "Strategy-A", "USDC", "Buy", "500", "150.3","16-January-2022"},
                {"Trader-2", "Strategy-B", "ADA", "Sell", "200", "50.2","16-January-2022"},
                {"Trader-3", "Strategy-C", "SOL", "Buy", "1000", "2.59","17-January-2022"},
                {"Trader-1", "Strategy-A", "ONE", "Buy", "500", "150.3","17-January-2022"},
                {"Trader-2", "Strategy-B", "MANA", "Sell", "200", "50.2","17-January-2022"},
                {"Trader-3", "Strategy-C", "AVAX", "Buy", "1000", "2.59","19-January-2022"},
                {"Trader-1", "Strategy-A", "LUNA", "Buy", "500", "150.3","19-January-2022"},
                {"Trader-2", "Strategy-B", "FTM", "Sell", "200", "50.2","19-January-2022"},
                {"Trader-3", "Strategy-C", "HNT", "Buy", "1000", "2.59","20-January-2022"}
        };


        JTable table = new JTable(data, columnNames);
        //table.setPreferredSize(new Dimension(600, 300));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                "Trader Actions",
                TitledBorder.CENTER,
                TitledBorder.TOP));



        scrollPane.setPreferredSize(new Dimension(800, 300));
        table.setFillsViewportHeight(true);;

        MainUI.getInstance().updateStats(scrollPane);
    }
}
