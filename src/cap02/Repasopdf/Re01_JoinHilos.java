package cap02.Repasopdf;

/* 
 * Esta clase implementa as tiradas de dados comod fíos
 */
public class Re01_JoinHilos implements Runnable {
    
    private Re01_TiradaDados contador;
 
    public Re01_JoinHilos(Re01_TiradaDados n) {
        contador = n;
    }
 
    public static String declaraGanador(Re01_TiradaDados i, Re01_TiradaDados j) {
        String aux;
        if(i.getSumaMarcador()>j.getSumaMarcador()){
        aux="O gañador é "+ i.getNombre();    
        }else {
        aux="O gañador é "+ j.getNombre();
        }
         
        return aux;
    }
     
    public void run() {
        try {
            Thread.sleep(1);
            int resultadoDado = (int) (Math.random() * 6) + 1;
            contador.setSumaMarcador(resultadoDado); // s = s + r
            System.out.println("Tirada do " + Thread.currentThread().getName()
                    + ":" + resultadoDado);
        } catch (InterruptedException e) {
        }
    }
 
    public static void main(String[] args) throws InterruptedException {
 
        Re01_TiradaDados resultadoManolo = new Re01_TiradaDados(0,"Manolo");
        Re01_TiradaDados resultadoPepe = new Re01_TiradaDados(0,"Pepe");
 
        // Instancias do fios 
        // (instacia de Runnable: Thread thread  = new Thread(obxecto);
        // obxectos que se poden executar

        Re01_JoinHilos tir1manolo = new Re01_JoinHilos(resultadoManolo);
        Re01_JoinHilos tir2manolo = new Re01_JoinHilos(resultadoManolo);
        Re01_JoinHilos tir3manolo = new Re01_JoinHilos(resultadoManolo);
         
        Re01_JoinHilos tir1pepe = new Re01_JoinHilos(resultadoPepe);
        Re01_JoinHilos tir2pepe = new Re01_JoinHilos(resultadoPepe);
        Re01_JoinHilos tir3pepe = new Re01_JoinHilos(resultadoPepe);
         
        // Aos fíos pasámoslle o obxecto que se pode executar 
        Thread fio1 = new Thread(tir1manolo);
        fio1.setName("Dado 1 MAN");
        Thread fio2 = new Thread(tir2manolo);
        fio2.setName("Dado 2 MAN");
        Thread fio3 = new Thread(tir3manolo);
        fio3.setName("Dado 3 MAN");
        Thread fio4 = new Thread(tir1pepe);
        fio4.setName("Dado 4 PEP");
        Thread fio5 = new Thread(tir2pepe);
        fio5.setName("Dado 5 PEP");
        Thread fio6 = new Thread(tir3pepe);
        fio6.setName("Dado 6 PEP");
         
        fio1.start();
        fio2.start();
        fio3.start();
        fio4.start();
        fio5.start();
        fio6.start();

        // Fai que o Main agarde ata que cada fío  remate a súa execución. 
        
        fio1.join(); 
        fio2.join();
        fio3.join();
        fio4.join();
        fio5.join();
        fio6.join();
        //MOSTRAMOS LOS RESULTADOS DE AMBOS
        System.out.println("Resultado Manolo:" + resultadoManolo.getSumaMarcador());
        System.out.println("Resultado Pepe:" + resultadoPepe.getSumaMarcador());
        System.out.println(declaraGanador(resultadoManolo,resultadoPepe));
        System.out.println("Final fío principal de execución");
    }
}