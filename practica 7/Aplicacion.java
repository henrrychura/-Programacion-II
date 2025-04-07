package Practica7;

import javax.swing.JOptionPane;

public class Aplicacion {
    public static void main(String[] args) {
        JuegoAdivinaNumero juegoNormal = new JuegoAdivinaNumero(3);
        JuegoAdivinaPar juegoPar = new JuegoAdivinaPar(3);
        JuegoAdivinaImpar juegoImpar = new JuegoAdivinaImpar(3);

        JOptionPane.showMessageDialog(null, "Juego 1: Adivina cualquier número");
        juegoNormal.juega();

        JOptionPane.showMessageDialog(null, "Juego 2: Adivina un número PAR");
        juegoPar.juega();

        JOptionPane.showMessageDialog(null, "Juego 3: Adivina un número IMPAR");
        juegoImpar.juega();
    }
}
