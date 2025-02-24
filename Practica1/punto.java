public class Punto {
    public float x;
    public float y;

    public Punto(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] coord_cartesianas() {
        return new float[]{this.x, this.y};
    }

    public float[] coord_polares() {
        float radio = (float) Math.sqrt(this.x * this.x + this.y * this.y);
        float angulo = (float) Math.toDegrees(Math.atan2(this.y, this.x));
        return new float[]{radio, angulo};
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", this.x, this.y);
    }

    public static void main(String[] args) {
        Punto p1 = new Punto(0, 3);
        System.out.println(p1);
        float[] cartesianas = p1.coord_cartesianas();
        System.out.println("Coordenadas Cartesianas: " + cartesianas[0] + ", " + cartesianas[1]);
        float[] polares = p1.coord_polares();
        System.out.println("Coordenadas Polares: Radio = " + polares[0] + ", Ángulo = " + polares[1]);
    }
}
