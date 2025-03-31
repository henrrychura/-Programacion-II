package practicas121;

public class AlgebraVectorialtridimencional {
    private double x, y, z; 

    public AlgebraVectorialtridimencional(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Método a.1) Suma de dos vectores
    public AlgebraVectorialtridimencional add(AlgebraVectorialtridimencional b) {
        return new AlgebraVectorialtridimencional(this.x + b.x, this.y + b.y, this.z + b.z);
    }

    // Método a.2) Suma de un escalar a cada componente del vector
    public AlgebraVectorialtridimencional add(double scalar) {
        return new AlgebraVectorialtridimencional(this.x + scalar, this.y + scalar, this.z + scalar);
    }

    // Método b.1) Multiplicación de un escalar por un vector
    public AlgebraVectorialtridimencional multiplyByScalar(double scalar) {
        return new AlgebraVectorialtridimencional(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    // Método b.2) Multiplicación componente por componente con otro vector
    public AlgebraVectorialtridimencional multiply(AlgebraVectorialtridimencional b) {
        return new AlgebraVectorialtridimencional(this.x * b.x, this.y * b.y, this.z * b.z);
    }

    // Método c) Longitud de un vector
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    // Método d) Normalización de un vector
    public AlgebraVectorialtridimencional normalize() {
        double len = length();
        if (len == 0) {
            return new AlgebraVectorialtridimencional(0, 0, 0); // Evitar división por cero
        }
        return new AlgebraVectorialtridimencional(x / len, y / len, z / len);
    }

    // Método e) Producto escalar
    public double dotProduct(AlgebraVectorialtridimencional b) {
        return this.x * b.x + this.y * b.y + this.z * b.z;
    }

    // Método f) Producto vectorial
    public AlgebraVectorialtridimencional crossProduct(AlgebraVectorialtridimencional b) {
        return new AlgebraVectorialtridimencional(
            this.y * b.z - this.z * b.y,
            this.z * b.x - this.x * b.z,
            this.x * b.y - this.y * b.x
        );
    }
  
    
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }


    public static void main(String[] args) {
   
        AlgebraVectorialtridimencional a = new AlgebraVectorialtridimencional(3, 4, 5);
        AlgebraVectorialtridimencional b = new AlgebraVectorialtridimencional(1, 2, 3);

     
        
        AlgebraVectorialtridimencional sumVector = a.add(b);
        AlgebraVectorialtridimencional sumScalar = a.add(10); 
        AlgebraVectorialtridimencional scaledVector = a.multiplyByScalar(2); 
        AlgebraVectorialtridimencional multipliedVector = a.multiply(b); 
        double lengthA = a.length(); 
        AlgebraVectorialtridimencional normalizedA = a.normalize(); 
        double dotProd = a.dotProduct(b); 
        AlgebraVectorialtridimencional crossProd = a.crossProduct(b);

        
        System.out.println("Suma de dos vectores (a + b): " + sumVector);
        System.out.println("Suma escalar a + 10: " + sumScalar);
        System.out.println("Multiplicación escalar a * 2: " + scaledVector);
        System.out.println("Multiplicación por componente (a * b): " + multipliedVector);
        System.out.println("Longitud de a: " + lengthA);
        System.out.println("Normalización de a: " + normalizedA);
        System.out.println("Producto escalar de a y b: " + dotProd);
        System.out.println("Producto vectorial de a y b: " + crossProd);
    }
}
