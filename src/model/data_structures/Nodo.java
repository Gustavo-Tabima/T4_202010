package model.data_structures;

public class Nodo <K>{

	Nodo<K> sig;
	
	private K datoActual;
	public Nodo(K dato){
		datoActual = dato;
		sig = null;
	}
	public K darDato() {
		return datoActual;
	}

	public Nodo darSiguente() {
		return sig;
	}
	
	
	public void setSiguiente(Nodo psiguiente) {
		
		sig=psiguiente;
		
	}

	
	
	public void setDato(K dato) 
	{
		datoActual = dato;
	}
	
	
	
	
}
