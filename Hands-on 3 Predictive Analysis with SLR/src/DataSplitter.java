package src;

import java.util.Random;

// Clase para dividir el conjunto de datos en subconjuntos de entrenamiento y prueba
public class DataSplitter {

    // Método para dividir los datos en dos partes: entrenamiento y prueba
    public static void splitData(double[] x, double[] y, double trainRatio) {
        int n = x.length; // Cantidad total de datos
        int trainSize = (int) (n * trainRatio); // Tamaño del conjunto de entrenamiento

        // Arrays para almacenar los datos de entrenamiento y prueba
        double[] trainX = new double[trainSize];
        double[] trainY = new double[trainSize];
        double[] testX = new double[n - trainSize];
        double[] testY = new double[n - trainSize];

        // Usar números aleatorios para dividir los datos
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int index = random.nextInt(n); // Generar un índice aleatorio
            if (i < trainSize) {
                trainX[i] = x[index]; // Asignar los valores al conjunto de entrenamiento
                trainY[i] = y[index];
            } else {
                testX[i - trainSize] = x[index]; // Asignar los valores al conjunto de prueba
                testY[i - trainSize] = y[index];
            }
        }

        // Entrenar el modelo de regresión lineal con los datos de entrenamiento
        SimpleLinearRegression model = new SimpleLinearRegression();
        model.train(trainX, trainY);

        // Hacer predicciones en el conjunto de prueba
        for (int i = 0; i < testX.length; i++) {
            double predicted = model.predict(testX[i]); // Predicción
            System.out.println("Real: " + testY[i] + ", Predicción: " + predicted);
        }
    }
}
