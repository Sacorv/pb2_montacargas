package ar.edu.unlam.pb2.montacarga;

import static org.junit.Assert.*;

import org.junit.Test;

public class MontacargaTest {

	@Test 
	public void queSePuedaCrearUnMontacargasVacio() {
		Montacargas montacargas = new Montacargas(20);
		Integer cargaObtenida = montacargas.obtenerCarga();
		
		
		assertEquals(0, cargaObtenida, 0);
	}
	
	@Test
	public void queSePuedaCargarElMontacargas() {
		Montacargas montacargas = new Montacargas(10);
		Carga cargaUno = new Carga(5);
		montacargas.cargar(cargaUno);
		Integer valorEsperado = 5;
		Integer cargaActual = montacargas.obtenerCarga();
		
		assertEquals(valorEsperado, cargaActual);
	}
	
	@Test 
	public void queNoSePuedaCargarSiSuperaElPesoMaximo() {
		Montacargas montacarga = new Montacargas(10);
		Carga cargaUno = new Carga(15);
		
		assertFalse(montacarga.cargar(cargaUno));
		
	}
	
	@Test 
	public void queSePuedaVaciarElMontacargas() {
		Montacargas montacarga = new Montacargas(30);
		Carga cargaUno = new Carga(15);
		Carga cargaDos = new Carga(10);
		montacarga.cargar(cargaUno);
		montacarga.cargar(cargaDos);
		montacarga.descargar();
		
		assertEquals(0, montacarga.obtenerCarga(), 0);
	}
	
	@Test
	public void obtenerCargaConMontacargaVacio() {
		Montacargas montacarga = new Montacargas(30);
		
		assertEquals(0, montacarga.obtenerCarga(), 0);
	}
	
	@Test
	public void queSePuedaObtenerLaCargaPromedio() {
		Montacargas montacarga = new Montacargas(40);
		Carga carga1 = new Carga(5);
		Carga carga2 = new Carga(10);
		montacarga.cargar(carga1);
		montacarga.cargar(carga2);
		montacarga.descargar();
		Carga carga3 = new Carga(12);
		montacarga.cargar(carga3);
		montacarga.descargar();
		
		assertEquals(13.5, montacarga.obtenerCargaPromedio(), 0.0);
	}
	
	
	@Test
	public void obtenerCargaPromedioHabiendoDescargadoYVueltoACargar() {
		Montacargas montacarga = new Montacargas(40);
		Carga carga1 = new Carga(5);
		Carga carga2 = new Carga(10);
		montacarga.cargar(carga1);
		montacarga.cargar(carga2);
		montacarga.descargar();
		Carga carga3 = new Carga(12);
		montacarga.cargar(carga3);
		
		assertEquals(15.0, montacarga.obtenerCargaPromedio(), 0.1);
	}

	@Test
	public void obtenerCargaPromedioSinHaberDescargado() {
		Montacargas montacarga = new Montacargas(40);
		Carga carga1 = new Carga(5);
		Carga carga2 = new Carga(10);
		montacarga.cargar(carga1);
		montacarga.cargar(carga2);
		
		assertEquals(0.0, montacarga.obtenerCargaPromedio(), 0.1);
	}
	 
	
	
	
}
