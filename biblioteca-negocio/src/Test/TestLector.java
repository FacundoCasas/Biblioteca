package Test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import biblioteca.Autor;
import biblioteca.Biblioteca;
import biblioteca.Lector;
import biblioteca.Libro;
import biblioteca.Multa;
import biblioteca.Prestamo;
import biblioteca.tipoLibro;
import excepciones.NoPuedePedir;
import excepciones.NoTieneLaCopia;
import excepciones.PrestamoNoVencido;

public class TestLector {
	
	private Biblioteca bib;
	private Lector lectorB;
	private Date hoy = new Date();
	private Date ayer = new Date(hoy.getTime() - Long.valueOf(86400000));
	
	@Before
	public void setUp() throws Exception {
		this.bib = new Biblioteca();		
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
	
	
	//Multamos a el lectorA multiples veces vencemos sus multas y vemos si al pedir lo desmulta
	@Test
	public void DesmultarMultiple() throws NoTieneLaCopia, PrestamoNoVencido {
		try {
			bib.prestarLibro(bib.getCopiasStock().get(0), lectorB);
			bib.prestarLibro(bib.getCopiasStock().get(1), lectorB);
			lectorB.getPrestamos().get(0).setFin(ayer);
			lectorB.getPrestamos().get(1).setFin(ayer);
			lectorB.listarPrestamos();
			bib.prestarLibro(bib.getCopiasStock().get(2), lectorB);
			lectorB.listarMultas();
			
			System.out.println();
			//devolvemos los libros para no crear las multas devuelta
			
			bib.recibirLibro(bib.getCopiasStock().get(0), lectorB);
			bib.recibirLibro(bib.getCopiasStock().get(1), lectorB);
			lectorB.listarPrestamos();
			
			System.out.println();
			//vencemos las multas
			
			System.out.println();
			
			lectorB.getMultas().get(0).setfFin(ayer);
			lectorB.getMultas().get(1).setfFin(ayer);
			bib.prestarLibro(bib.getCopiasStock().get(2), lectorB);
			
			System.out.println();
			
			lectorB.listarMultas();											
			lectorB.listarPrestamos();
		} catch (NoPuedePedir e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NoTieneLaCopia a) {
			// TODO Auto-generated catch block
			a.printStackTrace();
		}
				
	}

	@Test
	public void NoPuedePedirMas3() throws NoPuedePedir {
		try {
			lectorB.getPrestamos().add(new Prestamo(hoy, lectorB, bib.getCopiasStock().get(0)));
			lectorB.getPrestamos().add(new Prestamo(hoy, lectorB, bib.getCopiasStock().get(1)));
			lectorB.getPrestamos().add(new Prestamo(hoy, lectorB, bib.getCopiasStock().get(2)));
			boolean Puede = lectorB.NoPuedePedir();
			assertTrue(Puede == false);
		} catch (excepciones.NoPuedePedir e) {
			e.getMessage();
		}
	}

	@Test
	public void NoPuedePedirPorMulta() throws NoPuedePedir, PrestamoNoVencido {
		try {
			lectorB.getPrestamos().add(new Prestamo(hoy, lectorB, bib.getCopiasStock().get(0)));
			lectorB.getPrestamos().get(0).setFin(ayer);
			lectorB.getMultas().add(new Multa(lectorB, lectorB.getPrestamos().get(0)));
			lectorB.listarMultas();
			boolean Puede = lectorB.NoPuedePedir();
			assertTrue(Puede == false);
		} catch (excepciones.NoPuedePedir e) {
			e.getMessage();
		}
	}

	@Test
	public void CreaUnaMultaConUnPrestamoNoVencido() throws NoPuedePedir, PrestamoNoVencido {
		try {
			lectorB.getPrestamos().add(new Prestamo(hoy, lectorB, bib.getCopiasStock().get(0)));
			lectorB.getMultas().add(new Multa(lectorB, lectorB.getPrestamos().get(0)));
			lectorB.listarMultas();
			boolean Puede = lectorB.NoPuedePedir();
			assertTrue(Puede == false);
		} catch (excepciones.NoPuedePedir e) {
			e.printStackTrace();
		} catch (PrestamoNoVencido a) {
//			a.printStackTrace();
		}
	}

	@Test
	public void DesmultarMultasActivas() throws PrestamoNoVencido {
		try {
			lectorB.getPrestamos().add(new Prestamo(hoy, lectorB, bib.getCopiasStock().get(0)));
			lectorB.getPrestamos().get(0).setFin(ayer);
			lectorB.getMultas().add(new Multa(lectorB, lectorB.getPrestamos().get(0)));
			lectorB.getMultas().add(new Multa(lectorB, lectorB.getPrestamos().get(0)));
			lectorB.getMultas().add(new Multa(lectorB, lectorB.getPrestamos().get(0)));
			lectorB.getMultas().get(0).setfFin(ayer);
			lectorB.getMultas().get(1).setfFin(ayer);
			lectorB.getMultas().get(2).setfFin(ayer);
			lectorB.listarMultas();
			boolean Puede = lectorB.NoPuedePedir();
			assertTrue(Puede == false);
		} catch (excepciones.NoPuedePedir e) {
			e.getMessage();
		}
	}

	@Test
	public void buscarPrestamoSinCopias() throws NoTieneLaCopia {
		try {
			lectorB.buscarPrestamo(bib.getCopiasStock().get(0));
		} catch (NoTieneLaCopia e) {
			e.getMessage();
		}
	}

	@Test
	public void buscarPrestamos() {
		try {
			Prestamo pretamo1 = new Prestamo(hoy, lectorB, bib.getCopiasStock().get(0));
			Prestamo pretamo2 = new Prestamo(hoy, lectorB, bib.getCopiasStock().get(1));
			Prestamo pretamo3 = new Prestamo(hoy, lectorB, bib.getCopiasStock().get(2));
			lectorB.getPrestamos().add(pretamo1);
			lectorB.getPrestamos().add(pretamo2);
			lectorB.getPrestamos().add(pretamo3);
			assertTrue(pretamo1 == lectorB.buscarPrestamo(bib.getCopiasStock().get(0)));
		} catch (NoTieneLaCopia e) {
			e.getMessage();
		}
	}

}
