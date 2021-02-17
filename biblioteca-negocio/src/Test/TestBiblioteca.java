package Test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import biblioteca.Autor;
import biblioteca.Biblioteca;
import biblioteca.Copia;
import biblioteca.Lector;
import biblioteca.Libro;
import biblioteca.tipoLibro;
import excepciones.NoPuedePedir;
import excepciones.NoTieneLaCopia;
import excepciones.PrestamoNoVencido;

public class TestBiblioteca {
	
	private Biblioteca bib;
	private Lector lectorA;
	private Lector lectorB;
	private Date hoy = new Date();
	private Date ayer = new Date(hoy.getTime() - Long.valueOf(86400000));
	@Before
	public void setUp() throws Exception {		
		this.bib = new Biblioteca();		
		this.lectorA = new Lector(15,"Jorge","485523364","Js olivos");
		this.lectorB = new Lector(25,"Lucas","485523364","Js olivos");
		Libro principito = new Libro("Principito", tipoLibro.NOVELA, "Cabka", 1997, new Autor());
		Libro hp = new Libro("HP", tipoLibro.NOVELA, "Cabka", 1997, new Autor());
		Libro lk = new Libro("LK", tipoLibro.NOVELA, "Cabka", 1997, new Autor());
		Libro novel = new Libro("Novel", tipoLibro.NOVELA, "Cabka", 1997, new Autor());
		
		bib.anadirLibro(principito);
		bib.anadirLibro(principito);
		bib.anadirLibro(hp);
		bib.anadirLibro(lk);
		bib.anadirLibro(novel);		
	}

	// Que pasa si pido mas de 3 libros
	@Test
	public void testPrestarMasDe3() throws PrestamoNoVencido, NoTieneLaCopia {
		try {
			for (Copia c : this.bib.getCopiasStock()) {
				System.out.println(bib.prestarLibro(c, this.lectorA));
				lectorA.listarPrestamos();
			}
		} catch (NoPuedePedir e) {
			e.getStackTrace();
		}
	}

	// Pedir 3, devolver 1 y pedir 1 de nuevo
	@Test

	public void testPedirYDevolver() {
		try {
			bib.prestarLibro(bib.getCopiasStock().get(0), lectorA);
			bib.prestarLibro(bib.getCopiasStock().get(1), lectorA);
			bib.prestarLibro(bib.getCopiasStock().get(2), lectorA);
			bib.recibirLibro(bib.getCopiasStock().get(2), lectorA);
			bib.prestarLibro(bib.getCopiasStock().get(3), lectorA);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// la multa no tiene fecha por eso tira error o analizar el por que y generearla
	// desde un prestamo

	@Test

	public void pedirConMulta() {
		try {
			bib.prestarLibro(bib.getCopiasStock().get(0), lectorB);
			lectorB.getPrestamos().get(0).setFin(ayer);
			bib.prestarLibro(bib.getCopiasStock().get(2), lectorB);
			lectorB.listarPrestamos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test

	public void buscadorCopiaEnBib() {
		Copia copiaBuscada = bib.getCopiasStock().get(0);
		assertTrue(copiaBuscada == bib.buscadorCopiaEnBib(copiaBuscada));
	}
	
	//le paso una copia que fue prestada y devuelve una igual pero de distinto id y que esta en la biblioteca 
	@Test 
	
	public void buscadorCopiaDisponible() throws NoPuedePedir, PrestamoNoVencido, NoTieneLaCopia {
		Copia copiaRespuestaDeseada = bib.getCopiasStock().get(1);
		Copia copiaMandadaPorParametro = bib.getCopiasStock().get(0);
		bib.prestarLibro(copiaMandadaPorParametro, lectorB);
		assertTrue(copiaRespuestaDeseada == bib.buscadorCopiaDisponible(copiaMandadaPorParametro));
		
	}
}
