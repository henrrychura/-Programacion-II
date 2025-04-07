package Practica7;

import javax.swing.JOptionPane;
import java.util.Random;

public class JuegoAdivinaNumero extends Juego {
   private int numeroAAdivinar;

    public JuegoAdivinaNumero(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    public boolean validaNumero(int numero) {
        return numero >= 0 && numero <= 10;
    }

    public void juega() {
        reiniciaPartida();
        numeroAAdivinar = new Random().nextInt(11);

        while (numeroDeVidas > 0) {
            String input = JOptionPane.showInputDialog("Adivina un número entre 0 y 10:");
            int numeroUsuario;

            try {
                numeroUsuario = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Intenta de nuevo.");
                continue;
            }

            if (!validaNumero(numeroUsuario)) {
                JOptionPane.showMessageDialog(null, "Número inválido. Intenta de nuevo.");
                continue;
            }

            if (numeroUsuario == numeroAAdivinar) {
                JOptionPane.showMessageDialog(null, "    CORRECTO  ");
                actualizaRecord();
                break;
            } else {
                JOptionPane.showMessageDialog(null, "  INCORRECTO  ");
                if (!quitaVida()) {
                    JOptionPane.showMessageDialog(null, " PERDISTE TODAS TUS VIDAS ");
                    break;
                }
                String pista = numeroUsuario < numeroAAdivinar ? "mayor" : "menor";
                JOptionPane.showMessageDialog(null, "El número es " + pista + ". Intenta de nuevo.");
            }
        }
    }
}
