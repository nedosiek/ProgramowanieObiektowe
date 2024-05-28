package new_code;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class KNeighborsClassifier {
    public int n_neighbors;
    public String metric;
    public double[][] X_train;
    public double[] Y_train;

    public KNeighborsClassifier(int n_neighbors, String metric) {
        this.n_neighbors = n_neighbors;
        this.metric = metric;
    }

    public void fit(double[][] X_train, double[] Y_train){
        this.X_train = X_train;
        this.Y_train = Y_train;
    }

    public double[] predict(double[][] X_test){
        double[] predictions = new double[X_test.length];
        for (int i = 0; i < X_test.length; i++) {
            double[] x = X_test[i];
            predictions[i] = predictSimpleSample(x);
            //System.out.println(predictions[i]);
        }
        return predictions;
    }

    public double calculate_accuracy(double[][] X_test, double[] Y_test){
        double[] predictions = predict(X_test);
        double accuracy = 0;
        int minIndex = Math.min(X_train.length, X_test.length);
        for (int i = 0; i < minIndex; i++) { // uzywalem tutaj X_train.length zamiast minIndex
            if (predictions[i] == Y_test[i]) { //tutaj tez byl blad, teraz porownuje dokladne wartosci, natomiast wczesniej jezeli roznica byla mniejsza od 0.001
                accuracy++;
            }
        }
        //System.out.println(minIndex);
        return accuracy/minIndex;
    }

    public double predictSimpleSample(double[] x){
        Map<Double, Integer> counts = new HashMap<Double, Integer>();
        //double[][] X_train_sorted = new double[X_train.length][];
        double[] distances = new double[X_train.length];
        //System.out.println(X_train.length);
        for(int i = 0; i < X_train.length; i++){
            distances[i] = distance(x, X_train[i]);
            //System.out.println(distances[i]);
            //System.out.println(Arrays.toString(distances));
        }

        double[][] X_train_sorted = new double[X_train.length][X_train[0].length+2];
        /*for (int i = 0; i < X_train.length; i++) {
            X_train_sorted[i][X_train[0].length] = distances[i];
        }*/

        for (int i = 0; i < X_train.length; i++) {
            X_train_sorted[i][0] = distances[i];
            X_train_sorted[i][1] = Y_train[i];
            //System.out.println(Y_train[i]);
            for (int j = 2; j < X_train[0].length+2; j++) {
                //System.out.println(Y_train[j-2]);
                X_train_sorted[i][j] = X_train[i][j-2];
            }
            //System.out.println(distances[i]);
        }

        for(int i = 0; i < X_train_sorted.length; i++){ // czesciowo byl blad tutaj, bo sortowalem zaczynajac od 2 wiersza, a nie od 0
            for (int j = 1; j < X_train_sorted.length - i; j++) {
                if (X_train_sorted[j-1][0] > X_train_sorted[j][0]) {
                    // Swap myArray[j] and myArray[j+1]
                    double[] temp = X_train_sorted[j-1];
                    X_train_sorted[j-1] = X_train_sorted[j];
                    X_train_sorted[j] = temp;
                }
            }
            //System.out.println(Arrays.toString(X_train_sorted[i]));
        }

        //double[][] X_train_sorted = getSortedXTrain(X_train);
        //System.out.println(Arrays.toString(X_train_sorted));
        //System.out.println("Distances: " + distances.length);
        int[] sortedIndices = getSortedIndices(distances);
        //System.out.println(Arrays.toString(sortedIndices));
        //int k = Math.min(n_neighbors, X_train.length);
        //System.out.println(k);
        for(int i = 0; i < n_neighbors; i++){
            int index = sortedIndices[i];
            double label = X_train_sorted[index][1];
            //double label = Y_train[index];
            //double label = Y_train[index];
            counts.put(label, counts.getOrDefault(label, 0)+1);
        }
        double maxCount = 0;
        double predicted = -1;
        for (Map.Entry<Double, Integer> entry : counts.entrySet()) {
            if(entry.getValue() > maxCount){
                maxCount = entry.getValue();
                predicted = entry.getKey();
            }
        }
        return predicted;
    }

    public double distance(double[] x1, double[] x2){
        if (metric.equals("euclidean")){
            return euclideanDistance(x1, x2);
        } else if (metric.equals("manhattan")){
            return manhattanDistance(x1, x2);
        } else {
            throw new IllegalArgumentException("Unrecognized metric" + metric);
        }
    }

    public double euclideanDistance(double[] x1, double[] x2){
        double sum = 0;
        for(int i = 0; i < x1.length; i++){
            sum += Math.pow(x1[i] - x2[i], 2);
        }
        return Math.sqrt(sum);
    }

    public double manhattanDistance(double[] x1, double[] x2){
        double sum = 0;
        for(int i = 0; i < x1.length; i++){
            sum += Math.abs(x1[i] - x2[i]);
        }
        return sum;
    }

    public int[] getSortedIndices(double[] array){
        Integer[] indices = new Integer[array.length];
        for(int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices);
        return Arrays.stream(indices).mapToInt(Integer::intValue).toArray();
    }

    /*public double[][] getSortedXTrain(double[][] X_train){
        double[][] X_train_sorted = new double[X_train.length][X_train[0].length+1];
        for (int i = 0; i < X_train.length; i++) {

        }
        for (int i = 0; i < X_train.length; i++) {
            for (int j = 0; j < X_train[0].length; j++) {
                X_train_sorted[i][j] = X_train[i][j];
            }
        }

        for(int i = 0; i < X_train_sorted.length; i++){
            for (int j = 0; j < X_train_sorted.length - i - 1; j++) {
                if (X_train_sorted[j][i] > X_train_sorted[j+1][i]) {
                    // Swap myArray[j] and myArray[j+1]
                    double[] temp = X_train_sorted[j];
                    X_train_sorted[j] = X_train_sorted[j + 1];
                    X_train_sorted[j + 1] = temp;
                }
            }
        }
        //System.out.println(Arrays.toString(X_train_sorted));
        return X_train_sorted;
    }*/
}
