
public class NodoLF<T> {

	private T info;
	private NodoLF<T> padre,figli;
	
	public NodoLF(T x){
		info = x;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public NodoLF<T> getPadre() {
		return padre;
	}

	public void setPadre(NodoLF<T> padre) {
		this.padre = padre;
	}

	public NodoLF<T> getFigli() {
		return figli;
	}

	public void setFigli(NodoLF<T> figli) {
		this.figli = figli;
	}
	
}
