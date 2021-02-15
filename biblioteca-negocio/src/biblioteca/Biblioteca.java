package biblioteca;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import excepciones.NoPuedePedir;

public class Biblioteca {
	
	private Set<Libro> librosTotales;
	private List<Copia> librosStock;
	static private Date hoy = new Date();

	
	public Biblioteca() {
		librosTotales = new HashSet<Libro>();
		librosStock = new ArrayList<Copia>();
	}
	
	
	public void anadirLibro(Libro libro) {						
		librosTotales.add(libro);
		libro.setId(librosTotales.size() + 1);	
		librosStock.add(new Copia(libro,(librosStock.size() + 1)));
}
	
	public void listarLibros() {
		System.out.println("Libros");
		for (Libro libro : librosTotales) {
			System.out.println("Nombre :" + libro.getTitulo() + "ID:" + libro.getId());
		}
		System.out.println("Copias");
		for (Copia copia : librosStock) {
			System.out.println("Nombre :" + copia.getLibro().getTitulo() + "ID:" + copia.getId());
		}
	}
	
	public void recibirLibro(Copia copia,Lector lector) {
		if (lector.buscarPrestamo(copia)) {
			copia.setEstado(estadoCopia.BIBLIOTECA);
		}else {
			System.out.println("No posee la copia");
		}				
	}
	
	public boolean prestarLibro(Copia copia,Lector lector) throws NoPuedePedir{
		boolean pudo = false;		
		if (lector.NoPuedePedir()) {
			System.out.println("Esta Persona tiene mas de x libros");
		}	
		else if (prestamosVencidos(lector)) {
			System.out.println("Posee Prestamos Vencidos");			
		}else {
			Prestamo nuevoPrestamo = new Prestamo(hoy,lector,copia);
			//Crear Un Prestamo
			lector.getPrestamos().add(nuevoPrestamo);			
			//ponerlo el mismo instanciado afuera en lector y en biblioteca
			copia.setEstado(estadoCopia.PRESTADO);
			//buscar id libro y cambiar su estado a en prestamo
			pudo = true;
		}
		return pudo;
	}
	
	
	private boolean prestamosVencidos(Lector lector) {
		boolean prestamosVencidos = false;
		List<Prestamo> prestamosPorLector = lector.getPrestamos();
		if (prestamosPorLector.size() == 0) {
			System.out.println("No posee prestamos");
		}else {
			for (Prestamo prestamo : prestamosPorLector) {
				if (hoy.after(prestamo.getFin())) {
					multar(lector,prestamo);
					prestamosVencidos = true;
				}
			}
			
		}		
		return prestamosVencidos;
	}
	

	private void multar(Lector lector,Prestamo prestamo) {
		if (lector.actualizarMulta(prestamo)) {
			System.out.println("Execption se actualizo la multa");
		}else {
			lector.getMultas().add(new Multa(lector,prestamo));
		}
	}


	public static Date getHoy() {
		return hoy;
	}


	public static void setHoy(Date hoy) {
		Biblioteca.hoy = hoy;
	}


	public Set<Libro> getLibrosTotales() {
		return librosTotales;
	}


	public void setLibrosTotales(Set<Libro> librosTotales) {
		this.librosTotales = librosTotales;
	}


	public List<Copia> getLibrosStock() {
		return librosStock;
	}


	public void setLibrosStock(List<Copia> librosStock) {
		this.librosStock = librosStock;
	}
	
	
	
}
