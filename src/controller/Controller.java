package controller;

import java.util.Scanner;

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
					view.printMessage("--------- \nCrear Cola de prioridad \nPorfavor ingrese el tama�o de la muestra ");
				    int Muestra = lector.nextInt();
				    modelo = new Modelo(Muestra,"cola"); 
				    view.printMessage("Cola de prioridad creado");
				    view.printMessage("Numero actual de elementos heap " + modelo.darTamanoCola() + "\n---------");						

					break;

				case 2:
					view.printMessage("--------- \nDar cadena (simple) a ingresar: ");
					dato = lector.next();
		
					view.printMessage("Dato agregado");
					view.printMessage("Numero actual de elementos " + modelo.darTamanoCola() + "\n---------");						
					break;
					
				case 3:
					view.printMessage("--------- \nDar cadena (simple) a ingresar: ");
					dato = lector.next();
					modelo.agregarHeap(dato);
					view.printMessage("Dato agregado");
					view.printMessage("Numero actual de elementos " + modelo.darTamanoCola() + "\n---------");						
					break;
				case 4:
					view.printMessage("--------- \nDar cadena (simple) a buscar: ");
					dato = lector.next();
					respuesta = modelo.buscarCola(dato);
					if ( respuesta != null)
					{
						view.printMessage("Dato encontrado: "+ respuesta);
					}
					else
					{
						view.printMessage("Dato NO encontrado");
					}
					view.printMessage("Numero actual de elementos " + modelo.darTamanoCola() + "\n---------");						
					break;
					
				case 5:
					view.printMessage("--------- \nDar cadena (simple) a buscar: ");
					dato = lector.next();
					respuesta = modelo.buscarCola(dato);
					if ( respuesta != null)
					{
						view.printMessage("Dato encontrado: "+ respuesta);
					}
					else
					{
						view.printMessage("Dato NO encontrado");
					}
					view.printMessage("Numero actual de elementos " + modelo.darTamanoCola() + "\n---------");						
					break;

//				case 6:
//					view.printMessage("--------- \nDar cadena (simple) a eliminar: ");
//					dato = lector.next();
//					respuesta = modelo.eliminarCola(dato);
//					if ( respuesta != null)
//					{
//						view.printMessage("Dato eliminado "+ respuesta);
//					}
//					else
//					{
//						view.printMessage("Dato NO eliminado");							
//					}
//					view.printMessage("Numero actual de elementos " + modelo.darTamanoCola() + "\n---------");						
//					break;
//					
					
				case 7:
					view.printMessage("--------- \nDar cadena (simple) a eliminar: ");
					dato = lector.next();
					respuesta = modelo.eliminarHeap(dato);
					if ( respuesta != null)
					{
						view.printMessage("Dato eliminado "+ respuesta);
					}
					else
					{
						view.printMessage("Dato NO eliminado");							
					}
					view.printMessage("Numero actual de elementos " + modelo.darTamanoCola() + "\n---------");						
					break;

				case 8: 
					view.printMessage("--------- \nContenido del Arreglo: ");
					view.printModelo(modelo);
					view.printMessage("Numero actual de elementos " + modelo.darTamanoCola() + "\n---------");						
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
