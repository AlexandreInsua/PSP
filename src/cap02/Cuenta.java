package cap02;

public class Cuenta {
	private float saldo;
	private float saldoMaximo;

	public Cuenta() {
		super();
	}

	public Cuenta(float saldo, float saldoMaximo) {
		super();
		this.saldo = saldo;
		this.saldoMaximo = saldoMaximo;
	}

	// obter o saldo
	public float getSaldo() {
		return saldo;
	}

	public float getSaldoMaximo() {
		return saldoMaximo;
	}

	public void setSaldo(float c) {
		this.saldo = c;
		//System.out.println("Saldo actual " + saldo + "€");
	}

	public void setSaldoMaximo(float c) {
		this.saldoMaximo = c;
		System.out.println("Saldo máximo actual " + saldoMaximo + "€");
	}

	// reintegro
	public synchronized void reintegro(int cantidad, String nombre) {
		if (cantidad >= this.saldo) {
			setSaldo(0);
			System.out.println("Saldo 0");

		} else {
			this.saldo -= cantidad;
		}
		System.out.println(nombre + " retira " + cantidad + "€. Saldo actual: " + saldo +"€");
	}

	// integro
	public synchronized void ingreso(int cantidad, String nombre) {
		if (this.saldo + cantidad >= this.saldoMaximo) {
			setSaldo(saldoMaximo);
			System.out.println("Saldo máximo alcanzado");
		} else {
			this.saldo += cantidad;
			System.out.println("Saldo actual " + this.saldo);
		}
		System.out.println(nombre + " ingresa " + cantidad + "€. Saldo actual: " + saldo+"€");
	}

	// para despois
	public boolean ingresoPermitido(int cantidad) {
		float valor = saldo + cantidad;
		if (valor <= saldoMaximo) {
			return true;
		}else {
			return false;
		}
	}

	public boolean reintegroPermitido(int cantidad) {
		float valor = saldo + cantidad;
		if (valor <= saldo) {
			return true;
		}else {
			return false;
		}
	}
}
