package examen2UdpNumeroPerfecto;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerRunner {


    public final static int PORT=9994;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            NumeroPerfectoServer prg = new NumeroPerfectoServer();
            prg.init(PORT);
            prg.runServer();
        } catch (IOException ex) {
            Logger.getLogger(ServerRunner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
