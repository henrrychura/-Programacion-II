public class FiguraGeometrica {
    
    double area(double radio) {
        return Math.PI * radio * radio;
    }
    
    double area(double base, float altura) {
        return base * altura;
    }
    
    double area(double base, double altura) { 
        return 0.5 * base * altura;
    }
    
    double area(double base1, double base2, double altura) {
        return 0.5 * (base1 + base2) * altura;
    }
    
    double area(float lado) { 
        return (3 * Math.sqrt(3) / 2) * lado * lado;
    }
    
    public static void main(String[] args) {
        FiguraGeometrica f1 = new FiguraGeometrica();
        FiguraGeometrica f2 = new FiguraGeometrica();
        FiguraGeometrica f3 = new FiguraGeometrica();
        FiguraGeometrica f4 = new FiguraGeometrica();
        FiguraGeometrica f5 = new FiguraGeometrica();
        
        System.out.println("Circulo: " + f1.area(5));
        System.out.println("Rectangulo:" + f2.area(2,3));
        System.out.println("Triangulo Rectangulo: " + f3.area(4,6));
        System.out.println("Trapecio: " + f4.area(4,6,8));
        System.out.println("Hexagono: " + f5.area(7));
    }
    
    
}