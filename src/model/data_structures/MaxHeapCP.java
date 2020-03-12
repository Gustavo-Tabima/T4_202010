package model.data_structures;

import java.util.Comparator;

public class MaxHeapCP<K extends Comparable<K>> implements IMaxHeapCP<K> 
{
	private int tamano;
	private K[] arreglo;

	public MaxHeapCP(int capacidad)
	{
		tamano = 0;
		arreglo = (K[]) new Comparable[capacidad + 1];
	}

	public MaxHeapCP()
	{
		this(1);
	}

	public MaxHeapCP(K[] llave)
	{
		tamano = llave.length;
		arreglo = (K[]) new Comparable[llave.length + 1];
		for (int i = 0; i < tamano; i++)
		{
			arreglo[i+1] = llave[i];
		}
		for (int k = tamano/2; k >= 1; k--)
		{
			sink(k);
		}
	}

	@Override
	public int darnumeroElementos() 
	{
		return tamano;
	}

	@Override
	public void agregarElemento(K llave)
	{
		if (tamano == arreglo.length - 1)
		{
			cambiarTamano(arreglo.length*2);
		}
		else if(tamano == 0)
		{
			arreglo[++tamano] = llave;
		}
		else
		{
			arreglo[++tamano] = llave;
			swim(tamano);	
		}

	}


	@Override
	public K darMax() throws noExisteObjetoException
	{
		if (estaVacia())
		{
			throw new noExisteObjetoException();
		}

		return arreglo[1];
	}


	@Override
	public K sacarMax() throws noExisteObjetoException 
	{ 
		if (estaVacia()) 
		{
			throw new noExisteObjetoException();
		}
		if(tamano == 1)
		{
			K max = arreglo[tamano--];
			arreglo[1] = null;
		}
		K max = arreglo[1];
		intercambiar(1, tamano--);
		sink(1);
		arreglo[tamano+1] = null;

		return max;
	}

	@Override
	public boolean estaVacia() 
	{
		return tamano == 0;
	}

	private void swim(int k)
	{
		while (k > 1 && esMenor(k/2, k)) 
		{
			intercambiar(k, k/2);
			k = k/2;
		}
	}

	private void sink(int k)
	{
		while (2*k <= tamano) 
		{
			int j = 2*k;
			if (j < tamano && esMenor(j, j+1))
			{
				j++;
			}
			if (!esMenor(k, j))
			{
				break;
			}
			intercambiar(k, j);
			k = j;
		}
	}

	private boolean esMenor(int i, int j) 
	{
		return (arreglo[i]).compareTo(arreglo[j]) < 0;
	}

	private void intercambiar(int i, int j)
	{
		K swap = arreglo[i];
		arreglo[i] = arreglo[j];
		arreglo[j] = swap;
	}

	private void cambiarTamano(int capacidad) 
	{
		K[] tamNuevo = (K[]) new Comparable[capacidad];
		for (int i = 1; i <= tamano; i++)
		{
			tamNuevo[i] = arreglo[i];
		}
		arreglo = tamNuevo;
	}

	
	


} 
