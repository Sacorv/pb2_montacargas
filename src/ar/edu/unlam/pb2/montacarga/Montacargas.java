package ar.edu.unlam.pb2.montacarga;

import java.util.ArrayList;

public class Montacargas {
	
	private Integer pesoMaximo;
	private ArrayList<Carga> cargas;
	private Integer cantidadDeDescargas;
	private Integer pesoDescargado;
	
	
	public Montacargas(Integer pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
		this.cargas = new ArrayList <Carga> ();
		this.cantidadDeDescargas = 0;
		this.pesoDescargado = 0;
	}
	
	
	//Devuelve el peso total actual del montacargas
	public Integer obtenerCarga() {
		Integer totalCargaActual = 0;
		
		for (Carga carga : cargas) {
			if(carga!=null) {
				totalCargaActual+= carga.getPeso();
			}
		}
		return totalCargaActual;
	}
	
	
	//Se realiza una carga mientras que no se pase del peso maximo
	public Boolean cargar(Carga carga) {
		Boolean cargaExitosa = false;
		
		if((carga.getPeso() + obtenerCarga())<=pesoMaximo) {
//			this.cargas.add(carga);
//			cargaExitosa = true;
			cargaExitosa = this.cargas.add(carga); //El add devuelve un Boolean
		}
		return cargaExitosa;
	}
	
	
	//Cada descarga que se va haciendo se va contabilizando y tambien se va sumando el peso de las mismas
	public void descargar() {
		//Esto era en el caso de que cada carga se toma individualmente. 
		//Es decir si se cargaron 3 cargas, cuando descargo serian 3 descargas.
		//Pero el fin del ejercicio era que se va cargando por ejemplo 3 cargas, se suman las 3 cargas y 
		//cuando descargo se contabiliza como una sola descarga
		
//		for (Carga carga : cargas) {
//			if(carga!=null) {
//				this.cargas.remove(carga);
//				cantidadDeDescargas++;
//				pesoDescargado+= carga.getPeso();
//			}
//		}
		cantidadDeDescargas++;
		pesoDescargado+= obtenerCarga();
		this.cargas.clear();
		
		 //Como no nos interesa la cantidad de cargas que se hicieron, directamente al realizar una descarga
		//del montacargas (Ejemplo un camion) lo contabilizo como una descarga completada
	
		 
	}
	
	
	
	//Devuelve el promedio en Kg pero solo de las cargas que fueron completadas
	public Double obtenerCargaPromedio() {
		Double cargaPromedio = 0.0;
		if(this.cantidadDeDescargas>0) {
			cargaPromedio = (double)pesoDescargado/cantidadDeDescargas;
		}
		
		return cargaPromedio;
	}


	
	
	
}
