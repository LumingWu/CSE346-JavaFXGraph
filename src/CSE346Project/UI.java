package CSE346Project;

import javafx.geometry.Pos;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Luming
 */
public class UI extends BorderPane{
    private LineChart<Number, Number> AChart;
    private LineChart<Number, Number> CChart;
    public UI(Stage primaryStage){
        ScrollPane scrollPane = new ScrollPane();
        setCenter(scrollPane);
        
        VBox _vbox = new VBox();
        scrollPane.setContent(_vbox);
        _vbox.setAlignment(Pos.CENTER);
        _vbox.setSpacing(50);
        
        NumberAxis throughputA = new NumberAxis();
        throughputA.setLabel("Probability");
        NumberAxis probabilityA = new NumberAxis();
        probabilityA.setLabel("Throughput");
        AChart = new LineChart<Number,Number>(throughputA, probabilityA);
        AChart.setPrefSize(600, 600);
        _vbox.getChildren().add(AChart);
        
        NumberAxis throughputC = new NumberAxis();
        throughputC.setLabel("Probability");
        NumberAxis probabilityC = new NumberAxis();
        probabilityC.setLabel("Throughput");
        CChart = new LineChart<Number,Number>(throughputC, probabilityC);
        CChart.setPrefSize(600, 600);
        _vbox.getChildren().add(CChart);
    }
    
    public LineChart getA(){
        return AChart;
    }
    
    public LineChart getC(){
        return CChart;
    }
    
    
}
