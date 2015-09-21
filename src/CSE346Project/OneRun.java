package CSE346Project;

import java.util.ArrayList;

/**
 *
 * @author Luming Wu
 * Just to clarify why I use integer over double. Double addition causes small error like 0.1*10^15. So I like an accurate integer
 * to be probability.
 */
public class OneRun {
    private ArrayList<Double> AverageThroughputA;
    private ArrayList<Double> AverageThroughputC;
    private int ATotal;
    private int CTotal;
    public OneRun(int times){
        mainFunction(times);
    }
    private boolean generateInput(double probability) {
        //Math.random generates a float number in double. Inclusive 0 to exclusive 1.
        return Math.random()*100 < probability;
    }

    private boolean FirstORGateA(boolean input1, boolean input2) {
        //Or gate
        boolean output = input1 || input2;
        //Record the process in console or memory.
        if (output) {
            ATotal = ATotal + 1;
        }
        return output;
    }
    
    private boolean FirstORGateB(boolean input1, boolean input2) {
        //Or gate
        return input1 || input2;
    }


    private boolean SecondORGateC(boolean input1, boolean input2) {
        //Or gate
        boolean output = input1 || input2;
        //Record the process in console
        if (output) {
            CTotal = CTotal + 1;
        }
        return output;
    }

    private void function(double probability) {
        //Recursion.
        SecondORGateC(FirstORGateA(generateInput(probability), generateInput(probability)),
                FirstORGateB(generateInput(probability), generateInput(probability)));
    }

    public void mainFunction(int times) {
        //Initialize data storage.
        AverageThroughputA = new ArrayList<Double>(50);
        AverageThroughputC = new ArrayList<Double>(50);
        //Change probability every time run function with times times.
        for(int i = 2; i <= 100; i = i + 2){
            ATotal = 0;
            CTotal = 0;
            // Run function times times.
            for(int j = 0; j < times; j++){
                function(i);
            }
            // Store average throughput into the memory.
            AverageThroughputA.add((double)ATotal / times);
            AverageThroughputC.add((double)CTotal / times);
        }
        
    }
    public ArrayList<Double> getListA(){
        return AverageThroughputA;
    }
    
    public ArrayList<Double> getListC(){
        return AverageThroughputC;
    }
}
