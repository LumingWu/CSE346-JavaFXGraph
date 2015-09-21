package CSE346Project2;

import java.util.Random;
/**
 *
 * @author Luming Wu
 */
public class Simulator {

    private double[] _3X3S = new double[100];
    private double[] _3X3D = new double[100];
    private double[] _4X4S = new double[100];
    private double[] _4X4D = new double[100];
    private double[] _5X5S = new double[100];
    private double[] _5X5D = new double[100];

    public Simulator() {
        
    }
    
    public void function(int times) {
        Random random = new Random();
        //Run for N=3,4,5.
        for (int n = 3; n <= 5; n++) {
            //Instead of unstable Double, using integer for probability is accurate.
            for (int probability = 1; probability <= 100; probability++) {
                //For each N's each probability, count the successes and drops.
                int successes = 0;
                int drops = 0;
                // Run as many times in the given N and given probability as user wants.
                for (int counter = 1; counter <= times; counter++) {
                    // boolean[] is automatically filled with false values in there. It repersents the status of the columns.
                    boolean[] status = new boolean[n];
                    //Number of input is the number of rows.
                    for (int row = 1; row <= n; row++) {
                        //Check if there is a output for this row.
                        if (random.nextInt(100) < probability) {
                            // One of the columns crossing this row gets an output.
                            int randomColumn = random.nextInt(n);
                            if (status[randomColumn]) {
                                //True, there is an existing output, drop this packet.
                                drops = drops + 1;
                            } else {
                                //False, no output in this column. Flip it to true and +1 success to this run.
                                successes = successes + 1;
                                status[randomColumn] = true;
                            }
                        }
                    }
                }
                //Store the data for each probability.
                switch (n) {
                    case 3: {
                        _3X3S[probability - 1] = (double) successes / times;
                        _3X3D[probability - 1] = (double) drops / times;
                        break;
                    }
                    case 4: {
                        _4X4S[probability - 1] = (double) successes / times;
                        _4X4D[probability - 1] = (double) drops / times;
                        break;
                    }
                    case 5: {
                        _5X5S[probability - 1] = (double) successes / times;
                        _5X5D[probability - 1] = (double) drops / times;
                        break;
                    }
                }
            }
        }
    }

    public double[] get3S() {
        return _3X3S;
    }

    public double[] get3D() {
        return _3X3D;
    }

    public double[] get4S() {
        return _4X4S;
    }

    public double[] get4D() {
        return _4X4D;
    }

    public double[] get5S() {
        return _5X5S;
    }

    public double[] get5D() {
        return _5X5D;
    }
}
