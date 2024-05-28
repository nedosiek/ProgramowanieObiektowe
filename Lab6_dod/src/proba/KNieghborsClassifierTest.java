package proba;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class KNieghborsClassifierTest {

    @Test
    void testLoadFeatures_Iris() {
        try {
            double[][] features = DataReader1.loadFeatures("train_data_iris.txt", 4);
            assertEquals(105, features.length);
            assertEquals(4, features[0].length);
            assertEquals(5.5, features[0][0]);
        } catch (IOException e) {
            fail("IOException should not be thrown: " + e.getMessage());
        }
    }

    @Test
    void testLoadLabels_Iris() {
        try {
            double[] labels = DataReader1.loadLabels("train_data_iris.txt");
            assertEquals(105, labels.length);
            assertEquals(1.0, labels[0]);
        } catch (IOException e) {
            fail("IOException should not be thrown: " + e.getMessage());
        }
    }

    @Test
    void testLoadFeatures_Cancer() {
        try {
            double[][] features = DataReader1.loadFeatures("train_data_cancer.txt", 30);
            assertEquals(398, features.length);
            assertEquals(30, features[0].length);
            assertEquals(87930.0, features[0][0]);
        } catch (IOException e) {
            fail("IOException should not be thrown: " + e.getMessage());
        }
    }

    @Test
    void testLoadLabels_Cancer() {
        try {
            double[] labels = DataReader1.loadLabels("train_data_cancer.txt");
            assertEquals(398, labels.length);
            assertEquals(0.0875, labels[0]);
        } catch (IOException e) {
            fail("IOException should not be thrown: " + e.getMessage());
        }
    }
}
