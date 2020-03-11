package model.data_structures;

import java.util.ArrayList;

import model.logic.*;

public class MaxColaCP <T extends Comparable<T>>implements IMaxColaCP{

	public int tamano;

	private Nodo<T> inicio;
	
	private ArrayList<T> ArregloMuestra = new ArrayList<>();
	//-----------------------------------
	//---------Metodos------------------
	//-----------------------------------
	/**
	 * 
	 * @param N Tamaño de Muestra decidido por usuario
	 * @param arregloEntrada arreglo de elementos
	 */
	
	
	public MaxColaCP(int N, ArrayList<T> arregloEntrada) {
		
		int contador = 0;
		while(contador<N){
			int random = (int) Math.random()*10;
			ArregloMuestra.add(arregloEntrada.get(random));
		contador++;
		}
	}
	
	ArrayList<T> elementosSinCola = new ArrayList<T>();
	public int darnumeroElementos() {
		
		return tamano;
	}



	@Override
	public Comparable<T> sacarMax() {
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparable<T> darMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean esVacia() {
		boolean r = false;
		if(tamano == 0){
			r = true;
		}
		return r;
	}

	@Override
	public void agregarElemento(Comparable elemento) {
		// TODO Auto-generated method stub
		
	}

	public void enqueue(T dato) {
		Nodo nuevoNodo=new Nodo(dato);
		nuevoNodo.setSiguiente(null);
		if(inicio==null )
		{
			inicio=nuevoNodo;
			
			tamano++;

		}
		Nodo iterador = inicio;
		while(iterador!=null){
		if(iterador.darSiguente() == null){
			iterador.setSiguiente(nuevoNodo);
		}
			iterador= iterador.darSiguente();
	}
	}
	
	public void dequeue() {
		
	}



	public Object buscar(String dato) {
		// TODO Auto-generated method stub
		return null;
	}



	public void eliminarCola() {
		// TODO Auto-generated method stub
		
	}
	
	

}
