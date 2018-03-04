package utilidades;

public class Palindromo {

	public static void main(String[] args) {
		
		System.out.println(espalindromo("A torre da derrota"));
		System.out.println(espalindromo("Esta non o é"));
	}
	
	
	static public boolean espalindromo(String cadena) {
		cadena = cadena.toLowerCase();
		boolean valor = true;
		int i,j, k;
		String cadena2 = "";
		
		// quitamos los espacios
		for (i = 0; i < cadena.length(); i++) {
			if (cadena.charAt(i) != ' ')
				cadena2 += cadena.charAt(i);
		}
		
		// volvemos a asignar variables
		
		cadena = cadena2;
		k = cadena.length();
		// comparamos cadenas
		for (j = 0; j < (cadena.length()); j++) {
			if (cadena.substring(j, j + 1).equals(cadena.substring(k - 1, k)) == false) {
				// si una sola letra no corresponde no es un palindromo por
				// tanto
				// sale del ciclo con valor false
				valor = false;
				break;
			}
			k--;
		}
		return valor;
	}
}