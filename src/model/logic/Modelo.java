package model.logic;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.data_structures.MaxColaCP;
import model.data_structures.MaxHeapCP;
import model.data_structures.noExisteObjetoException;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo<T> {
	/**
	 * Atributos del modelo del mundo
	 */

	private MaxColaCP<Comparendo> datosCola ;

	private MaxHeapCP<Comparendo> datosHeap ;
	private MaxColaCP<Comparendo> datosCP;

	public static String PATH = "./data/Comparendos_DEI_2018_Bogotá_D.C.geojson";

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{//la cola es rara :v
		datosCola = new MaxColaCP();
		datosHeap = new MaxHeapCP();
	}

	public MaxHeapCP darDatosHeap()
	{
		return datosHeap;
	}

	public MaxColaCP darDatosCola()
	{
		return datosCola;
	}





	public ArrayList<Comparendo> cargarDatos() {

		ArrayList<Comparendo> datos = new ArrayList<Comparendo>();

		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(PATH));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();

			SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

			for (JsonElement e : e2) {
				int OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();

				String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();
				Date FECHA_HORA = parser.parse(s);

				String MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETECCION").getAsString();
				String CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHICULO").getAsString();
				String TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVICIO").getAsString();
				String INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				String DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRACCION").getAsString();
				String LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();
				String MUNICIPIO = e.getAsJsonObject().get("properties").getAsJsonObject().get("MUNICIPIO").getAsString();

				double longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();

				double latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();

				Comparendo c = new Comparendo(OBJECTID, FECHA_HORA, DES_INFRAC, MEDIO_DETE, CLASE_VEHI, TIPO_SERVI, INFRACCION, LOCALIDAD, MUNICIPIO, longitud, latitud);
				datos.add(c);

			}

		} catch (FileNotFoundException | ParseException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		Collections.shuffle(datos);
		return datos;
	}


	public long cargarDatosCola(int tamanoP) {
		long inicio = 0, fin = -1;
		ArrayList<Comparendo> bruh ;
		bruh = (ArrayList) cargarDatos();
		inicio = System.currentTimeMillis();
		for(int i = 0; i < tamanoP; i++)
		{
			datosCola.agregarElemento(bruh.get(i));

		}

		fin = System.currentTimeMillis();


		return fin - inicio;
	}


	public long cargarDatosHeap(int tamanoP) {

		long inicio = 0, fin = -1;
		ArrayList<Comparendo> bruh ;
		bruh = (ArrayList) cargarDatos();
		inicio = System.currentTimeMillis();
		for(int i = 0; i < tamanoP; i++)
		{
			datosHeap.agregarElemento(bruh.get(i));

		}

		fin = System.currentTimeMillis();


		return fin - inicio;
	}

	public String ResultadoCargaFinal(int tamanoP) 
	{


		return "El total de comparendos es: " + datosCola.darnumeroElementos() +"/ln"+ 
				"El tiempo que demora en cargar la cola es: " + cargarDatosCola(tamanoP) + "/ln"+
				"El tiempo en cargar los datos en el heap es de: " +  cargarDatosHeap(tamanoP) ;
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
		datosCola.agregarElemento((Comparendo) dato);
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */

	public void agregarHeap(T dato)
	{	
		datosHeap.agregarElemento((Comparendo) dato);
	}

	public String NComparendoConMayorLatitudNorte(int Num,String[] lista) throws noExisteObjetoException{

		MaxColaCP<Comparendo> respuesta = new MaxColaCP<>();

		boolean acabo = false;

		for (int i = 0; i < datosCola.darnumeroElementos()-1 && acabo!=true; i++) {

			Comparendo actual = datosCola.sacarMax();
			boolean pertenece=false;
			for (String x: lista) {
				if (x.equalsIgnoreCase(actual.darClaseVehi())){
					if (pertenece) {
						respuesta.agregarElemento(actual);
					}
					if (respuesta.darnumeroElementos()==Num) {
						acabo=true;
					}
				}

			}
			







		}

		return respuesta.toString();


	}





}
