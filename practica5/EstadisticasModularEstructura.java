package practicas121;

public class EstadisticasModularEstructura {
    public static double promedio(double[] numeros) {
        double suma = 0;
        for (double num : numeros) {
            suma += num;
        }
        return suma / numeros.length;
    }

    public static double desviacion(double[] numeros) {
        double prom = promedio(numeros);
        double sumaCuadrados = 0;
        for (double num : numeros) {
            sumaCuadrados += Math.pow(num - prom, 2);
        }
        return Math.sqrt(sumaCuadrados / (numeros.length - 1));
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        double[] numeros = new double[10];
        System.out.println("Ingrese 10 números:");
        for (int i = 0; i < 10; i++) {
            numeros[i] = scanner.nextDouble();
        }
        scanner.close();
        
        System.out.printf("El promedio es %.2f\n", promedio(numeros));
        System.out.printf("La desviación estándar es %.5f\n", desviacion(numeros));
    }
}
