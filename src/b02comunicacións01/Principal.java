package b02comunicacións01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class Principal {
	public static void main(String[] args) throws IOException {
		// testInetAddress();

		// visualizarPropiedadesURL();

		// propiedadesURL2();

		// Clase URLConnection
		// exemploURLConnection();

		// exemploURLConnection2();
		 exemploURLConnection3();


	}



	private static void exemplo04Sockets() {
		
		
	}



	private static void exemploURLConnection3() throws IOException {
		String cadena;
		URL url = new URL("http://localhost/php/verNome.html");
		URLConnection conexion = url.openConnection();
		System.out.println("Direccion [getURD()]:" + conexion.getURL());
		Date fecha = new Date(conexion.getLastModified());
		System.out.println("Fecha ultima modificacion [getLastModified()]: " + fecha);
		System.out.println("Tipo de Contenido [getContentType()]: " + conexion.getContentType());
		System.out.println("-------------------------------------");
		System.out.println("TODOS LOS CAMPOS DE CABECERA CON getHeaderFields(): ");
		// USAMOS UNA ESTRUCTURA Map PARA RECUPERAR CABECERAS
		Map camposcabecera = conexion.getHeaderFields();
		Iterator it = camposcabecera.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry map = (Map.Entry) it.next();
			System.out.println(map.getKey() + " : " + map.getValue());
			System.out.println("----------------------------");
			System.out.println("CAMPOS 1 Y 4 DE CABECERA:");
			System.out.println("getHeaderField(1)=> " + conexion.getHeaderField(1));
			System.out.println("getHeaderField(4)=> " + conexion.getHeaderField(4));
			System.out.println(" -------------------------------------------- ");
			System.out.println("CONTENIDO DE [url.getFile()]:" + url.getFile());
			BufferedReader pagina = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((cadena = pagina.readLine()) != null) {
				System.out.println(cadena);
			} //
		}

	}

	private static void exemploURLConnection2() {

		try {
			// crea un recurso
			URL url = new URL("http://localhost/php/verNome.php");
			// abre conexión
			URLConnection urlCon = url.openConnection();
			urlCon.setDoOutput(true);
			String cadea = "nome=Alexandre&apelidos=Insua Moreira";

			// ESCRIBIR NA URL
			PrintWriter output = new PrintWriter(urlCon.getOutputStream());

			output.write(cadea);
			output.close();

			BufferedReader br = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
			String linha;
			while ((linha = br.readLine()) != null) {
				System.out.println(linha);
			}
			br.close();
		} catch (MalformedURLException murle) {
			murle.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	private static void exemploURLConnection() {
		URL url = null;
		URLConnection urlCon = null;
		BufferedReader br = null;
		InputStream is = null;
		String inputLine = null;

		try {
			// crea un recurso
			url = new URL("http://www.elaltozano.es");
			// abre conexión
			urlCon = url.openConnection();

			is = urlCon.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));

			while ((inputLine = br.readLine()) != null) {
				System.out.println(inputLine);
			}
			br.close();
		} catch (MalformedURLException murle) {
			murle.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private static void propiedadesURL2() {
		// Conecta co site http://www.elatozano.es
		URL url = null;
		BufferedReader in;
		try {
			url = new URL("http://www.elaltozano.es");

			InputStream is = url.openStream();
			in = new BufferedReader(new InputStreamReader(is));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			}
			in.close();
		} catch (MalformedURLException murle) {
			murle.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	// CLASE URL
	private static void visualizarPropiedadesURL() {
		URL url;

		try {
			System.err.println("Contrutor simple para unha URL: ");
			url = new URL("http://docs.oracle.com/");
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
			visualizar(url);

		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

	}

	private static void visualizar(URL url) {

		System.out.println("Url completa: " + url.toString());
		System.out.println("Protocolo: " + url.getProtocol());
		System.out.println("host: " + url.getHost());
		System.out.println("Porto: " + url.getPort());
		System.out.println("Ficheiro: " + url.getFile());
		System.out.println("Info Usuario: " + url.getUserInfo());
		System.out.println("Path: " + url.getPath());
		System.out.println("Dominio: " + url.getAuthority());
		System.out.println("Consulta: " + url.getQuery());
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
