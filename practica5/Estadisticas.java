package practicas121;

public class Estadisticas {
    private double[] numeros;
    
    public Estadisticas(double[] numeros) {
        this.numeros = numeros;
    }
    
    public double promedio() {
        double suma = 0;
        for (double num : numeros) {
            suma += num;
        }
        return suma / numeros.length;
    }
    
    public double desviacion() {
        double prom = promedio();
        double sumaCuadrados = 0;
        for (double num : numeros) {
            sumaCuadrados += Math.pow(num - prom, 2);
        }
        return Math.sqrt(sumaCuadrados / (numeros.length - 1));
    }
    
    public void mostrarResultados() {
        System.out.printf("El promedio es %.2f\n", promedio());
        System.out.printf("La desviación estándar es %.5f\n", desviacion());
    }
    
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        double[] numeros = new double[10];
        System.out.println("Ingrese 10 números:");
        for (int i = 0; i < 10; i++) {
            numeros[i] = scanner.nextDouble();
        }
        scanner.close();
        
        Estadisticas estadisticas = new Estadisticas(numeros);
        estadisticas.mostrarResultados();
    }
}
