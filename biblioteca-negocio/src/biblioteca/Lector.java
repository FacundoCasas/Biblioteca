package biblioteca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import excepciones.NoPuedePedir;
import excepciones.NoTieneLaCopia;
import excepciones.PrestamoNoVencido;

public class Lector {

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
	
	
	
	public Lector(long nroSocio, String nombre, String telefono, String direccion) {
		this.nroSocio = nroSocio;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		multas = new ArrayList<Multa>();
		prestamos = new ArrayList<Prestamo>();
	}


	public void listarPrestamos() {
		for (Prestamo prestamo : prestamos) {
			System.out.println(prestamo.toString());
		}
	}
	
	public void listarMultas() {
		for (Multa multa : multas) {
			System.out.println(multa.toString());
		}
	}
	
	public boolean NoPuedePedir () throws NoPuedePedir{
		boolean puede = false;
		if (multas.size() != 0) {
			multasVencidas();
		}		
		if (prestamos.size() >= 3) {
			puede =  true;
			throw new NoPuedePedir("Ya posee su maximo de Prestamos");
		}else if (multas.size() > 0) {
			puede =  true;
			throw new NoPuedePedir("Posee una Multa");
		}
		return puede;
	}
	
	private void multasVencidas() {
		if (multas.size() == 1) {
			if (multas.get(0).getfFin().before(hoy)) {
				System.out.println("Se desmulto :" + this.multas.remove(0).toString());
			}		
		}
		List<Multa> multasVencidas = new ArrayList<Multa>();
			for (Multa multa : this.multas) {
				if (multa.getfFin().before(hoy)) {
					multasVencidas.add(multa);					
				}
			}
			for (Multa multa : multasVencidas) {
				if (multa.equals(this.multas.get(0))) {
					System.out.println("Se desmulto :" + this.multas.remove(0).toString());			
				}
			}
			
		}

	
	public Boolean buscarPrestamo(Copia copia) throws NoTieneLaCopia{
		boolean posee = false;
		if (prestamos.size() == 0) {
			throw new NoTieneLaCopia(nombre + " no posee Copias");
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
	
	public boolean actualizarMulta(Prestamo prestamo) throws PrestamoNoVencido {
		boolean existe = false;
		int i = 0;
		while (multas.size() > i &&   existe == false) {
			if (multas.get(i).getPrestamo().equals(prestamo)) {
				multas.set(i, new Multa(multas.get(i).getLector(),prestamo));
				existe = true;
			}
		i++;	
		}
		
		return existe;
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



	@Override
	public String toString() {
		return "Lector [nroSocio=" + nroSocio + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion="
				+ direccion + ", prestamos=" + prestamos + ", multas=" + multas + "]";
	}
	
	
}
