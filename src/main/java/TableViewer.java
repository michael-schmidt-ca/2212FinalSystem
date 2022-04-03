import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class TableViewer implements TradingObservers {

    /*Table viewer = Observer 2 (observer design pattern)*/
    @Override
    public void update() {
        createTableOutput();
    }
    private TradeLog tradeLog;
    TableViewer(TradeLog tradeLog){
        this.tradeLog = tradeLog;
    }

    private void createTableOutput() {
        //System.out.println("In method createTableOutput");
        // Dummy dates for demo purposes. These should come from selection menu
        Object[] columnNames = {"Trader","Strategy","CryptoCoin","Action","Quantity","Price","Date"};

        Object[][] data = toArray(); // SHOULD HAVE ACTUAL DATA
        for (Object[] o : data){ // test to see if its printing
            //System.out.println("================");
            for (Object s : o){
                //System.out.println(o);
                //System.out.println(s);
            }
        }

        JTable table = new JTable(data, columnNames);
        //table.setPreferredSize(new Dimension(600, 300));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                "Trader Actions",
                TitledBorder.CENTER,
                TitledBorder.TOP));

        scrollPane.setPreferredSize(new Dimension(800, 300));
        table.setFillsViewportHeight(true);

        MainUI.getInstance().updateStats(scrollPane);
    }
    private Object[][] toArray(){
        // Create a 2d array to store data in size of rows is num of trades, and each trade has 7 attributes ie the columns
        Object[][] realData = new Object[tradeLog.getTradeLog().size()][7];
        ArrayList<StrategyResult> trades = tradeLog.getTradeLog(); // Container holding actual trades
        for (int row =0; row<trades.size(); row++){ // cycling through trades
            for (int column = 0; column < 7; column++){
                switch (column){
                    case 0: {
                        realData[row][column] = trades.get(row).getBroker().getName(); // puts name into first col of each row
                        break;
                    }
                    case 1: {
                        realData[row][column] = trades.get(row).getStrategy().getName();
                        break;
                    }
                    case 2:{
                        realData[row][column]=trades.get(row).getCoin();
                        break;
                    }
                    case 3:
                    {
                        realData[row][column]=trades.get(row).getAction();
                        break;
                    }
                    case 4:{
                        realData[row][column]=trades.get(row).getQuantity();
                        break;
                    }
                    case 5:{
                        realData[row][column]=trades.get(row).getPrice();
                        break;
                    }
                    case 6:{
                        realData[row][column]=trades.get(row).getDate();
                        break;
                    }

                }// ENd of switch
            }// end of column for loop
        }// end of row loop
    return realData;
    }


}
