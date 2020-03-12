package model.logic;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

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
	public static String PATH = "./data/comparendos_dei_2018_small.geojson";
//	public static String PATH = "./data/comparendos_dei_2018.geojson";
	
	//constructor de Max cola requiere un int y un array
	MaxColaCP<Comparendo > datosCola = new MaxColaCP<Comparendo>(0,cargarDatosCola());
	
	MaxHeapCP<Comparendo > datosHeap = new MaxHeapCP<Comparendo>();
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo(int N,String tipo)
	{	
	if(tipo.equals("cola")) {
	datosCola = new MaxColaCP<Comparendo>(N,cargarDatosCola());
	}
		
	
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


	
	public String eliminarHeap(String dato) {
		datosHeap.eliminarHeap();

		return dato;
	}
	
public ArrayList<Comparendo> cargarDatosCola() {
		
		//TODO Cambiar la clase del contenedor de datos por la Estructura de Datos propia adecuada para resolver el requerimiento 
		ArrayList<Comparendo> entrada = new ArrayList<Comparendo>();

		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(PATH));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();
			
			
			SimpleDateFormat parser=new SimpleDateFormat("yyyy/MM/dd");

			for(JsonElement e: e2) {
				int OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();
				
				String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();	
				Date FECHA_HORA = parser.parse(s); 
				
				String MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETE").getAsString();
				String CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHI").getAsString();
				String TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVI").getAsString();
				String INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				String DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRAC").getAsString();	
				String LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();

				double longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();
				
				double latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();

				Comparendo c = new Comparendo(OBJECTID, FECHA_HORA, DES_INFRAC, MEDIO_DETE, CLASE_VEHI, TIPO_SERVI, INFRACCION, LOCALIDAD, longitud, latitud);
				entrada.add(c);
				
			}

		} catch (FileNotFoundException | ParseException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
			
		return entrada;
	}
	


}
