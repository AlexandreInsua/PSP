package exanteriorTiradaCartas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase representa la sencilla interfaz de una consola del sistema
 * operativo. Es capaz de leer de teclado y mostrar mensajes y errores por la
 * pantalla.
 */

public class ConsoleInterface {
	public static final int DO_NOT_CHANGE = 0;
	public static final int TO_UPPPER_CASE = 2;
	public static final int TO_LOWER_CASE = 1;
	BufferedReader reader = null;
	
	/**
	 * Constructor por defecto. Los objetos as� instanciados leeran los datos
	 * del teclado y escribiran los mensajes en la pantalla
	 */
	public ConsoleInterface() {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * Constructor que permite introducir una secuencia de caracteres simulando
	 * la pulsaci�n de teclas. La secuencia de texto puede ser tan larga como
	 * sea necesario e incorporar tantas lecturas separadas per retornos de
	 * l�nea como quiera.
	 * 
	 * @param scannerText
	 *            cadena de caracteres con pulsaci�n de teclas predefinida.
	 */
	public ConsoleInterface(String scannerText) {
		reader = new BufferedReader(new StringReader(scannerText));
	}

	public String readLine() {
		String ret;
		try {
			ret = reader.readLine();
		} catch (IOException ex) {
			throw processError(ex);
		}
		return ret;
	}

	/**
	 * Mostrara por pantalla el mensaje recibido per parametro y esperar� la
	 * introducci�n de un valor num�rico desde teclado. Si el usuario introduce
	 * valores no numericos, mostrara un mensaje de error y requerira una nueva
	 * introducci�n.
	 * 
	 * @param message
	 *            Mensaje a mostrar por pantalla antes de demandar el valor
	 *            numerico.
	 * @return el valor numerico introducido desde teclado.
	 */
	public int readInt(String message) {
		String line;
		int ret;
		boolean correct = false;
		do {
			System.out.print(message);
			try {
				line = reader.readLine();
			} catch (IOException ex) {
				throw processError(ex);
			}
			correct = line.matches("[0-9]*");
			if (!correct) {
				System.out.println("Puede introducir un entero por favor.");
			}
		} while (!correct);
		ret = Integer.parseInt(line);
		return ret;
	}

	/**
	 * Mostrara por pantalla el mensaje rcibido comoa primer parametro y
	 * esperara la introducci�n de un caracter desde teclado. Si el usuario
	 * introduce un caracter igual al segundo parametro, retornara cierto. En
	 * caso contrario devolvera falso. El tercer parametro permite indicar si se
	 * desea hacer un cambio a mayusculas o min�sculas de la tecla pulsada por
	 * el usuario. El valor TO_UPPER_CASE (2) cambiara siempre el valor
	 * introducido a may�sculas antes de hacer la comparaci�n. El valor
	 * TO_LOWER_CASE (1) pasara el valor a min�sculas y cualquier otro valor no
	 * realizara ningun cambio.
	 * 
	 * @param message
	 *            Mensaje a mostrar por pantalla antes de pedir el valor a
	 *            introducir desde teclado.
	 * @param yesChar.
	 *            Es un caracter equivalente al valor afirmativo o cierto para
	 *            poder comparar con el valor introducido por el usuario.
	 * @param changeCase.
	 *            es un valor numerico que indica si quiere cambiar el valor del
	 *            usuario a may�sculas o min�sculas.
	 * @return el valor numerico introducido desde teclado.
	 */
	public boolean readYesNo(String missatge, char yesChar, int changeCase) {
		boolean correct = false;
		String line;
		char ret;
		do {
			System.out.print(missatge);
			try {
				line = reader.readLine();
			} catch (IOException ex) {
				throw processError(ex);
			}
			correct = line.length() > 0;
			if (!correct) {
				System.out.println("Puede escribir un caracter y pulsar " + "'Entrar'");
			}
		} while (!correct);

		if (changeCase == TO_UPPPER_CASE) {
			ret = line.toUpperCase().charAt(0);
		} else if (changeCase == TO_LOWER_CASE) {
			ret = line.toLowerCase().charAt(0);
		} else {
			ret = line.charAt(0);
		}
		return ret == yesChar;
	}

	/**
	 * Muestra por pantalla, el mensaje de error de la excepci�n recibida por
	 * parametro.
	 * 
	 * @param ex.
	 *            Es la excepci�n para la que se ha de mostrar el mensaje de
	 *            error.
	 */
	public void showError(Exception ex) {
		System.out.println("Error: " + ex.getLocalizedMessage());
		Logger.getLogger(ConsoleInterface.class.getName()).log(Level.SEVERE, null, ex);
	}

	/**
	 * Muestra el mensaje llegado por parametro
	 * 
	 * @param message.
	 *            Mensaje de error a mostrar
	 * @param ex.
	 *            excepci�n lanzada para la que se ha producido el error.
	 */
	public void showError(String message, Exception ex) {
		System.out.println("Error: " + message);
		Logger.getLogger(ConsoleInterface.class.getName()).log(Level.SEVERE, message, ex);
	}

	/**
	 * Muestra el mensaje llegado por parametro
	 * 
	 * @param message.
	 *            Mensaje de error a mostrar
	 */
	public void showError(String message) {
		System.out.println("Error: " + message);
	}

	/**
	 * Muestra el mensaje llegado por parametro
	 * 
	 * @param message.
	 *            Mensaje de error a mostrar
	 */
	public void showMessage(String message) {
		System.out.println(message);
	}

	/**
	 * Devuelve cierto si hay un caracter disponible en el buffer del teclado.
	 * Este metodo no es bloqueante, por lo que puede ser muy �til para sistemas
	 * que no se puedan bloquear esperando la respuesta del usuario.
	 * 
	 * @return
	 */
	public boolean isKeyReady() {
		boolean ret = false;
		try {
			ret = reader.ready();
		} catch (IOException ex) {
			throw processError(ex);
		}
		return ret;

	}

	/**
	 * Lee un caracter del teclado cuando este disponible y lo devuelve.
	 * 
	 * @return la tecla pulsada justo despues de la ultima lectura.
	 */
	public char read() {
		char character = 0;
		try {
			character = (char) reader.read();
		} catch (IOException ex) {
			throw processError(ex);
		}
		return character;
	}

	private NoSuchElementException processError(Exception ex) {
		NoSuchElementException except = new NoSuchElementException(ex.getMessage());
		except.initCause(ex);
		return except;
	}
}