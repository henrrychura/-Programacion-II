package practicas121;

import java.util.Scanner;

public class EcuacionCuadraticaModularEstructura {
	class EcuacionCuadratica {
	    public static double getDiscriminante(double a, double b, double c) {
	        return (b * b) - (4 * a * c);
	    }
	    
	    public static double getRaiz1(double a, double b, double c) {
	        double discriminante = getDiscriminante(a, b, c);
	        if (discriminante >= 0) {
	            return (-b + Math.sqrt(discriminante)) / (2 * a);
	        }
	        return Double.NaN;
	    }
	    
	    public static double getRaiz2(double a, double b, double c) {
	        double discriminante = getDiscriminante(a, b, c);
	        if (discriminante > 0) {
	            return (-b - Math.sqrt(discriminante)) / (2 * a);
	        }
	        return Double.NaN;
	    }
	    
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Ingrese a, b, c: ");
	        double a = scanner.nextDouble();
	        double b = scanner.nextDouble();
	        double c = scanner.nextDouble();
	        scanner.close();
	        
	        double discriminante = getDiscriminante(a, b, c);
	        if (discriminante > 0) {
	            System.out.printf("La ecuación tiene dos raíces %.5f y %.5f\n", getRaiz1(a, b, c), getRaiz2(a, b, c));
	        } else if (discriminante == 0) {
	            System.out.printf("La ecuación tiene una raíz %.5f\n", getRaiz1(a, b, c));
	        } else {
	            System.out.println("La ecuación no tiene raíces reales");
	        }
	    }
	}

}
