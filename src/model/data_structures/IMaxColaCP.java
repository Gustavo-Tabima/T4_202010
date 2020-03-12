package model.data_structures;

public interface IMaxColaCP  <T extends Comparable<T>>{


	public int darnumeroElementos();

	public void agregarElemento(T elemento);

	public T sacarMax() throws noExisteObjetoException;

	public T darMax() throws noExisteObjetoException;

	public boolean esVacia();


}
