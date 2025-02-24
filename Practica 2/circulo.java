public class Punto {
  
}

public class Circulo {
    private Punto centro;
    private float radio;

    public Circulo(Punto centro, float radio) {
        this.centro = centro;
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "Circulo(" + centro + ", " + radio + ")";
    }

    public void dibujaCirculo() {
      
    }
}
