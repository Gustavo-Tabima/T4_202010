package model.data_structures;

import java.util.ArrayList;

import model.logic.*;

public class MaxColaCP <T extends Comparable<T>>implements IMaxColaCP{

	public int tamano;

	public ArregloDinamico<T> datos;

	//-----------------------------------
	//---------Metodos------------------
	//-----------------------------------
	
	public MaxColaCP() {
		datos = new ArregloDinamico<T>(100000);
	}
	
	ArrayList<T> elementosSinCola = new ArrayList<T>();
	public int darnumeroElementos() {
		// TODO Auto-generated method stub
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

	public void enqueue(T elemento) {

	}
	
	public void dequeue() {
		
	}
	
	

}
