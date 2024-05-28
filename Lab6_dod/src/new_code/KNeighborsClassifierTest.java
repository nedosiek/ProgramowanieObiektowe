package new_code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KNeighborsClassifierTest {

    @Test
    void testPredict() {
        // Tworzenie klasyfikatora
        KNeighborsClassifier classifier = new KNeighborsClassifier(3, "euclidean");

        // Przykładowy zestaw danych dla iris
        double[][] X_train_iris = {{6.1, 2.8, 4.7, 1.2}, {4.9, 3.0, 1.4, 0.2}, {6.7, 3.1, 4.4, 1.4}};
        double[] Y_train_iris = {1, 0, 1}; // Zakładając 3 klasy, przyjmijmy etykiety 0 i 1

        double[][] X_test_iris = {{4.3, 3.0, 1.5, 0.2}};
        double[] expected_iris = {1}; // Oczekiwane predykcje dla iris

        // Dopasowanie modelu
        classifier.fit(X_train_iris, Y_train_iris);

        // Testowanie metody predict
        double[] predictions_iris = classifier.predict(X_test_iris);
        assertArrayEquals(expected_iris, predictions_iris);

        // Analogiczne testy dla zestawu danych cancer
        // Przykładowy zestaw danych dla cancer
        double[][] X_train_cancer = {{4.1, 5.2, 6.3}, {4.4, 5.5, 6.6}, {6.5, 3.5, 2.2}};
        double[] Y_train_cancer = {1, 1, 0}; // Zakładając 2 klasy

        double[][] X_test_cancer = {{4.5, 5.0, 6.5}};
        double[] expected_cancer = {1}; // Oczekiwane predykcje dla cancer

        // Dopasowanie modelu
        classifier.fit(X_train_cancer, Y_train_cancer);

        // Testowanie metody predict
        double[] predictions_cancer = classifier.predict(X_test_cancer);
        assertArrayEquals(expected_cancer, predictions_cancer);
    }

    @Test
    void testCalculateAccuracy() {
        // Tworzenie klasyfikatora
        KNeighborsClassifier classifier = new KNeighborsClassifier(3, "euclidean");

        // Przykładowy zestaw danych dla iris
        double[][] X_train_iris = {{5.1, 3.5, 1.4, 0.2}, {4.9, 3.0, 1.4, 0.2}, {6.7, 3.1, 4.4, 1.4}};
        double[] Y_train_iris = {0, 0, 1}; // Zakładając 3 klasy, przyjmijmy etykiety 0 i 1

        double[][] X_test_iris = {{6.5, 3.0, 5.5, 1.8}};
        double[] Y_test_iris = {0}; // Oczekiwane etykiety dla iris

        // Dopasowanie modelu
        classifier.fit(X_train_iris, Y_train_iris);

        // Testowanie metody calculate_accuracy
        double accuracy_iris = classifier.calculate_accuracy(X_test_iris, Y_test_iris);
        assertEquals(1.0, accuracy_iris);

        // Analogiczne testy dla zestawu danych cancer
        // Przykładowy zestaw danych dla cancer
        double[][] X_train_cancer = {{1.1, 2.2, 3.3}, {4.4, 5.5, 6.6}, {4.3, 5.7, 6.2}};
        double[] Y_train_cancer = {0, 1, 1}; // Zakładając 2 klasy

        double[][] X_test_cancer = {{1.0, 2.0, 3.0}};
        double[] Y_test_cancer = {1}; // Oczekiwane etykiety dla cancer

        // Dopasowanie modelu
        classifier.fit(X_train_cancer, Y_train_cancer);

        // Testowanie metody calculate_accuracy
        double accuracy_cancer = classifier.calculate_accuracy(X_test_cancer, Y_test_cancer);
        assertEquals(1.0, accuracy_cancer);
    }
}
