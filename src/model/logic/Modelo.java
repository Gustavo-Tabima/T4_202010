package model.logic;


import model.data_structures.MaxColaCP;
import model.data_structures.MaxHeapCP;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	MaxColaCP<Comparendo > datosCola = new MaxColaCP<Comparendo>();
	
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
	
	public int darTamañoCola(){
		return  datosCola.darnumeroElementos();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregarCola(Comparendo dato)
	{	
		datosCola.enqueue(dato);
	}
	
	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	
	public void agregarHeap(Comparendo dato)
	{	
		datosHeap.agregarElemento(dato);
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
	public String buscarCola(String dato)
	{
		return  datosHeap.buscar(dato).toString();
	}
	
	
	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public String eliminar(String dato)
	{
		return datos.eliminar(dato).toString();
	}


}
