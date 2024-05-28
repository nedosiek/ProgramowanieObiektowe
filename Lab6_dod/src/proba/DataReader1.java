package proba;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader1 {
    public static double[][] loadFeatures(String filename, int numFeatures) throws IOException {
        List<double[]> featuresList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine(); // Pominięcie pierwszej linii
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                double[] features = new double[numFeatures]; // Utwórz tablicę o odpowiednim rozmiarze
                for (int i = 0; i < numFeatures; i++) {
                    features[i] = Double.parseDouble(parts[i]); // Użyj indeksu 0 do numFeatures-1
                }
                featuresList.add(features);
            }
        }
        return featuresList.toArray(new double[0][0]);
    }

    public static double[] loadLabels(String filename) throws IOException {
        List<Double> labelsList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine(); // Pominięcie pierwszej linii
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                labelsList.add(Double.parseDouble(parts[parts.length - 1])); // Użyj ostatniego elementu
            }
        }
        return labelsList.stream().mapToDouble(Double::doubleValue).toArray();
    }
}
