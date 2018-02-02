package b02comunicacións01;

import java.net.*;

public class Principal {
	public static void main(String[] args) {
		//testInetAddress();

		visualizarPropiedadesURL();
	}

	// CLASE URL
	private static void visualizarPropiedadesURL() {
		URL url;
		
		try {
			System.err.println("Contrutor simple para unha URL: ");	url = new URL("http://docs.oracle.com/");
			visualizar(url);

			System.err.println("Outro contrutor");
			url = new URL("http", "docs.oracle.com", "/javase/7");
			visualizar(url);
			
			System.err.println("Contrutor para protocolo + url + porto + directorio");
			url = new URL("http", "docs.oracle.com", 80, "/javase/7");
			visualizar(url);
			
			System.err.println("Contrutor para un obxecto url e un directorio");
			URL urlbase = new URL("http://docs.oracle.com/");
			url = new URL(urlbase, "/javase/7/docs/api/java/net/URL.html");
			visualizar(url);
			
			
			url = new URL("https://docs.oracle.com/javase/9/whatsnew/JSNEW.pdf");
			
		} catch (MalformedURLException e) {
 
			e.printStackTrace();
		}

	}

	private static void visualizar(URL url) {
		
		System.out.println("Url completa: " + url.toString());
		System.out.println("Protocolo: "+ url.getProtocol());
		System.out.println("host: "+url.getHost());
		System.out.println("Porto: "+url.getPort());
		System.out.println("Ficheiro: "+url.getFile());
		System.out.println("Info Usuario: "+url.getUserInfo());
		System.out.println("Path: "+url.getPath());
		System.out.println("Dominio: "+url.getAuthority());
		System.out.println("Consulta: "+url.getQuery());
		System.out.println("==================");
	}

	// CLASE INETADDRESS
	private static void testInetAddress() {
		InetAddress dir = null;
		System.out.println("======================");
		System.out.println("SAIDA PARA LOCALHOST: ");

		try {
			// Localhost
			System.out.println("======================");
			System.out.println("SAIDA PARA LOCALHOST: ");
			dir = InetAddress.getByName("User-PC");
			probaMetodos(dir);

			System.out.println("======================");
			System.out.println("SAIDA PARA UNHA URL: ");
			dir = InetAddress.getByName("www.google.es");
			probaMetodos(dir);

			System.out.println("DIRECCIÓNS IP PARA: " + dir.getHostName());
			InetAddress[] direccions = InetAddress.getAllByName(dir.getHostName());

			for (int i = 0; i < direccions.length; i++) {
				System.out.println(direccions[i].toString());

			}
		} catch (UnknownHostException uhe) {
			uhe.printStackTrace();
		}

	}

	private static void probaMetodos(InetAddress dir) {
		System.out.println("Método getByName(): " + dir);
		InetAddress dir2;

		try {
			dir2 = InetAddress.getLocalHost();

		} catch (UnknownHostException uhe) {
			System.out.println(uhe);
		}

		// Usamos o método das clases
		System.out.println("Método getHostname(): " + dir.getHostName());
		System.out.println("Método getHostAddress(): " + dir.getHostAddress());
		System.out.println("Método toString(): " + dir.toString());
		System.out.println("Método getCannonicalHostName(): " + dir.getCanonicalHostName());
	}
}
