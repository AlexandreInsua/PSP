package examen2UdpNumeroPerfecto;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NumeroPerfectoServer {

    public final static int STOP=-1;
    DatagramSocket socket;
    
    public void init(int port) throws SocketException{
        socket = new DatagramSocket(port);
    }
    
    public void runServer() throws IOException{
        boolean finish=false;
        byte [] receivingData = new byte[1024];
        byte [] sendingData;
        InetAddress clientIP;
        int clientPort;

        //El servidor atiende el puerto indefinidamente
        while(!finish){
            //creación del paquete para recibir los datos
            DatagramPacket packet = new DatagramPacket(receivingData, 1024);
            //Espera de los datos
            socket.receive(packet);
            //procesamiento de los datos recibidos y obtención de la respuesta
            sendingData = processData(packet.getData(), packet.getLength());
            
            if(isFinishedSignal(sendingData)){
                finish=true;
            }else{
                //obtención de la direccion del cliente
                clientIP = packet.getAddress();
               //MUESTRA EL CLIENTE
                System.out.println("mostramos la IP del Cliente");
                System.out.println(clientIP);
                System.out.println();
                //obtención del puerto del cliente
                clientPort = packet.getPort();
                System.out.println("mostramos el Puerto del Cliente");
                System.out.println(clientPort);
                System.out.println();
                //Creación del paquete para enviar la respuesta
                packet = new DatagramPacket(sendingData, sendingData.length, 
                                               clientIP, clientPort);
                //envio de la respuesta
                socket.send(packet);
            }
        }
        close();
    }
    
    public void close(){
        if(socket!=null && !socket.isClosed()){
            socket.close();
        }
    }
    private int esPerfecto(int a){
    	int[] divisores = new int[a-1];
    	int j=0;
    	for (int i = 1; i < a; i++) {
			if(a%i==0){
				divisores[j]=i;
				j++;
			}
		}
    	int resultado=0;
    	for (int i = 0; i < divisores.length; i++) {
			resultado+=divisores[i];
		}
    	if(resultado==a){
    		return 1;
    	}else{
        	return 0;
    	}
    	
    }
    //CODIGO A MANIPULAR EN FUNCION DEL SERVICIO OFRECIDO
    protected byte[] processData(byte[] data, int length){
        byte ret[] ={-1, -1}; //error
        int dato;
        int response=STOP; //close server
        DataInputStream in = new DataInputStream(
                            new ByteArrayInputStream(data, 0, length));
        try {
            dato = in.readInt();
            if(dato!=STOP){
                response = esPerfecto(dato);
            }
        } catch (IOException ex) {
            response = 10; //error of data format
        }
        
        ByteArrayOutputStream arrayOut = new ByteArrayOutputStream();
        DataOutputStream dataOut = new DataOutputStream(arrayOut);
        try {
            dataOut.writeInt(response);           
        } catch (IOException ex) {processError(ex);}
        ret = arrayOut.toByteArray();
        try {
            dataOut.close();
        } catch (IOException ex) {processError(ex);}
        return ret;
    }

    private boolean isFinishedSignal(byte[] sendingData) {
        return sendingData[0]==STOP;
    }
    
    private void processError(IOException ex) {
            Logger.getLogger(NumeroPerfectoServer.class.getName()).log(Level.SEVERE, null, ex);        
    }
}
