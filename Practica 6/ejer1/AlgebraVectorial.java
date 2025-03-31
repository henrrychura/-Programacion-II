package practica_6__121prog2;

public class AlgebraVectorial {
    private double x, y, z;


    public AlgebraVectorial() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }


    public AlgebraVectorial(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }


    public double norm() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double ProductoPunto(AlgebraVectorial b) {
        return this.x * b.getX() + this.y * b.getY() + this.z * b.getZ();
    }


    public AlgebraVectorial ProductoCruzado(AlgebraVectorial b) {
        return new AlgebraVectorial(
            this.y * b.getZ() - this.z * b.getY(),
            this.z * b.getX() - this.x * b.getZ(),
            this.x * b.getY() - this.y * b.getX()
        );
    }

    // Caso a: |a + b| = |a − b|
    public boolean Perpendicular(AlgebraVectorial b) {
        AlgebraVectorial suma = new AlgebraVectorial(this.x + b.getX(), this.y + b.getY(), this.z + b.getZ());
        AlgebraVectorial resta = new AlgebraVectorial(this.x - b.getX(), this.y - b.getY(), this.z - b.getZ());
        return suma.norm() == resta.norm();
    }

    // Caso b: |a − b| = |b − a|
    public boolean Perpendicular(AlgebraVectorial b, boolean mutualOrthogonality) {
        AlgebraVectorial restaAB = new AlgebraVectorial(this.x - b.getX(), this.y - b.getY(), this.z - b.getZ());
        AlgebraVectorial restaBA = new AlgebraVectorial(b.getX() - this.x, b.getY() - this.y, b.getZ() - this.z);
        return restaAB.norm() == restaBA.norm();
    }

    // Caso c: a · b = 0
    public boolean Perpendicular(AlgebraVectorial b, int dotProductCheck) {
        return this.ProductoPunto(b) == 0;
    }

    // Caso d: |a + b|² = |a|² + |b|²
    public boolean Perpendicular(AlgebraVectorial b, double tolerancia) {
        AlgebraVectorial suma = new AlgebraVectorial(this.x + b.getX(), this.y + b.getY(), this.z + b.getZ());
        double lhs = Math.pow(suma.norm(), 2);
        double rhs = Math.pow(this.norm(), 2) + Math.pow(b.norm(), 2);
        return Math.abs(lhs - rhs) < tolerancia;
    }

    // Caso e: a = r * b
    public boolean paralelismo(AlgebraVectorial b) {
        double ratioX = this.x / b.getX();
        double ratioY = this.y / b.getY();
        double ratioZ = this.z / b.getZ();
        return ratioX == ratioY && ratioY == ratioZ;
    }

    // Caso f: a × b = 0
    public boolean paralelismo(AlgebraVectorial b, boolean crossProductZero) {
        AlgebraVectorial cruz = this.ProductoCruzado(b);
        return cruz.getX() == 0 && cruz.getY() == 0 && cruz.getZ() == 0;
    }

    // Proyección de a sobre b
    public AlgebraVectorial proyeccion(AlgebraVectorial b) {
        double factor = this.ProductoPunto(b) / Math.pow(b.norm(), 2);
        return new AlgebraVectorial(b.getX() * factor, b.getY() * factor, b.getZ() * factor);
    }

    // Componente de a en la dirección de b
    public double componente(AlgebraVectorial b) {
        return this.ProductoPunto(b) / b.norm();
    }


    public static void main(String[] args) {
   
        AlgebraVectorial a = new AlgebraVectorial(3, 4, 0);
        AlgebraVectorial b = new AlgebraVectorial(4, -3, 0);

  
        System.out.println("------------------perpendicularidad-----------------");
        System.out.println("Caso a (|a + b| = |a - b|): " + a.Perpendicular(b));
        System.out.println("Caso b (|a - b| = |b - a|): " + a.Perpendicular(b, true));
        System.out.println("Caso c (a · b = 0): " + a.Perpendicular(b, 0));
        System.out.println("Caso d (|a + b|² = |a|² + |b|²): " + a.Perpendicular(b, 0.01));

        System.out.println("----------paralelismo------------");
        System.out.println("Caso e (a = r * b): " + a.paralelismo(b));
        System.out.println("Caso f (a × b = 0): " + a.paralelismo(b, true));

  
        AlgebraVectorial proyeccion = a.proyeccion(b);
        System.out.println("Proyección de a sobre b: (" + proyeccion.getX() + ", " + proyeccion.getY() + ", " + proyeccion.getZ() + ")");
        System.out.println("Componente de a en b: " + a.componente(b));
    }
}
