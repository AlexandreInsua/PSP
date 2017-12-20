package cap02.Repasopdf;

import java.util.ArrayList;

public class MonitorProductorConsumer {
	
	private ArrayList<Integer> cola = new ArrayList<>();
	
	
	

	public static void main(String[] args) {
		ArrayList<Integer> numeros = new ArrayList<Integer>();

		numeros.add(1);
		numeros.add(2);
		numeros.add(3);
		numeros.add(4);
		numeros.add(5);
		
		imprimirArray(numeros);
		
		numeros.remove(0);
		numeros.add(6);
		
		imprimirArray(numeros);
		
		numeros.remove(0);
		numeros.add(7);
		
		imprimirArray(numeros);
		numeros.remove(0);
		numeros.add(8);
		
		imprimirArray(numeros);
		numeros.remove(0);
		numeros.add(9);
		
		imprimirArray(numeros);
		
		
		
	}

	private static void imprimirArray(ArrayList<Integer> numeros) {
		numeros.forEach((c)->{
			System.out.print(c +" ");
		});
		System.out.println();
	}
}
