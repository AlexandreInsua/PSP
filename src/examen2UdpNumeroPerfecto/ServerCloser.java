package examen2UdpNumeroPerfecto;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Esta clase permite cerrar el servidor. Dispone solo de un metodo 
 * principal que conecta con el servidor haciendo la petición de cierre.
 */

public class ServerCloser {
    public static final int STOP = NumeroPerfectoServer.STOP;
    private String address;
    private int port;

    /**
     * Constructor de la clase. Recibe per defecto la direccion y el puerto del servidor 
     * donde ha de enviar la información,
     * @param adress es la direccion IP, dominio o nombre del host del servidor
     * @param port es el puerto que atiende el servidor al cual conectarse
     */
    
    public ServerCloser(String adress, int port) {
        this.address = adress;
        this.port = port;
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {//ATENTOS A LA IP del servidor
            ServerCloser cli = new ServerCloser("localhost",
                                                   ServerRunner.PORT);
            cli.closeServer();
        } catch (IOException ex) {
            Logger.getLogger(ServerCloser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Envia la orden al servidor para que se cierre.
     * @throws IOException en caso de que no se encuentre el servidor.
     */
    public void closeServer() throws IOException{
        DatagramSocket s = new DatagramSocket();
        try{
            InetAddress addr = InetAddress.getByName(address);
            ByteArrayOutputStream arrayOutput = new ByteArrayOutputStream(
                                                       Integer.SIZE);
            DataOutputStream output = new DataOutputStream(arrayOutput);
            
            output.writeInt(STOP);
            byte[] salida = arrayOutput.toByteArray();
            DatagramPacket paqueteSalida = new DatagramPacket(salida, 
            		salida.length, addr, port);
            s.send(paqueteSalida);
            s.close();
        } catch (IOException e) {}
    }
    
}
