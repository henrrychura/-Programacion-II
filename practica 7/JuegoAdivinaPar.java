package Practica7;

import javax.swing.JOptionPane;

public class JuegoAdivinaPar extends JuegoAdivinaNumero {

    public JuegoAdivinaPar(int numeroDeVidas) {
        super(numeroDeVidas);
    }


    public boolean validaNumero(int numero) {
        if (!super.validaNumero(numero)) {
            JOptionPane.showMessageDialog(null, "Número fuera de rango (0-10)");
            return false;
        }
        if (numero % 2 != 0) {
            JOptionPane.showMessageDialog(null, "EL NUMERO DEBE SER PAR");
            return false;
        }
        return true;
    }
}
