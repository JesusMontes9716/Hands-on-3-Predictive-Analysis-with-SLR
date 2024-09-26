package src;

// Clase para calcular el coeficiente de determinación R^2
public class Evaluation {

    // Método para calcular R^2 basado en los valores reales y predichos
    public static double calculateRSquared(double[] actual, double[] predicted) {
        double meanActual = 0;

        // Calcular la media de los valores reales
        for (double v : actual) {
            meanActual += v;
        }
        meanActual /= actual.length;

        // Inicializar las sumas de cuadrados
        double ssTotal = 0, ssResidual = 0;

        // Calcular el total de sumas de cuadrados (ssTotal) y la suma residual
        // (ssResidual)
        for (int i = 0; i < actual.length; i++) {
            ssTotal += Math.pow(actual[i] - meanActual, 2);
            ssResidual += Math.pow(actual[i] - predicted[i], 2);
        }

        // Retornar el valor de R^2
        return 1 - (ssResidual / ssTotal);
    }
}
