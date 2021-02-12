import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Biblioteca {
	
	private Set<Libro> librosTotales;
	private List<Prestamo> librosPrestados;
	private List<Copia> librosStock;
	private Set<Lector> socios;
	static private Date hoy = new Date();

	
	public Biblioteca() {
		librosTotales = new HashSet<Libro>();
		librosPrestados = new ArrayList<Prestamo>();
		librosStock = new ArrayList<Copia>();
		socios = new HashSet<Lector>();
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
	
	public void recibirLibro(Prestamo prestamo) {
		
	}
	
	public boolean prestarLibro(long idCopia,long nroSocio){
		boolean pudo = false;
		if (nroSocio == 0) {
			System.out.println("Esta Persona No esta Registrada");
		}
		else if (prestamosVencidos(nroSocio)) {
			System.out.println("Posee Prestamos Vencidos");
			
		}else {
			Prestamo nuevoPrestamo = new Prestamo(hoy,nroSocio,idCopia);

			//Crear Un Prestamo
			
			//ponerlo el mismo instanciado afuera en lector y en biblioteca
			//buscar id libro y cambiar su estado a en prestamo
			pudo = true;
		}
		return pudo;
	}
	
	
	private boolean prestamosVencidos(long nroSocio) {
		boolean prestamosVencidos = false;
//		Set<Lector> sociosConPrestamos = new HashSet<Lector>();
		Set<Prestamo> prestamosPorLector = prestamosPorPersona(nroSocio);
		if (prestamosPorLector.size() == 0) {
			System.out.println("No posee prestamos");
		}else {
			for (Prestamo prestamo : prestamosPorLector) {
				if (prestamo.getFin().after(hoy)) {
					multar(nroSocio);
				}
			}
			prestamosVencidos = true;
		}		
		return prestamosVencidos;
	}
	
	private Set<Prestamo> prestamosPorPersona(long nroSocio) {
		Set<Prestamo> prestamosPorLector = new HashSet<Prestamo>(); 
		for (Prestamo prestamo : librosPrestados) {
			if (prestamo.getNroSocio() == nroSocio) {
				prestamosPorLector.add(prestamo);
			}
		}
		return prestamosPorLector;
	}

	private void multar(long nroSocio) {
		Multa multa = new Multa(hoy);
		for (Lector socio : socios) {
			if (socio.getNroSocio() == nroSocio) {				
				socio.getMultas().add(multa);
				System.out.println(multa.toString());
			}
		}
	}


	public static Date getHoy() {
		return hoy;
	}


	public static void setHoy(Date hoy) {
		Biblioteca.hoy = hoy;
	}
	
	
	
}
