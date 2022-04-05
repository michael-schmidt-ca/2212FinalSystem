import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.LogAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.Range;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HistogramViewer implements TradingObservers {
    /*Observer 1 = Histogram viewer (observer design pattern)*/
    private TradeLog tradeLog;
    HistogramViewer(TradeLog tradeLog){
        this.tradeLog = tradeLog;
    }
    @Override

    public void update() {
        createBar();
    }

    private void createBar() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //Object[][] realData = new Object[tradeLog.getTradeLog().size()][7];
        ArrayList<StrategyResult> trades = tradeLog.getTradeLog(); // Container holding actual trades

        for (int row=0; row < trades.size(); row++){
            //increment value in histogram
            try{
                dataset.incrementValue(1, trades.get(row).getBroker().getName(),trades.get(row).getStrategy().getName());
            } catch (Exception ex){ //if not present, add value to list at base value
                dataset.addValue(1, trades.get(row).getBroker().getName(),trades.get(row).getStrategy().getName());
            }
        }

        CategoryPlot plot = new CategoryPlot();
        BarRenderer barrenderer1 = new BarRenderer();

        plot.setDataset(0, dataset);
        plot.setRenderer(0, barrenderer1);
        CategoryAxis domainAxis = new CategoryAxis("Strategy");
        plot.setDomainAxis(domainAxis);
        LogAxis rangeAxis = new LogAxis("Actions(Buys or Sells)");
        rangeAxis.setRange(new Range(1.0, 20.0));
        plot.setRangeAxis(rangeAxis);

        JFreeChart barChart = new JFreeChart("Actions Performed By Traders So Far", new Font("Serif", java.awt.Font.BOLD, 18), plot,
                true);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(600, 300));
        chartPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        chartPanel.setBackground(Color.white);
        MainUI.getInstance().updateStats(chartPanel);
    }
}
