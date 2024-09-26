package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        // Listas para almacenar los datos X e Y del archivo CSV
        ArrayList<Double> xData = new ArrayList<>();
        ArrayList<Double> yData = new ArrayList<>();
        String line;

        // Leer los datos del archivo CSV
        try (BufferedReader br = new BufferedReader(new FileReader("data/data.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Separar los valores por coma
                xData.add(Double.parseDouble(values[0])); // Agregar los valores de X
                yData.add(Double.parseDouble(values[1])); // Agregar los valores de Y
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convertir las listas a arrays
        double[] x = xData.stream().mapToDouble(Double::doubleValue).toArray();
        double[] y = yData.stream().mapToDouble(Double::doubleValue).toArray();

        // Dividir los datos en entrenamiento y prueba
        DataSplitter.splitData(x, y, 0.7);

        // Entrenar un modelo con todos los datos
        SimpleLinearRegression model = new SimpleLinearRegression();
        model.train(x, y);

        // Realizar predicciones para todos los valores de X
        double[] predicted = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            predicted[i] = model.predict(x[i]);
        }

        // Calcular el coeficiente R^2 del modelo completo
        double rSquared = Evaluation.calculateRSquared(y, predicted);
        System.out.println("Coeficiente de Determinación (R^2): " + rSquared);
    }
}
