package new_code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;

public class DataReader {
    public static double[][] readFeatures(String filename, int number_of_features) throws IOException {
        List<double[]> featuresList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                String[] parts = line.split(";"); // dzielimy linie usuwajac znak ";"
                double[] features = new double[number_of_features]; // tablica o rozmiarze cech

                if (filename.contains("cancer")){
                    for (int i = 0; i < number_of_features; i++) {
                        features[i] = Double.parseDouble(parts[i+2]);
                        //System.out.println(features[i]);
                    }
                } else if (filename.contains("iris")){
                    for (int i = 0; i < number_of_features; i++) {
                        features[i] = Double.parseDouble(parts[i]);
                        //System.out.println(features[i]);
                    }
                }
                featuresList.add(features);
                //System.out.println(featuresList.size());

            }
            //System.out.println("Otworzono");
        }
        return featuresList.toArray(new double[featuresList.size()][number_of_features]);
    }

    public static double[] readLabels(String filename) throws IOException {
        List<Double> labelList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                String[] parts = line.split(";");

                if (filename.contains("cancer")) {
                    // Etykietą będzie druga kolumna dla plików z danymi o raku
                    labelList.add(Double.parseDouble(parts[1]));
                    //System.out.println(parts[1]);
                } else {
                    // Etykietą będzie ostatnia kolumna dla plików z danymi o irysach
                    labelList.add(Double.parseDouble(parts[parts.length - 1]));
                    //System.out.println(parts[parts.length - 1]);
                }
            }
            //System.out.println("Otworzono");
        }
        //System.out.println(labelList);
        return labelList.stream().mapToDouble(Double::doubleValue).toArray();
    }
}
