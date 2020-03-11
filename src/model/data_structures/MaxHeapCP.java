package model.data_structures;

import java.util.ArrayList;

import model.logic.Comparendo;

public class MaxHeapCP <T extends Comparable<T>> implements IMaxHeapCP <T>{

	private int tamano;

	private Nodo<T> inicio;
	
	private ArrayList<T> ArregloMuestra = new ArrayList<>();
	
	@Override
	public int darnumeroElementos() {
		
		return tamano;
	}

	@Override
	public void agregarElemento(T elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T sacarMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T darMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean esVacia() {
		boolean vacia = false;
		if (tamano==0) {
			vacia=true;
		}
		return vacia;
	}

	public  void sink(int e) {
		while (2*e <= N) 
		{      
			int j = 2*e; 
			if (j < N && menor(j, j+1)) 
				j++;
			if (!menor(k, j))
				break;
			cambiar(e, j);  
			e = j;  
		}
	}
	
	public void swim(int e) {
		
	
	while(e > 1 && menor(e/2, e) ) {
		cambiar(e/2,e);
		e = e/2;
	}

}
	
	public void cambiar() {
		
	}
	public void menor(int primero, int segundo) {
	}

	public Object buscar(String dato) {
		// TODO Auto-generated method stub
		return null;
	}

	public void eliminarHeap() {
		// TODO Auto-generated method stub
		
	}
}
