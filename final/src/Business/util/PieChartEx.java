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
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Animal
 */
public class PieChartEx extends JFrame {
    List<CountVO> list ;
    public PieChartEx(List<CountVO> list) {
        this.list = list;
        initUI();
    }
    
     public PieChartEx() {
        initUI();
    }
    private void initUI() {

        DefaultPieDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Pie chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private DefaultPieDataset createDataset() {

        DefaultPieDataset dataset = new DefaultPieDataset();
         for(CountVO pie:list){
          dataset.setValue(pie.getType(),pie.getSum());
         }
//        dataset.setValue("Apache", 52);
//        dataset.setValue("Nginx", 31);
//        dataset.setValue("IIS", 12);
//        dataset.setValue("LiteSpeed", 2);
//        dataset.setValue("Google server", 1);
//        dataset.setValue("Others", 2);

        return dataset;
    }

    private JFreeChart createChart(DefaultPieDataset dataset) {

        JFreeChart barChart = ChartFactory.createPieChart(
                "Organization ratio Graph",
                dataset,
                false, true, false);

        return barChart;
    }

}
