package model.data_structures;

import model.logic.Comparendo;

public class MaxHeapCP <T extends Comparable<T>> implements IMaxHeapCP <T>{

	private int tamano;
	
	private ArregloDinamico<Comparendo> datos = new ArregloDinamico(1000);
	@Override
	public int darnumeroElementos() {
		
		return tamano;
	}

	@Override
	public void agregarElemento(Comparable elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Comparable sacarMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparable darMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean esVacia() {
		return tamano == 0;
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
}
