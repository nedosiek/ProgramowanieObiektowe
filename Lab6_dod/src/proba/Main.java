package proba;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Testowanie klasyfikatora KNN na danych iris
        testClassifier("iris", "train_data_iris.txt", "test_data_iris.txt");

        // Testowanie klasyfikatora KNN na danych cancer
        testClassifier("cancer", "train_data_cancer.txt", "test_data_cancer.txt");
    }

    private static void testClassifier(String dataset, String trainFile, String testFile) {
        try {
            FileWriter writer = new FileWriter("results_" + dataset + ".txt");

            int[] nNeighborsValues = {3, 5, 7, 9, 11};
            String[] metricValues = {"euclidean", "manhattan"};

            for (int nNeighbors : nNeighborsValues) {
                for (String metric : metricValues) {
                    KNeighborsClassifier1 knnClassifier = new KNeighborsClassifier1(nNeighbors, metric);

                    double[][] X_train = DataReader1.loadFeatures(trainFile, dataset.equals("Iris") ? 4 : 30);
                    double[] Y_train = DataReader1.loadLabels(trainFile);

                    double[][] X_test = DataReader1.loadFeatures(testFile, dataset.equals("Iris") ? 4 : 30);
                    double[] Y_test = DataReader1.loadLabels(testFile);

                    knnClassifier.fit(X_train, Y_train);
                    double accuracy = knnClassifier.calculateAccuracy(X_test, Y_test);

                    writer.write("Dataset: " + dataset + ", n_neighbors: " + nNeighbors + ", metric: " + metric +
                            ", accuracy: " + accuracy + "\n");
                }
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
