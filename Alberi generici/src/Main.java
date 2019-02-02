import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {

		Main m = new Main();
		m.run();
	}

	public void run() {
		AlberoLF<Integer> albero = new AlberoLF();
		NodoLF<Integer> radice = albero.addRadice(12);
		NodoLF<Integer> figlio1 = albero.addFigli(23, radice);
		NodoLF<Integer> figlio2 = albero.addFigli(31, radice);
		NodoLF<Integer> figlio3 = albero.addFigli(546, figlio1);
		NodoLF<Integer> figlio4 = albero.addFigli(321, figlio1);
		NodoLF<Integer> figlio5 = albero.addFigli(123, radice);
		NodoLF<Integer> figlio6 = albero.addFigli(94, figlio2);
		LinkedList<NodoLF<Integer>> visitaBFS = albero.visitaBFS();
		System.out.println(albero.visitaBFS().getLast().getInfo());
	}
}
