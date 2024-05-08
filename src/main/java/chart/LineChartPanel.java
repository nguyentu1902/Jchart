package chart;


import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
//public class LineChartPanel extends JPanel{
//    // driver that actually runs the thing
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater( () -> {
//            LineChartEx ex = new LineChartEx();
//            ex.setVisible(true);
//        });
//    }
//}

public class LineChartPanel extends JPanel {
    public LineChartPanel() {
        initUI();
    }

    private void initUI() {
        //create the series - add some dummy data
        XYSeries temperature = new XYSeries("temperature");
        XYSeries thickness = new XYSeries("thickness");
        XYSeries test = new XYSeries("test");

        temperature.add(1000, 1000);
        temperature.add(1150, 1150);
        temperature.add(1250, 1250);

        thickness.add(1000, 111250);
        thickness.add(1150, 211250);
        thickness.add(1250, 311250);

        test.add(1246, 314250);
        test.add(1446, 414250);
        test.add(1646, 214210);

        //create the datasets
        XYSeriesCollection dataTemperature = new XYSeriesCollection();
        XYSeriesCollection dataThickness = new XYSeriesCollection();
        XYSeriesCollection dataTest = new XYSeriesCollection();
        dataTemperature.addSeries(temperature);
        dataThickness.addSeries(thickness);
        dataTest.addSeries(test);

        //construct the plot
        XYPlot plot = new XYPlot();
        plot.setDataset(0, dataTemperature);
        plot.setDataset(1, dataThickness);
        plot.setDataset(2, dataTest);

        //customize the plot with renderers and axis
        plot.setRenderer(0, new XYSplineRenderer());//use default fill paint for first series
        XYSplineRenderer splinerenderer = new XYSplineRenderer();
        splinerenderer.setSeriesFillPaint(0, Color.BLUE);
        plot.setRenderer(1, splinerenderer);
        plot.setRangeAxis(0, new NumberAxis("Temperature"));
        plot.setRangeAxis(1, new NumberAxis("Thickness"));
        plot.setRangeAxis(2, new NumberAxis("Test"));
        plot.setDomainAxis(new NumberAxis("seq"));

        //Map the data to the appropriate axis
        plot.mapDatasetToRangeAxis(0, 0);
        plot.mapDatasetToRangeAxis(1, 1);
        plot.mapDatasetToRangeAxis(2, 2);

        //generate the chart
        JFreeChart chart = new JFreeChart("Rolling Coil Information Chart", getFont(), plot, true);
        chart.setBackgroundPaint(Color.WHITE);
        //JPanel jpanel = new ChartPanel(chart);


        // NEW PART THAT MAKES IT WORK
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

//        pack();
//        setTitle("Line chart");
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
