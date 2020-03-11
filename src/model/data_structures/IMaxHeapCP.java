package model.data_structures;

public interface IMaxHeapCP <T extends Comparable<T>>{

	
	
	public int darnumeroElementos();
	
	public void agregarElemento(T elemento);
	
	public T sacarMax();
	
	public T darMax();
	
	public boolean esVacia();
}
