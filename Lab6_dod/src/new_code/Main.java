package new_code;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        testClassifier("iris", "train_data_iris.txt", "test_data_iris.txt");
        testClassifier("cancer", "train_data_cancer.txt", "test_data_cancer.txt");
    }

    public static void testClassifier(String dataset, String trainFile, String testFile){
        try {
            FileWriter writer = new FileWriter("results_" + dataset + ".txt");

            int[] n_neighborsValue = {3, 5, 7, 9, 11};
            String[] metricValue = {"euclidean", "manhattan"};

            for (int nNeighbor : n_neighborsValue) {
                for (String metric : metricValue){
                    //System.out.println(nNeighbor + " " + metric);
                    double[][] X_train = DataReader.readFeatures(trainFile, dataset.equals("iris") ? 4 : 30);
                    double[] Y_train = DataReader.readLabels(trainFile);

                    double[][] X_test = DataReader.readFeatures(testFile, dataset.equals("iris") ? 4 : 30);
                    double[] Y_test = DataReader.readLabels(testFile);

                    KNeighborsClassifier knnClassifier = new KNeighborsClassifier(nNeighbor, metric);

                    knnClassifier.fit(X_train, Y_train);
                    double accuracy_result = knnClassifier.calculate_accuracy(X_test, Y_test);
                    //System.out.println(accuracy_result);

                    writer.write("Dataset: " + dataset + ", n_neighbours: " + nNeighbor +
                            ", metric:" + metric + ", accuracy: " + accuracy_result + "\n");
                }
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }


    }
}
