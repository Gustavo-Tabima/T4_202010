package model.logic;


import model.data_structures.MaxColaCP;
import model.data_structures.MaxHeapCP;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo<T> {
	/**
	 * Atributos del modelo del mundo
	 */
	
	//constructor de Max cola requiere un int y un array
	MaxColaCP<Comparendo > datosCola = new MaxColaCP<Comparendo>(0, null);
	
	MaxHeapCP<Comparendo > datosHeap = new MaxHeapCP<Comparendo>();
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
	
	}
	
	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Modelo(int capacidad)
	{
		
	}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamanoHeap()
	{
	return datosHeap.darnumeroElementos();
	}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	
	public int darTamanoCola(){
		return  datosCola.darnumeroElementos();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregarCola(T dato)
	{	
		datosCola.enqueue((Comparendo) dato);
	}
	
	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	
	public void agregarHeap(T dato)
	{	
		datosHeap.agregarElemento((Comparendo) dato);
	}
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public String buscarCola(String dato)
	{
		return  datosCola.buscar(dato).toString();
	}
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public String buscarHeap(String dato)
	{
		return  datosHeap.buscar(dato).toString();
	}

	public String eliminarCola(String dato) {
		datosCola.eliminarCola();
		return dato;
		// TODO Auto-generated method stub
		
	}
	
	public String eliminarHeap(String dato) {
		datosHeap.eliminarHeap();

		return dato;
	}
	
	
	


}
