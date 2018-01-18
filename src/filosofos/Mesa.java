package filosofos;

public class Mesa {
	int numFilosofos;
	protected boolean[] comendo;

	public Mesa(int n) {
		numFilosofos = n;
		comendo = new boolean[n];
		for (int i = 0; i < n; i++) {
			comendo[i] = false;
		}

	}

	public int sig(int i) {
		return (i + 1) % numFilosofos;
	}

	public int ant(int i) {
		return (i - 1) % numFilosofos;
	}

	public String toString() {
		StringBuffer res = new StringBuffer();
		for (int i = 0; i < numFilosofos; i++) {
			if (res.length() == 0) {
				res.append('(');
			} else {
				res.append(',');
			}
		res.append(comendo[i]);}
		res.append(')');
		return res.toString();
	}

	public synchronized void pideTenedores(int id) throws InterruptedException {
		System.out.println(toString());
		while (comendo[ant(id)] || comendo[sig(id)]) {
			wait();
		}
		comendo[id] = true;
		System.out.println(toString());

	}

	public synchronized void cedeTenedores(int id) throws InterruptedException {
		System.out.println(toString());
		comendo[id] = false;
		notifyAll();
		System.out.println(toString());
	}

}
