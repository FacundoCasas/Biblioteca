package biblioteca;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import excepciones.NoPuedePedir;
import excepciones.NoTieneLaCopia;
import excepciones.PrestamoNoVencido;

public class Biblioteca {
	static final estadoCopia BIBLIOTECA = estadoCopia.BIBLIOTECA;
	static final estadoCopia PRESTADO = estadoCopia.PRESTADO;
	static final estadoCopia RETRASO = estadoCopia.RETRASO;
	private Set<Libro> librosTotales;
	private List<Copia> CopiasStock;
	static private Date hoy = new Date();

	public Biblioteca() {
		librosTotales = new HashSet<Libro>();
		CopiasStock = new ArrayList<Copia>();
	}

	public void anadirLibro(Libro libro) {
		librosTotales.add(libro);
		libro.setId(librosTotales.size() + 1);
		CopiasStock.add(new Copia(libro, (CopiasStock.size() + 1)));
	}

	public void listarLibros() {
		System.out.println("Libros");
		for (Libro libro : librosTotales) {
			System.out.println("Nombre :" + libro.getTitulo() + "ID:" + libro.getId());
		}
		System.out.println("Copias");
		for (Copia copia : CopiasStock) {
			System.out.println("Nombre :" + copia.getLibro().getTitulo() + "ID:" + copia.getId());
		}
	}

	public void recibirLibro(Copia copia, Lector lector) throws NoTieneLaCopia, PrestamoNoVencido {
		Prestamo prestamoRecibido = lector.buscarPrestamo(copia);
		if (prestamoRecibido != null) {
			Copia copiaEnBib = buscadorCopiaEnBib(prestamoRecibido.getCopia());
			if (copiaEnBib == null) {
				throw new NoTieneLaCopia("Ese libro no es de esta biblioteca");
			}
			estadoCopia(copiaEnBib, estadoCopia.BIBLIOTECA);
			if (vencido(prestamoRecibido, lector)) {
				multar(lector, prestamoRecibido, copiaEnBib);
				System.out.println("Tiene un prestamo vencido");
			}
		}
	}
	
	public boolean prestarLibro(Copia copia, Lector lector) throws NoPuedePedir, PrestamoNoVencido, NoTieneLaCopia {
		boolean pudo = false;
		Copia copiaEnBib = buscadorCopiaDisponible(copia);
		if (lector.NoPuedePedir()) {
		} else if (copiaEnBib == null) {
			throw new NoTieneLaCopia("Ese libro no esta Disponible");
		} else if (TienePrestamosVencidos(lector)) {
			System.out.println("Posee Prestamos Vencidos");
		} else {
			lector.getPrestamos().add(new Prestamo(hoy, lector, copia));
			estadoCopia(copiaEnBib, estadoCopia.PRESTADO);
			pudo = true;
		}
		return pudo;
	}

	private boolean TienePrestamosVencidos(Lector lector) throws PrestamoNoVencido {
		boolean prestamosVencidos = false;
		List<Prestamo> prestamosPorLector = lector.getPrestamos();
		if (prestamosPorLector.size() == 0) {
			System.out.println("No posee prestamos");
		} else {
			int i = 0;
			while (prestamosPorLector.size() > i && prestamosVencidos == false) {
				if (vencido(prestamosPorLector.get(i), lector)) {
					prestamosVencidos = true;
				}
				i++;
			}
		}
		return prestamosVencidos;
	}

	private boolean vencido(Prestamo prestamo, Lector lector) throws PrestamoNoVencido {
		Boolean vencido = false;
		if (hoy.after(prestamo.getFin())) {
			vencido = true;
		}
		return vencido;
	}

	private void multar(Lector lector, Prestamo prestamo, Copia copiaEnBib) throws PrestamoNoVencido {
		lector.getMultas().add(new Multa(lector, prestamo));
		estadoCopia(copiaEnBib, RETRASO);
	}

	private void estadoCopia(Copia copia, estadoCopia estado) {
		if (estado == BIBLIOTECA) {
			copia.setEstado(estado);
		} else if (estado == PRESTADO) {
			copia.setEstado(estado);
		} else if (estado == RETRASO) {
			copia.setEstado(estado);
		}
	}

	public Copia buscadorCopiaEnBib(Copia copia) {
		int i = 0;
		Copia copiaBuscada = null;
		while (CopiasStock.size() > i && copiaBuscada == null) {
			if (CopiasStock.get(i).equals(copia)) {
				copiaBuscada = CopiasStock.get(i);
			}
			i++;
		}
		return copiaBuscada;
	}
	
	public Copia buscadorCopiaDisponible(Copia copia) {
		int i = 0;
		Copia copiaBuscada = null;
		while (CopiasStock.size() > i && copiaBuscada == null) {
			if (CopiasStock.get(i).getLibro() == copia.getLibro() && CopiasStock.get(i).getEstado() == estadoCopia.BIBLIOTECA) {				
				copiaBuscada = CopiasStock.get(i);
			}
			i++;
		}
		return copiaBuscada;
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

	public List<Copia> getCopiasStock() {
		return CopiasStock;
	}

	public void setCopiasStock(List<Copia> librosStock) {
		this.CopiasStock = librosStock;
	}
}
