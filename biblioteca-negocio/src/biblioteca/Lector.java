package biblioteca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lector {
	//cambiar multas a multa
	// crear un cpnstructor entero
	private long nroSocio;
	private String nombre;
	private String telefono;
	private String direccion;
	private List<Prestamo> prestamos;
	private List<Multa> multas;
	static private Date hoy = new Date();
	
	public Lector(){
		this.nroSocio = 0;
		prestamos = new ArrayList<Prestamo>();
		multas = new ArrayList<Multa>();
	}
	
	public boolean NoPuedePedir(){
		multasVencidas();
		if (multas.size() > 0 || prestamos.size() >= 3) {
			return true;
		}else {
			return false;
		}		
	}
	
	// creo que no  se  puede sacar una multa  si se recorre con un forEach
	private void multasVencidas() {
		for (Multa multa : multas) {
			if (multa.getfFin().before(hoy)) {
				multas.remove(multa);
				System.out.println("Se desmulto :" + multa.toString());
			}else {
				System.out.println("No se pudo desmultar");
			}
		}		
	}

	
	public Boolean buscarPrestamo(Copia copia) {
		boolean posee = false;
		if (prestamos.size() == 0) {
			System.out.println(nombre + " no posee Libros");
		} else {
			int i = 0;
			while (prestamos.size() > i && posee == false) {
				if (prestamos.get(i).getCopia() == copia) {
					posee = true;
					System.out.println("Se devolvio La copia:" + prestamos.get(i).getCopia().toString());
					prestamos.remove(prestamos.get(i));					
				}
				i++;
			}
		}
		return posee;
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
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
