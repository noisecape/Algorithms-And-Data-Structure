import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AlberoLF<T> {

	/*
	 * PARTECIPANTI
	 * 
	 * Nome:Tommaso 
	 * Cognome:Capecchi
	 * Matricola:5943118
	 * 
	 * Nome:Lorenzo
	 * Cognome:Mungai
	 * Matricola:5962693
	 * 
	 * Nome:Lorenzo
	 * Cognome:Tosi
	 * Matricola:6015493
	 * 
	 */
	NodoLF<T> radice;

	int numNodi;
	int altezza;
	int numFigliNodo;
	
	/*
	 * Nell'implementazione degli alberi generici vengono usate due LinkedList, una che contiene i padri
	 * dei vari nodi, l'altra che contiene tutti i nodi dell'albero.
	 */
	LinkedList<NodoLF<T>> padri, nodi;

	public AlberoLF() {
		altezza = 0;
		numNodi = 0;
		numFigliNodo = 0;
		radice = null;
		padri = new LinkedList<NodoLF<T>>();
		nodi = new LinkedList<NodoLF<T>>();
	}
	/*
	 * Restituisce il contenuto di un nodo. Il nodo viene specificato nell'input del metodo.
	 */
	public T getContent(NodoLF<T> u) {
		return u.getInfo();
	}

	public NodoLF<T> addRadice(T info) {
		if (radice != null)
			return null;
		else
			radice = new NodoLF(info);
		getPadri().add(null);
		getFigli().add(radice);
		numNodi++;
		return radice;
	}
	/*
	  Restituisce il numero dei nodi presenti nell'albero; il contatore viene aggiornato
	  ogni volta che avviene un inserimento.
	  
	 */
	public int getNumNodi() {
		return numNodi;
	}
	/*
	 * Metodo usato per fare gli inserimenti. Negli input viene specificato il padre
	 * del nuovo nodo e il valore che gli verra assegnato.
	 */
	public NodoLF<T> addFigli(T info, NodoLF<T> padre) {
		NodoLF<T> temp = new NodoLF(info);
		temp.setPadre(padre);
		padre.setFigli(temp);
		getPadri().add(padre);
		getFigli().add(temp);
		numNodi++;
		return temp;
	}
	/*
	 * Cambia il contenuto di un nodo. Il nodo viene specificato nell'input del metodo.
	 */
	public void changeContent(NodoLF<T> u, T newInfo) {
		NodoLF<T> newPadre = u.getPadre();
		NodoLF<T> newFigli = u.getFigli();
		u = new NodoLF(newInfo);
		u.setFigli(newFigli);
		u.setPadre(newPadre);
		System.out.println("New content of " + u + " is "+ newInfo);
	}

	/*
	 * Creo un nuovo albero e inserisco la radice.
	 */
	public AlberoLF<T> nuovoAlbero(T newRadice) {
		AlberoLF<T> newAlbero = new AlberoLF();
		newAlbero.addRadice(newRadice);
		return newAlbero;
	}
	/*
	 * Restituisce le informazioni dei vari figli di un nodo. Il nodo viene specificato nell'input del metodo.
	 */
	public LinkedList<T> infoNodo(NodoLF<T> u) {
		LinkedList<T> informations = new LinkedList<T>();
		for (int i = 1; i < nodi.size(); i++) {
			if (nodi.get(i).getPadre().equals(u)) {
				informations.add(nodi.get(i).getInfo());
			}
		}
		return informations;
	}

	/*
	 * Inserisco una nuova radice nell'albero gia esistente. Il valore della nuova radice viene
	 * specificato negli input del metodo
	 */
	public NodoLF<T> insertNewRadice(AlberoLF<T> a, T x) {
		NodoLF<T> newRoot = new NodoLF<T>(x);
		newRoot.setFigli(radice);
		radice.setPadre(newRoot);
		return newRoot;
	}
	/*
	 * Restituisce il padre di un nodo. Il nodo viene specificato nell'input del metodo.
	 */
	public NodoLF<T> getPadre(NodoLF<T> u){
		return u.getPadre();
	}

	/*
	 * Visita in profondita dell'albero: viene utilizzata una pila e fino a che la pila non è vuota
	 * si aggiungono in una lista i nodi visitati. La ricerca dei figli di un nodo avviene tramite
	 * un ciclo for il quale va a confrontare il padre di ogni nodo dell'albero con il nodo preso in considerazione
	 * (il nodo u); se il padre del nodo nella posizione i-esima è uguale al nodo u, allora
	 * il nodo nella i-esima posizione viene inserito nella pila e nel ciclo successivo aggiunto alla
	 * lista delle visite.
	 */
	public LinkedList<NodoLF<T>> visitaDFS() {
		Stack<NodoLF<T>> stack = new Stack<NodoLF<T>>();
		LinkedList<NodoLF<T>> nodiAlbero = new LinkedList<NodoLF<T>>();
		stack.push(radice);
		while (!stack.isEmpty()) {
			NodoLF<T> u = stack.pop();
			if (u != null) {
				nodiAlbero.add(u);
				for (int i = nodi.size() - 1; i > 0; i--) {
					if (nodi.get(i).getPadre().equals(u)) {
						stack.push(nodi.get(i));
					}
				}
			}
		}
		return nodiAlbero;
	}
	/*
	 * Restituisce il numero dei figli di un nodo. Il nodo viene specificato nell'input del metodo.
	 */
	public int numFigli(NodoLF<T> u) {
		for (int i = nodi.size() - 1; i > 0; i--) {
			if (nodi.get(i).getPadre().equals(u) == true) {
				numFigliNodo++;
			}
		}
		return numFigliNodo;
	}
	/*
	 * Restituisce la radice dell'albero.
	 */
	public NodoLF<T> getRadice() {
		return radice;
	}

	public LinkedList<NodoLF<T>> getPadri() {
		return padri;
	}

	public void setPadri(LinkedList<NodoLF<T>> padri) {
		this.padri = padri;
	}

	public LinkedList<NodoLF<T>> getFigli() {
		return nodi;
	}

	public void setFigli(LinkedList<NodoLF<T>> figli) {
		this.nodi = figli;
	}

	/*
	 * Visita in ampiezza dell'albero: viene utilizzata una coda e vi si aggiungono elementi
	 * fino a che la coda non è vuota. Come nella visita in profondita viene usato un ciclo
	 * for per scandire tutti i nodi della'albero tranne la radice(il ciclo infatti parte dalla 
	 * posizione 1). Se il padre del nodo in posizione i-esima è uguale a al nodo u, allora il nodo 
	 * viene inserito sia nella coda che nella lista che tiene di conto di tutte le informazioni
	 * dei vari nodi.
	 */
	public LinkedList<NodoLF<T>> visitaBFS() {
		LinkedList<NodoLF<T>> nodiAlbero = new LinkedList<NodoLF<T>>();
		NodoLF<T> u = new NodoLF<T>(radice.getInfo());
		nodiAlbero.add(u);
		Queue<T> f = new LinkedList<T>();
		f.add(u.getInfo());
		while(!f.isEmpty()){
			u.setInfo(f.remove());
			for(int i = 1;i<nodi.size();i++){
				if(nodi.get(i).getPadre().getInfo().equals(u.getInfo())){
					f.add(nodi.get(i).getInfo());
					nodiAlbero.add(nodi.get(i));
				}
			}
		}
		return nodiAlbero;
	}
	/*
	 * L'altezza dell'albero viene calcolata facendo un "backtrack" del nodo piu in profondita dell'albero.
	 * Tale nodo risulta essere sempre l'ultimo elemento della visita BFS. Un ciclo while controlla che il padre
	 * del nodo preso in esame (il nodo v) non sia null, ovvero la radice; se non lo è, risale l'albero aumentando
	 * di uno ad ogni ciclo l'altezza. Alla fine viene restituita l'altezza +1 in quanto si considerano anche
	 * le foglie dell'albero.
	 */
	public int computeHeigth() {
		LinkedList<NodoLF<T>> visitaBFS = visitaBFS();
		NodoLF<T> v = visitaBFS.getLast();
		while(v.getPadre() != null){
			v = v.getPadre();
			altezza++;
		}
		return altezza+1;
	}
}
