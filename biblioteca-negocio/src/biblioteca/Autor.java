package biblioteca;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Date getFachaDeNacimiento() {
		return fachaDeNacimiento;
	}

	public void setFachaDeNacimiento(Date fachaDeNacimiento) {
		this.fachaDeNacimiento = fachaDeNacimiento;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Autor [nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", fachaDeNacimiento=" + fachaDeNacimiento
				+ ", libros=" + libros + "]";
	}
	
	

	
	
}
