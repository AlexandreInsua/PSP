package examen2UdpNumeroPerfecto;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;

public class ClientRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            NumeroPerfectoClient prg = new NumeroPerfectoClient();
            //ATENTOS A LA IP del Servidor
            prg.init("localhost", ServerRunner.PORT);
            prg.runClient();
        } catch (IOException ex) {
            System.out.println("Error recibiendo o enviando");
        }
    }
}
