import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bibilioteca {
	
	private Set<Libro> librosTotales;
	private List<Copia> librosPrestados;
	private List<Copia> librosStock;

	
	public Bibilioteca() {
		librosTotales = new HashSet<Libro>();
		librosPrestados= new ArrayList<Copia>();
		librosStock= new ArrayList<Copia>();
	}
	
	
	public void anadirLibro(Libro libro) {		
//			if (!librosTotales.contains(libro)) {
//				librosTotales.add(libro);
//				librosStock.add(new Copia(libro));				
//		}else {
//			librosStock.add(new Copia(libro));	
		librosTotales.add(libro);
		librosStock.add(new Copia(libro));
		
//	}
	
}
	
	public void listarLibros() {
		System.out.println("Libros");
		for (Libro libro : librosTotales) {
			System.out.println(libro.getTitulo());
		}
		System.out.println("Copias");
		for (Copia copia : librosStock) {
			System.out.println(copia.getLibro().getTitulo() + " " + copia.getId());
		}
	}
	
	public void pedir(long id){
		
	}
	
	public void devolver(){
		
	}
}
