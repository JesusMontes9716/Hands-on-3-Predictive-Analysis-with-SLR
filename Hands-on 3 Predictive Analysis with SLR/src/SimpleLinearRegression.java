package src;

// Clase para implementar la regresión lineal simple
public class SimpleLinearRegression {
    private double beta0; // Intercepto de la recta
    private double beta1; // Pendiente de la recta

    // Método para entrenar el modelo utilizando los datos de entrada X e Y
    public void train(double[] x, double[] y) {
        int n = x.length; // Cantidad de datos
        double sumX = 0, sumY = 0;

        // Sumar todos los valores de X y Y
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
        }

        // Calcular las medias de X y Y
        double meanX = sumX / n;
        double meanY = sumY / n;

        double sumXY = 0, sumXX = 0;

        // Calcular la suma de productos cruzados (sumXY) y la suma de cuadrados de X
        // (sumXX)
        for (int i = 0; i < n; i++) {
            sumXY += (x[i] - meanX) * (y[i] - meanY);
            sumXX += (x[i] - meanX) * (x[i] - meanX);
        }

        // Calcular los coeficientes beta1 (pendiente) y beta0 (intercepto)
        this.beta1 = sumXY / sumXX;
        this.beta0 = meanY - this.beta1 * meanX;
    }

    // Método para predecir el valor de Y para una nueva entrada X
    public double predict(double x) {
        return beta0 + beta1 * x;
    }

    // Obtener el valor de beta0 (intercepto)
    public double getBeta0() {
        return beta0;
    }

    // Obtener el valor de beta1 (pendiente)
    public double getBeta1() {
        return beta1;
    }
}
