package model.data_structures;

import java.util.ArrayList;

import model.logic.*;

public class MaxColaCP <T extends Comparable<T>>implements IMaxColaCP{

	public int tamano;
	private Nodo<T> primero;
	private Nodo<T> ultimo;

	private ArrayList<T> ArregloMuestra = new ArrayList<>();
	//-----------------------------------
	//---------Metodos------------------
	//-----------------------------------
	/**
	 * 
	 * @param N Tamaño de Muestra decidido por usuario
	 * @param arregloEntrada arreglo de elementos
	 */


	public MaxColaCP() {

		tamano= 0;
		primero = null;
		ultimo = null;
	}

	@Override
	public int darnumeroElementos() {
		return tamano;
	}

	@Override
	public T darMax() throws noExisteObjetoException
	{
		if(tamano == 0)
		{
			throw new noExisteObjetoException();
		}
		Nodo<T> mayor = primero;
		Nodo<T> actual = primero;
		
		while(actual!=null)
		{
			if(actual.darDato().compareTo(mayor.darDato()) > 0 )
			{
				mayor = actual;
			}
			actual = actual.darSiguente();
		}


		return mayor.darDato();
	}

	@Override
	public T sacarMax() throws noExisteObjetoException
	{
		if(tamano == 0)
		{
			throw new noExisteObjetoException();
		}

		else {
			T x = primero.darDato();
			primero = primero.darSiguente();
			tamano--;

			return x;
		}


	}

	@Override
	public boolean esVacia() {
		// TODO Auto-generated method stub
		if (tamano == 0) {
			return true;
		}
		return false ;
	}




	@Override
	public void agregarElemento(Comparable elemento) {
		// TODO Auto-generated method stub
		Nodo<T> nuevo = new Nodo<T>((T) elemento);
		if(tamano == 0)
		{
			primero = nuevo;
			tamano++;
		}
		else
		{
			ultimo.setSiguiente(nuevo);
			ultimo = nuevo;
			tamano++;

		}





	}
}
