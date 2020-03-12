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
		inicio = new Nodo<T>(arregloEntrada.get(0));
		int contador = 0;
		while(contador<N){
			int random = (int) Math.random()*100;
			
			if(ArregloMuestra.get(random) != null && random < arregloEntrada.size()) {
				ArregloMuestra.add(arregloEntrada.get(random));
			}
		contador++;
		}
		for (int i = 0; i < ArregloMuestra.size(); i++) {
			T primerObjeto = ArregloMuestra.get(i);
			for(int j = i +1; j< ArregloMuestra.size();j++) {
				T segundoObjeto = ArregloMuestra.get(j);
				
				if(primerObjeto.compareTo(segundoObjeto) == 1) {
					queue(primerObjeto);
				}
			
			}
		}
		sacarTodo();
	}
	

	public int darnumeroElementos() {
		
		return tamano;
	}



	@Override
	public Comparable<T> sacarMax() {
		
	return inicio.darDato();
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

	public void queue(T dato) {
		Nodo nuevoNodo=new Nodo(dato);
		nuevoNodo.setSiguiente(null);
		if(inicio==null )
		{
			inicio=nuevoNodo;
			
			tamano++;
			
		}else
		{
		Nodo iterador = inicio;
		while(iterador!=null){
		if(iterador.darSiguente() == null){
			iterador.setSiguiente(nuevoNodo);
		}
			iterador= iterador.darSiguente();
	}
		}
	}
	
	public void dequeue(T dato) {
		
	}



	public Object buscar(String dato) {
		// TODO Auto-generated method stub
		return null;
	}




public void sacarTodo()	{
	Nodo<T> iterador = inicio; 
	while(iterador!= null) {
		System.out.println(iterador.darDato().toString());
		iterador = iterador.darSiguente();
	}
}

}
