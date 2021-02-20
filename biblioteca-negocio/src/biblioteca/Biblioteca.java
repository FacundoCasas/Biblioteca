package biblioteca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import excepciones.NoPuedePedir;
import excepciones.NoTieneLaCopia;
import excepciones.PrestamoNoVencido;

public class Biblioteca {
	static final estadoCopia BIBLIOTECA = estadoCopia.BIBLIOTECA;
	static final estadoCopia PRESTADO = estadoCopia.PRESTADO;
	static final estadoCopia RETRASO = estadoCopia.RETRASO;
	private List<Libro> librosTotales;
	private List<Copia> CopiasStock;
	static private Date hoy = new Date();

	public Biblioteca() {
		librosTotales = new ArrayList<Libro>();
		CopiasStock = new ArrayList<Copia>();
	}
	
	//los ids van a ser autogenerados
	public void anadirLibro(Libro libro) {
		Libro libroRepetido = libroRepetido(libro);
		if (libroRepetido != null) {
			Copia copiaNueva = new Copia(libro, (CopiasStock.size() + 1));
			CopiasStock.add(copiaNueva);
			libroRepetido.getCopias().add(copiaNueva);
		}else {
			libro.setLibroId(librosTotales.size() + 1);
			Copia copiaNueva = new Copia(libro, (CopiasStock.size() + 1));
			libro.getCopias().add(copiaNueva);
			CopiasStock.add(copiaNueva);
			librosTotales.add(libro);
			
		}
	}
	
	public Libro libroRepetido(Libro libro) {
		int i = 0;
		Libro libroBuscado = null;
		while (librosTotales.size() > i && libroBuscado == null) {
			if (librosTotales.get(i).equals(libro)) {
				libroBuscado = librosTotales.get(i);
			}
			i++;
		}
		return libroBuscado;
	}

	public void listarLibros() {
		System.out.println("Libros");
		for (Libro libro : librosTotales) {
			System.out.println("Nombre :" + libro.getTitulo() + " ID:" + libro.getLibroId());
		}
		System.out.println("Copias");
		for (Copia copia : CopiasStock) {
			System.out.println("Nombre :" + copia.getTitulo() + " ID:" + copia.getId());
		}
	}
	
	public void recibirLibro(Prestamo prestamo, Lector lector) throws NoTieneLaCopia, PrestamoNoVencido {
		if (prestamo != null) {
			Copia copiaEnBib = buscadorCopiaEnBib(prestamo.getCopia());
			if (copiaEnBib == null) {
				throw new NoTieneLaCopia("Ese libro no pertenece a esta biblioteca");
			}
			lector.getPrestamos().remove(prestamo);
			estadoCopia(copiaEnBib, estadoCopia.BIBLIOTECA);
			if (vencido(prestamo.getFin())) {
				multar(lector, prestamo);
			}
		}
	}
	
	public boolean prestarLibro(Libro libro, Lector lector) throws NoPuedePedir, PrestamoNoVencido, NoTieneLaCopia {
		boolean pudo = false;
		Copia copiaEnBib = buscadorCopiaDisponible(libro.getCopias().get(0));
		if (lector.NoPuedePedir()) {
		} else if (copiaEnBib == null) {
			throw new NoTieneLaCopia("Ese libro no esta Disponible");
		} else {
			lector.getPrestamos().add(new Prestamo(hoy, lector, copiaEnBib));
			estadoCopia(copiaEnBib, estadoCopia.PRESTADO);
			pudo = true;
		}
		return pudo;
	}
	
//	private void cambiarEstadosDeCopias(List<Copia> copias,estadoCopia estado) {
//		for (Copia copia : copias) {	
//			estadoCopia(buscadorCopiaEnBib(copia), estado);
//		}				
//	}
	
	private boolean vencido(Date fin) {
		Boolean vencido = false;
		if (hoy.after(fin)) {
			vencido = true;
		}
		return vencido;
	}

	private void multar(Lector lector, Prestamo prestamo) throws PrestamoNoVencido {
		lector.getMultas().add(new Multa(lector, prestamo));
		System.out.println("Se multo al lector " + lector.getNombre());
	}

	private void estadoCopia(Copia copia, estadoCopia estado) {
		if (estado == BIBLIOTECA) {
			copia.setEstado(estado);
		} else if (estado == PRESTADO) {
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
			if (CopiasStock.get(i).equals(copia) && CopiasStock.get(i).getEstado() == estadoCopia.BIBLIOTECA) {
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

	public List<Libro> getLibrosTotales() {
		return librosTotales;
	}

	public void setLibrosTotales(List<Libro> librosTotales) {
		this.librosTotales = librosTotales;
	}

	public List<Copia> getCopiasStock() {
		return CopiasStock;
	}

	public void setCopiasStock(List<Copia> librosStock) {
		this.CopiasStock = librosStock;
	}
}


