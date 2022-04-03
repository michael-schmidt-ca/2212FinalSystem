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
        System.out.println("In method createBar");
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//		Those are hard-coded values!!!!
//		You will have to come up with a proper datastructure to populate the BarChart with live data!
        dataset.setValue(6, "Trader-1", "Strategy-A");
        dataset.setValue(5, "Trader-2", "Strategy-B");
        dataset.setValue(0, "Trader-3", "Strategy-E");
        dataset.setValue(1, "Trader-4", "Strategy-C");
        dataset.setValue(10, "Trader-5", "Strategy-D");

        CategoryPlot plot = new CategoryPlot();
        BarRenderer barrenderer1 = new BarRenderer();

        plot.setDataset(0, dataset);
        plot.setRenderer(0, barrenderer1);
        CategoryAxis domainAxis = new CategoryAxis("Strategy");
        plot.setDomainAxis(domainAxis);
        LogAxis rangeAxis = new LogAxis("Actions(Buys or Sells)");
        rangeAxis.setRange(new Range(1.0, 20.0));
        plot.setRangeAxis(rangeAxis);

        //plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
        //plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis

        JFreeChart barChart = new JFreeChart("Actions Performed By Traders So Far", new Font("Serif", java.awt.Font.BOLD, 18), plot,
                true);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(600, 300));
        chartPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        chartPanel.setBackground(Color.white);
        MainUI.getInstance().updateStats(chartPanel);
    }

}
