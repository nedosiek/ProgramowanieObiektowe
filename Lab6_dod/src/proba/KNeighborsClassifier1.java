package proba;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class KNeighborsClassifier1 {
    private int n_neighbors;
    private String metric;
    private double[][] X_train;
    private double[] Y_train;

    public KNeighborsClassifier1(int n_neighbors, String metric) {
        this.n_neighbors = n_neighbors;
        this.metric = metric;
    }

    public void fit(double[][] X_train, double[] Y_train) {
        this.X_train = X_train;
        this.Y_train = Y_train;
    }

    public double[] predict(double[][] X_test) {
        double[] predictions = new double[X_test.length];
        for (int i = 0; i < X_test.length; i++) {
            double[] x = X_test[i];
            predictions[i] = predictSingleSample(x);
        }
        return predictions;
    }

    public double calculateAccuracy(double[][] X_test, double[] Y_test) {
        double correctPredictions = 0;
        double[] predictions = predict(X_test);
        for (int i = 0; i < predictions.length; i++) {
            if (predictions[i] == Y_test[i]) {
                correctPredictions++;
            }
        }
        return correctPredictions / predictions.length;
    }

    private double predictSingleSample(double[] x) {
        Map<Double, Integer> classCounts = new HashMap<>();
        double[] distances = new double[X_train.length];
        for (int i = 0; i < X_train.length; i++) {
            distances[i] = distance(x, X_train[i]);
        }
        int[] sortedIndices = getSortedIndices(distances);
        for (int i = 0; i < n_neighbors; i++) {
            int neighborIndex = sortedIndices[i];
            double label = Y_train[neighborIndex];
            classCounts.put(label, classCounts.getOrDefault(label, 0) + 1);
        }
        double maxCount = 0;
        double predictedClass = -1;
        for (Map.Entry<Double, Integer> entry : classCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                predictedClass = entry.getKey();
            }
        }
        return predictedClass;
    }

    private double distance(double[] x1, double[] x2) {
        if (metric.equals("euclidean")) {
            return euclideanDistance(x1, x2);
        } else if (metric.equals("manhattan")) {
            return manhattanDistance(x1, x2);
        } else {
            throw new IllegalArgumentException("Unsupported metric: " + metric);
        }
    }

    private double euclideanDistance(double[] x1, double[] x2) {
        double sum = 0;
        for (int i = 0; i < x1.length; i++) {
            sum += Math.pow(x1[i] - x2[i], 2);
        }
        return Math.sqrt(sum);
    }

    private double manhattanDistance(double[] x1, double[] x2) {
        double sum = 0;
        for (int i = 0; i < x1.length; i++) {
            sum += Math.abs(x1[i] - x2[i]);
        }
        return sum;
    }

    private int[] getSortedIndices(double[] array) {
        Integer[] indices = new Integer[array.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (i1, i2) -> Double.compare(array[i1], array[i2]));
        return Arrays.stream(indices).mapToInt(Integer::intValue).toArray();
    }
}
