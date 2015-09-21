package CSE346Project;

import CSE346Project2.UI;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 *
 * @author Luming
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        //Set the number of times to generate 4 inputs and have one run with these inputs.
        int times = 1000000;
        OneRun simulator = new OneRun(times);
        
        UI root = new UI(primaryStage);
        
        XYChart.Series Aseries = new XYChart.Series();
        ArrayList<Double> listA = simulator.getListA();
        int index = 0;
        while (index < 50) {
            Aseries.getData().add(new XYChart.Data((index+1)*0.02,listA.get(index)));
            index = index + 1;
        }
        root.getA().getData().add(Aseries);
        Aseries.setName("Element A");
        
        XYChart.Series Cseries = new XYChart.Series();
        ArrayList<Double> listC = simulator.getListC();
        index = 0;
        while (index < 50) {
            Cseries.getData().add(new XYChart.Data((index+1)*0.02,listC.get(index)));
            index = index + 1;
        }
        root.getC().getData().add(Cseries);
        Cseries.setName("Element C");
                
        
        Scene scene = new Scene(root, 800, 1200);
        scene.getStylesheets().add(getClass().getResource("lineStyle.css").toExternalForm());
        
        primaryStage.setTitle("CSE346 Project One");
        primaryStage.setScene(scene);
        primaryStage.show();
                
    }/*
    public static void main(String[] args) {
        //launch(args);
    }*/
    
}
