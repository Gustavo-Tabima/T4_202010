package model.data_structures;

public interface IMaxHeapCP <T extends Comparable<T>>{

	
	
	public int darnumeroElementos();
	
	public void agregarElemento(T elemento);
	
	public T sacarMax() throws noExisteObjetoException;
	
	public T darMax() throws noExisteObjetoException;
	
	public boolean estaVacia();
}
