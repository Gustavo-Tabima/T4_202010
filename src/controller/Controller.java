package controller;

import java.util.Scanner;

import model.data_structures.noExisteObjetoException;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run()
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){


			case 1: 
				view.printMessage("Ingrese la cantidad de datos a cargar en la cola de prioridad");

				modelo = new Modelo();

				int tamano = lector.nextInt();

				modelo.cargarDatos();
				modelo.cargarDatosCola(tamano);
				modelo.cargarDatosHeap(tamano);
				view.printMessage(modelo.ResultadoCargaFinal(tamano));
				

				break;

			case 9: 
				view.printMessage("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;	

			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}
