package CSE346Project2;

import javafx.application.Application;
import static javafx.application.Application.launch;
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
        //Set the number of times
        int times = 1000000;//1000000
        UI root = new UI(primaryStage);
        Simulator simulator = new Simulator();
        simulator.function(times);
        
        XYChart.Series series3S = new XYChart.Series();
        XYChart.Series series4S = new XYChart.Series();
        XYChart.Series series5S = new XYChart.Series();
        double[] list3S = simulator.get3S();
        double[] list4S = simulator.get4S();
        double[] list5S = simulator.get5S();
        XYChart.Series seriesFormula3 = new XYChart.Series();
        XYChart.Series seriesFormula4 = new XYChart.Series();
        XYChart.Series seriesFormula5 = new XYChart.Series();
        int index = 0;
        while (index < 100) {
            //Simulator Line
            series3S.getData().add(new XYChart.Data((index+1)*0.01,list3S[index]));
            series4S.getData().add(new XYChart.Data((index+1)*0.01,list4S[index]));
            series5S.getData().add(new XYChart.Data((index+1)*0.01,list5S[index]));
            //Theoretical Line
            //
            seriesFormula3.getData().add(new XYChart.Data((index+1)*0.01, 3*(1-(1-(index+1)*0.01/3)*(1-(index+1)*0.01/3)
                    *(1-(index+1)*0.01/3)) ));
            seriesFormula4.getData().add(new XYChart.Data((index+1)*0.01, 4*(1-(1-(index+1)*0.01/4)*(1-(index+1)*0.01/4)
                    *(1-(index+1)*0.01/4)*(1-(index+1)*0.01/4)) ));
            seriesFormula5.getData().add(new XYChart.Data((index+1)*0.01, 5*(1-(1-(index+1)*0.01/5)*(1-(index+1)*0.01/5)
                    *(1-(index+1)*0.01/5)*(1-(index+1)*0.01/5)*(1-(index+1)*0.01/5)) ));
            //
            //Theoretical Line
            index = index + 1;
        }
        series3S.setName("3X3 Successes(Red)");
        series4S.setName("4X4 Successes(Yellow)");
        series5S.setName("5X5 Successes(Green)");
        seriesFormula3.setName("Theoretical Successes for N=3(Teal)");
        seriesFormula4.setName("Theoretical Successes for N=4(Blue)");
        seriesFormula5.setName("Theoretical Successes for N=5(Purple)");
        root.getA().getData().add(series3S);
        root.getA().getData().add(series4S);
        root.getA().getData().add(series5S);
        root.getA().getData().add(seriesFormula3);
        root.getA().getData().add(seriesFormula4);
        root.getA().getData().add(seriesFormula5);
        
        XYChart.Series series3D = new XYChart.Series();
        XYChart.Series series4D = new XYChart.Series();
        XYChart.Series series5D = new XYChart.Series();
        double[] list3D = simulator.get3D();
        double[] list4D = simulator.get4D();
        double[] list5D = simulator.get5D();
        index = 0;
        while (index < 100) {
            series3D.getData().add(new XYChart.Data((index+1)*0.01,list3D[index]));
            series4D.getData().add(new XYChart.Data((index+1)*0.01,list4D[index]));
            series5D.getData().add(new XYChart.Data((index+1)*0.01,list5D[index]));
            index = index + 1;
        }
        series3D.setName("3X3 Drops(Red)");
        series4D.setName("4X4 Drops(Yellow)");
        series5D.setName("5X5 Drops(Green)");
        root.getC().getData().add(series3D);
        root.getC().getData().add(series4D);
        root.getC().getData().add(series5D);
        
        Scene scene = new Scene(root, 800, 1200);
        scene.getStylesheets().add(getClass().getResource("lineStyle.css").toExternalForm());
        
        primaryStage.setTitle("CSE346 Project Two");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
    }
}

