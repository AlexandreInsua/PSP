package cap02.Repasopdf;

class TiradaDados {
   private int marcador;
   String nombre;
   public TiradaDados(int i,String n) {
       marcador = i;
       nombre=n;
   }

   public String getNombre() {
       return nombre;
   }
   public synchronized int getSumaMarcador() {
       return marcador;
   }

   public synchronized void setSumaMarcador(int i) {
       marcador += i;
   }
}
