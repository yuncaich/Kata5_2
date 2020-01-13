package View;

import Model.Histogram;


import java.awt.Dimension;
import javax.swing.JPanel;
import Model.Histogram;
import java.awt.Container;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame{
    private Histogram<String> histogram;

    public HistogramDisplay(Histogram histogram) {
        super("HISTOGRAM");
        this.histogram = histogram;
        this.setContentPane(createPanel()); 
        this.pack();
    }

    private Container createPanel() {
        ChartPanel chartpanel = new ChartPanel(createChart(createDataSet()));
        chartpanel.setPreferredSize(new Dimension(500,400));
        return chartpanel;
    }
    
    private DefaultCategoryDataset createDataSet() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for(String key : this.histogram.KeySet()) {
            dataSet.addValue(this.histogram.get(key), "", key);
        }
        return dataSet;
    }

    private JFreeChart createChart(DefaultCategoryDataset createDataSet) {
        JFreeChart chart = ChartFactory.createBarChart("Histogram JFreeChart", "Personas", "Nº Personas", createDataSet);
        return chart;
    }
    
    public void execute() {
        setVisible(true);
    }
    
}
