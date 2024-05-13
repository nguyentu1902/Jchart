package chart;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;

import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.DateRange;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import javax.swing.event.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */

public class LineChartPanel extends JPanel {
    private XYSeries temperature = new XYSeries("temperature");
    private XYSeries thickness = new XYSeries("thickness");
    private XYPlot plot = new XYPlot();

    public LineChartPanel() {
        initUI();
    }

    public void setData(Boolean isCheckTemp, Boolean isCheckThickness, HashMap<Integer, Integer> hashMapDataTemperature,
            HashMap<Integer, Integer> hashMapDataThickness) {
        temperature.clear();
        thickness.clear();
        if (isCheckTemp && isCheckThickness) {
            for (Map.Entry<Integer, Integer> entry : hashMapDataTemperature.entrySet()) {
                temperature.add(entry.getKey(), entry.getValue());
            }
            for (Map.Entry<Integer, Integer> entry : hashMapDataThickness.entrySet()) {
                thickness.add(entry.getKey(), entry.getValue());
            }
        } else if (isCheckTemp && !isCheckThickness) {
            for (Map.Entry<Integer, Integer> entry : hashMapDataTemperature.entrySet()) {
                temperature.add(entry.getKey(), entry.getValue());
            }
        } else if (!isCheckTemp && isCheckThickness) {
            for (Map.Entry<Integer, Integer> entry : hashMapDataThickness.entrySet()) {
                thickness.add(entry.getKey(), entry.getValue());
            }
        }

    }

    private void initUI() {
        // create the datasets
        XYSeriesCollection dataTemperature = new XYSeriesCollection();
        XYSeriesCollection dataThickness = new XYSeriesCollection();
        dataTemperature.addSeries(temperature);
        dataThickness.addSeries(thickness);

        // construct the plot
        plot.setDataset(0, dataTemperature);
        plot.setDataset(1, dataThickness);

        XYLineAndShapeRenderer lineForTemperature = new XYLineAndShapeRenderer();
        lineForTemperature.setSeriesFillPaint(0, Color.RED);
        XYLineAndShapeRenderer lineForThickness = new XYLineAndShapeRenderer();
        lineForTemperature.setSeriesFillPaint(0, Color.BLUE);

        NumberAxis domainAxix = new NumberAxis("seq");
        domainAxix.setTickUnit(new NumberTickUnit(50));
        plot.setDomainAxis(domainAxix);

        plot.setRenderer(0, lineForTemperature);
        plot.setRenderer(1, lineForThickness);
        plot.setRangeAxis(0, new NumberAxis("Temperature"));
        plot.setRangeAxis(1, new NumberAxis("Thickness"));

        // Map the data to the appropriate axis
        plot.mapDatasetToRangeAxis(0, 0);
        plot.mapDatasetToRangeAxis(1, 1);

        // generate the chart
        JFreeChart chart = new JFreeChart("Rolling Coil Information Chart", getFont(), plot, true);
        chart.setBackgroundPaint(Color.WHITE);
        // JPanel jpanel = new ChartPanel(chart);

        // NEW PART THAT MAKES IT WORK
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(1150, 400));

        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);


        add(chartPanel);

        // pack();
        // setTitle("Line chart");
        // setLocationRelativeTo(null);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
