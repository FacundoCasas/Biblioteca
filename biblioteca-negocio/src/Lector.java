
import java.util.List;

public class Lector {
	
	private long nroSocio;
	private String nombre;
	private String telefono;
	private String direccion;
	private List<Prestamo> prestamos;
	private List<Multa> multas;
	
	public Lector(){
		this.nroSocio = 0;
	}
	
	public void pedir(long id,Biblioteca biblioteca){
		if (multas.size() == 0 && prestamos.size() <= 3) {
			biblioteca.prestarLibro(id,nroSocio);
		}		
	}
	
	public void devolver(long idLibro,Biblioteca biblioteca){
		if (prestamos.size() == 0) {
			System.out.println( nombre + " no posee Libros");
		}else {
			biblioteca.recibirLibro(buscarPrestamo(idLibro));
			System.out.println(nombre + " devolvio el Libro");
		}
	}
	
	private Prestamo buscarPrestamo(long idLibro) {
		Prestamo prestamoBuscado = null;
		int i = 0;
		while (prestamos.size() > i && prestamoBuscado == null) {
			if (prestamos.get(i).getIdLibro() == idLibro) {
				prestamoBuscado = prestamos.get(i);
			}
			i++;
		}		
		return prestamoBuscado;
	}
	
	public List<Multa> getMultas() {
		return multas;
	}

	public void setMultas(List<Multa> multas) {
		this.multas = multas;
	}

	public long getNroSocio() {
		return nroSocio;
	}

	public void setNroSocio(long nroSocio) {
		this.nroSocio = nroSocio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
