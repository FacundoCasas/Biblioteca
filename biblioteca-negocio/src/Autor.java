import java.util.Date;
import java.util.List;

public class Autor {

	private String nombre;
	private String nacionalidad;
	private Date fachaDeNacimiento;
	private List<Libro> libros;
	
	public Autor() {
		
	}

	public Autor(String nombre, String nacionalidad, Date fachaDeNacimiento, List<Libro> libros) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.fachaDeNacimiento = fachaDeNacimiento;
		this.libros = libros;
	}


	
	
}
