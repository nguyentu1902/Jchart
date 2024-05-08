package chart;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import DAO.RollingCoilDataDAO;
import model.RollingCoilDataModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */


public class LineChartPanel extends JPanel {
    XYSeries temperature = new XYSeries("temperature");
    XYSeries thickness = new XYSeries("thickness");

    public LineChartPanel() {
        initUI();
    }

    public void setData(Boolean isCheckTemp, Boolean isCheckThickness, HashMap<Integer, Integer> hashMapDataTemperature, HashMap<Integer, Integer> hashMapDataThickness){
        List<RollingCoilDataModel> lstCoilDataModels = new RollingCoilDataDAO().getAllRollingCoilData();

        for (int i = 0; i < lstCoilDataModels.size(); i++) {
            hashMapDataTemperature.put(Integer.parseInt(lstCoilDataModels.get(i).getSeq()), lstCoilDataModels.get(i).getTemperature());
            hashMapDataThickness.put(Integer.parseInt(lstCoilDataModels.get(i).getSeq()), lstCoilDataModels.get(i).getThickness());
        }

        for(Map.Entry<Integer, Integer> entry : hashMapDataTemperature.entrySet()){
            temperature.add(entry.getKey(), entry.getValue());
        }

        for(Map.Entry<Integer, Integer> entry : hashMapDataThickness.entrySet()){
            thickness.add(entry.getKey(), entry.getValue());
        }

    }

    private void initUI() {
        // create the series - add some dummy data
        // XYSeries temperature = new XYSeries("temperature");
        // XYSeries thickness = new XYSeries("thickness");

        // temperature.add(100, 400);
        // temperature.add(400, 1150);
        // temperature.add(1250, 1250);

        // thickness.add(1000, 111250);
        // thickness.add(1150, 211250);
        // thickness.add(1250, 311250);
        // thickness.add(200, 200000);

        // create the datasets
        XYSeriesCollection dataTemperature = new XYSeriesCollection();
        XYSeriesCollection dataThickness = new XYSeriesCollection();
        dataTemperature.addSeries(temperature);
        dataThickness.addSeries(thickness);

        // construct the plot
        XYPlot plot = new XYPlot();
        plot.setDataset(0, dataTemperature);
        plot.setDataset(1, dataThickness);

        // customize the plot with renderers and axis
        // plot.setRenderer(0, new XYSplineRenderer());
        // XYSplineRenderer splinerenderer = new XYSplineRenderer();
        // splinerenderer.setSeriesFillPaint(0, Color.BLUE);
        // plot.setRenderer(1, splinerenderer);
        // plot.setRangeAxis(0, new NumberAxis("Temperature"));
        // plot.setRangeAxis(1, new NumberAxis("Thickness"));
        // plot.setDomainAxis(new NumberAxis("seq"));

        XYLineAndShapeRenderer lineForTemperature = new XYLineAndShapeRenderer();
        lineForTemperature.setSeriesFillPaint(0, Color.RED);
        XYLineAndShapeRenderer lineForThickness = new XYLineAndShapeRenderer();
        lineForTemperature.setSeriesFillPaint(0, Color.YELLOW);

        plot.setRenderer(0, lineForTemperature);
        plot.setRenderer(1, lineForThickness);
        plot.setRangeAxis(0, new NumberAxis("Temperature"));
        plot.setRangeAxis(1, new NumberAxis("Thickness"));
        plot.setDomainAxis(new NumberAxis("seq"));

        // Map the data to the appropriate axis
        plot.mapDatasetToRangeAxis(0, 0);
        plot.mapDatasetToRangeAxis(1, 1);

        // generate the chart
        JFreeChart chart = new JFreeChart("Rolling Coil Information Chart", getFont(), plot, true);
        chart.setBackgroundPaint(Color.WHITE);
        // JPanel jpanel = new ChartPanel(chart);

        // NEW PART THAT MAKES IT WORK
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        // pack();
        // setTitle("Line chart");
        // setLocationRelativeTo(null);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
