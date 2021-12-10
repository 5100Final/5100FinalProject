/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.util;

import Business.model.user.CountVO;
import java.awt.Color;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Animal
 */
public class BarChartEx extends JFrame {
    List<CountVO> list ;
    public BarChartEx() {

        initUI();
    }
    public BarChartEx(List<CountVO> list) {
        this.list = list;
        initUI();
    }
    private void initUI() {

        CategoryDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Bar chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private CategoryDataset createDataset() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
         for(CountVO pie:list){
          dataset.setValue(pie.getSum(),"Fee",pie.getType());
         }
//        dataset.setValue(46, "Gold medals", "USA");
//        dataset.setValue(38, "Gold medals", "China");
//        dataset.setValue(29, "Gold medals", "UK");
//        dataset.setValue(22, "Gold medals", "Russia");
//        dataset.setValue(13, "Gold medals", "South Korea");
//        dataset.setValue(11, "Gold medals", "Germany");

        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {

        JFreeChart barChart = ChartFactory.createBarChart(
                "Consumption ratio Bar Graph (All)",
                "",
                "Fee",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        return barChart;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            BarChartEx ex = new BarChartEx();
            ex.setVisible(true);
        });
    }

}