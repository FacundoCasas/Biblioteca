package biblioteca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import excepciones.NoPuedePedir;
import excepciones.NoTieneLaCopia;

public class Lector {

	private long nroSocio;
	private String nombre;
	private String telefono;
	private String direccion;
	private List<Prestamo> prestamos;
	private List<Multa> multas;
	static private Date hoy = new Date();

	public Lector() {
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

	public boolean NoPuedePedir() throws NoPuedePedir {
		boolean puede = false;
		if (multasActivas()) {
			throw new NoPuedePedir("Posee una Multa");
		} else if (prestamos.size() >= 3) {
			puede = true;
			throw new NoPuedePedir("Ya posee su maximo de Prestamos");
		}
		return puede;
	}

	private boolean multasActivas() {
		boolean activa = true;
		if (multas.size() == 0) {
			activa = false;
		} else if (multas.size() == 1) {
			if (multas.get(0).getfFin().before(hoy)) {
				System.out.println("Se desmulto :" + this.multas.remove(0).toString());
				activa = false;
			}
		} else {
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
			if (multas.size() == 0) {
				activa = false;
			}
		}
		return activa;
	}

	public Prestamo buscarPrestamo(Copia copia) throws NoTieneLaCopia {
		Prestamo prestamoBuscado = null;
		if (prestamos.size() == 0) {
			throw new NoTieneLaCopia(nombre + " no tiene un prestamo con la Copia");
		} else {
			int i = 0;
			while (prestamos.size() > i && prestamoBuscado == null) {
				if (prestamos.get(i).getCopia().equals(copia)) {
					prestamoBuscado = prestamos.get(i);
					System.out.println("Se devolvio La copia:" + prestamos.get(i).getCopia().toString());
					prestamos.remove(prestamos.get(i));
				}
				i++;
			}
		}
		return prestamoBuscado;
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
