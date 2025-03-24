package practicas121;
import java.util.Scanner;

public class EcuacionCuadratica {
    class Ecuacion {
        private double a, b, c;

        public Ecuacion(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public double getDiscriminante() {
            return (b * b) - (4 * a * c);
        }

        public double getRaiz1() {
            double discriminante = getDiscriminante();
            if (discriminante >= 0) {
                return (-b + Math.sqrt(discriminante)) / (2 * a);
            }
            return Double.NaN;
        }

        public double getRaiz2() {
            double discriminante = getDiscriminante();
            if (discriminante > 0) {
                return (-b - Math.sqrt(discriminante)) / (2 * a);
            }
            return Double.NaN;
        }

        public void mostrarResultados() {
            double discriminante = getDiscriminante();
            if (discriminante > 0) {
                System.out.printf("La ecuación tiene dos raíces %.5f y %.5f\n", getRaiz1(), getRaiz2());
            } else if (discriminante == 0) {
                System.out.printf("La ecuación tiene una raíz %.5f\n", getRaiz1());
            } else {
                System.out.println("La ecuación no tiene raíces reales.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese a, b, c: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        scanner.close();

      
        EcuacionCuadratica contenedor = new EcuacionCuadratica();

        Ecuacion ecuacion = contenedor.new Ecuacion(a, b, c);
        ecuacion.mostrarResultados();
    }
}

