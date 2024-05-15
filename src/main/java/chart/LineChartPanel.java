package chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.Range;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.event.ChangeListener;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */

public class LineChartPanel extends JPanel implements ChangeListener {
    private static int SLIDER_INITIAL_VALUE = 50;
    private JSlider slider;
    private NumberAxis domainAxisSeq;
    private int lastValue = SLIDER_INITIAL_VALUE;
    private XYSeries temperature = new XYSeries("temperature");
    private XYSeries thickness = new XYSeries("thickness");
    private XYPlot plot = new XYPlot();

    // one month (milliseconds, seconds, minutes, hours, days)
    private int delta = 20;

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

        domainAxisSeq = new NumberAxis("seq");
        domainAxisSeq.setTickUnit(new NumberTickUnit(20));
        
        plot.setDomainAxis(domainAxisSeq);

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
        chartPanel.setDomainZoomable(true);
        chartPanel.setRangeZoomable(true);
        chartPanel.setPreferredSize(new Dimension(1150, 400));

        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);

        JPanel sliderPanel = new JPanel(new BorderLayout());
        sliderPanel.setBorder(BorderFactory.createEmptyBorder(0, 4, 4, 4));
        this.slider = new JSlider(0, 100, SLIDER_INITIAL_VALUE);
        this.slider.addChangeListener(this);
        sliderPanel.add(this.slider, BorderLayout.SOUTH);

        this.setLayout(new BorderLayout());
        this.add(chartPanel, BorderLayout.CENTER);
        this.add(sliderPanel, BorderLayout.SOUTH);

        this.setBorder(BorderFactory.createEmptyBorder(0, 4, 4, 4));

        // add(chartPanel, BorderLayout.SOUTH);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updatePreferredSize();
            }
        });
        // pack();
        // setTitle("Line chart");
        // setLocationRelativeTo(null);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void updatePreferredSize() {
        int width = getParent().getWidth();
        int height = getPreferredSize().height;
        setPreferredSize(new Dimension(width, height));
        revalidate();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub
        int value = this.slider.getValue();
        double minimum = domainAxisSeq.getLowerBound();
        double maximum = domainAxisSeq.getUpperBound();
        if (value < lastValue) {
            minimum -= delta;
            maximum -= delta;
        } else {
            minimum += delta;
            maximum += delta;
        }
        Range range = new Range(minimum, maximum);
        domainAxisSeq.setRange(range);
        lastValue = value;
    }

}
