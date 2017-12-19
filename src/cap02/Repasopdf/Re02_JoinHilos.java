package cap02.Repasopdf;

/* 
 * Esta clase implementa as tiradas de dados comod fíos
 */
public class Re02_JoinHilos implements Runnable {

	private Re02_TiradaDados_multiple contador;

	public Re02_JoinHilos(Re02_TiradaDados_multiple n) {
		contador = n;
	}

	public static void declaraGanador(Re02_TiradaDados_multiple i, Re02_TiradaDados_multiple j) {
		
		if (i.getSumaMarcador() > j.getSumaMarcador()) {
			i.ganhou(); // aux="O gañador é "+ i.getNombre();
		} else {
			j.ganhou(); // aux="O gañador é "+ j.getNombre();
		}
	}

	public void run() {
		try {
			Thread.sleep(1);
			int resultadoDado = (int) (Math.random() * 6) + 1;
			contador.setSumaMarcador(resultadoDado); // s = s + r
			System.out.println("Tirada do " + Thread.currentThread().getName() + ":" + resultadoDado);
		} catch (InterruptedException e) {
		}
	}

	public static void xogar(Re02_TiradaDados_multiple i, Re02_TiradaDados_multiple j) {

		// Instancias do fios
		// (instacia de Runnable: Thread thread = new Thread(obxecto);
		// obxectos que se poden executar

		Re02_JoinHilos tir1manolo = new Re02_JoinHilos(i);
		Re02_JoinHilos tir2manolo = new Re02_JoinHilos(i);
		Re02_JoinHilos tir3manolo = new Re02_JoinHilos(i);

		Re02_JoinHilos tir1pepe = new Re02_JoinHilos(j);
		Re02_JoinHilos tir2pepe = new Re02_JoinHilos(j);
		Re02_JoinHilos tir3pepe = new Re02_JoinHilos(j);

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

		// Fai que o Main agarde ata que cada fío remate a súa execución.

		try {
			fio1.join();
			fio2.join();
			fio3.join();
			fio4.join();
			fio5.join();
			fio6.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// mostramos os resultados de ambos
		System.out.println("Resultado Manolo:" + i.getSumaMarcador());
		System.out.println("Resultado Pepe:" + j.getSumaMarcador());
	}

	// implementa un main diferente
	public static void main(String[] args) {
		Re02_TiradaDados_multiple resultadoManolo = new Re02_TiradaDados_multiple(0, "Manolo");
		Re02_TiradaDados_multiple resultadoPepe = new Re02_TiradaDados_multiple(0, "Pepe");

		// xogan 10 partidas
		for (int k = 0; k < 11; k++) {
			xogar(resultadoManolo, resultadoPepe);
			declaraGanador(resultadoManolo, resultadoPepe);
		}

		if (resultadoManolo.getVitorias() > resultadoPepe.getVitorias()) {
			System.out.println("Gaña Manolo: " + resultadoManolo.getVitorias());
		} else {
			System.out.println("Gaña Pepe" + resultadoPepe.getVitorias());
		}
		System.out.println("Final do fio principal de execucion");
	}
}