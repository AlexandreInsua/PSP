package cap02.Repasopdf;

public class JoinHilos implements Runnable {
    
    private TiradaDados contador;
 
    public JoinHilos(TiradaDados n) {
        contador = n;
    }
 
    public static String declaraGanador(TiradaDados i, TiradaDados j) {
        String aux;
        if(i.getSumaMarcador()>j.getSumaMarcador()){
        aux="El ganador es "+ i.getNombre();    
        }else {
        aux="El ganador es "+ j.getNombre();
        }
         
        return aux;
    }
     
    public void run() {
        try {
            Thread.sleep(1);
            int resultadoDado = (int) (Math.random() * 6) + 1;
            contador.setSumaMarcador(resultadoDado);
            System.out.println("Tirada del " + Thread.currentThread().getName()
                    + ":" + resultadoDado);
        } catch (InterruptedException e) {
        }
    }
 
    public static void main(String[] args) throws InterruptedException {
 
        TiradaDados resultadoManolo = new TiradaDados(0,"Manolo");
        TiradaDados resultadoPepe = new TiradaDados(0,"Pepe");
 
         
        //OBJETOS QUE SE PUEDEN CORRER
        JoinHilos tir1manolo = new JoinHilos(resultadoManolo);
        JoinHilos tir2manolo = new JoinHilos(resultadoManolo);
        JoinHilos tir3manolo = new JoinHilos(resultadoManolo);
         
        JoinHilos tir1pepe = new JoinHilos(resultadoPepe);
        JoinHilos tir2pepe = new JoinHilos(resultadoPepe);
        JoinHilos tir3pepe = new JoinHilos(resultadoPepe);
         
        //A LOS HILOS LE PASAMOS EL OBJETO QUE SE PUEDE EJECUTAR
        Thread hilo_1 = new Thread(tir1manolo);
        hilo_1.setName("Dado 1 MAN");
        Thread hilo_2 = new Thread(tir2manolo);
        hilo_2.setName("Dado 2 MAN");
        Thread hilo_3 = new Thread(tir3manolo);
        hilo_3.setName("Dado 3 MAN");
        Thread hilo_4 = new Thread(tir1pepe);
        hilo_4.setName("Dado 4 PEP");
        Thread hilo_5 = new Thread(tir2pepe);
        hilo_5.setName("Dado 5 PEP");
        Thread hilo_6 = new Thread(tir3pepe);
        hilo_6.setName("Dado 6 PEP");
         
        hilo_1.start();
        hilo_2.start();
        hilo_3.start();
        hilo_4.start();
        hilo_5.start();
        hilo_6.start();
         
        hilo_1.join(); 
        // Hace que el hilo_1 tenga que esparar hasta que
        // termine el hilo principal, que es el que lo ha
        // invocado, desde donde ha sido llamado
        hilo_2.join();
        hilo_3.join();
        hilo_4.join();
        hilo_5.join();
        hilo_6.join();
        //MOSTRAMOS LOS RESULTADOS DE AMBOS
        System.out.println("Resultado Manolo:" + resultadoManolo.getSumaMarcador());
        System.out.println("Resultado Pepe:" + resultadoPepe.getSumaMarcador());
        System.out.println(declaraGanador(resultadoManolo,resultadoPepe));
        System.out.println("Final Hilo Principal de Ejecucion");
    }
}