package Practica7;

import javax.swing.JOptionPane;

public class JuegoAdivinaImpar extends JuegoAdivinaNumero {

    public JuegoAdivinaImpar(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    @Override
    public boolean validaNumero(int numero) {
        if (!super.validaNumero(numero)) {
            JOptionPane.showMessageDialog(null, "Número fuera de rango (0-10).");
            return false;
        }
        if (numero % 2 == 0) {
            JOptionPane.showMessageDialog(null, "EL NUMERO DEBE SER IMPAR");
            return false;
        }
        return true;
    }
}
