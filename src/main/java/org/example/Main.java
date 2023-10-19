package org.example;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            //Crie uma série de dados XY para a função f(x)=x
            XYSeries series = new XYSeries("f(x) = x");
            for (double x = -10; x <= 10; x += 0.1) {
                double y;
                y= Math.pow(x,3);
                series.add(x, y);
            }
            //Conjunto de Dados com a série XY
            XYSeriesCollection dataset = new XYSeriesCollection(series);

            //Crie o gráfico
            JFreeChart chart = ChartFactory.createXYLineChart(

                    "Gráfico da Função f(x) = x",
                    "x", //Rótulo eixo x
                    "f(X)", //eixo y
                    dataset, //conjunto de dados
                    PlotOrientation.VERTICAL,
                    true, //mostrar legenda
                    true, //usar tool tips
                    false //usar urls
            );
            //Crie uma janela para exibir o gráfico
            JFrame frame = new JFrame("Gráfico da Função");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new ChartPanel(chart));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

}
