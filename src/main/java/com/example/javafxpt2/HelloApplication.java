package com.example.javafxpt2;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ValueAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {

    private final static XYChart.Series series = new XYChart.Series();
    private final static XYChart.Series series2 = new XYChart.Series();

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Time Data");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("time");
        xAxis.setLabel("input");

        series.setName("recursive");
        series2.setName("iterative");
        LineChart<Number,Number> chart = new LineChart<>(xAxis, yAxis);
        Scene scene = new Scene(chart,500, 500);
        chart.getData().addAll(series, series2);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println("Iterative");
        fibNumbers(n);

        System.out.println("-----------------------");
        System.out.println("Recursive");
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            long endTime = System.nanoTime();
            System.out.println(fibNumbers2(i) + "   " + (endTime - startTime));
            series.getData().add(new XYChart.Data(fibNumbers2(i), (endTime-startTime)));
        }

        launch();
    }


    //Iterative
    static void fibNumbers(int n) {

        int fib1 = 0, fib2 = 1, counter = 0;
        while (counter < n) {
            long startTime = System.nanoTime();
            for (int i = 0; i < n; i++) {
                long endTime = System.nanoTime();
                series2.getData().add(new XYChart.Data(i, (endTime-startTime)));
                System.out.println(fib1 + "   " + (endTime - startTime));
                int fib3 = fib1 + fib2;
                fib1 = fib2;
                fib2 = fib3;
                counter++;

            }
        }
    }

    //Recursive
    static int fibNumbers2(int n) {

        if (n < 2) {
            return n;
        } else
            return (fibNumbers2(n - 1) + fibNumbers2(n - 2));
    }}
