package biblioteca;
import java.util.Date;

public class Multa {
	private Date fInicio;
	private Date fFin;
	private Lector lector;
	private Prestamo prestamo;
	

	@SuppressWarnings("deprecation")
	public Multa(Lector lector,Prestamo prestamo) {
		this.fInicio = prestamo.getFin();
		this.fFin = new Date(fInicio.getYear(),fInicio.getMonth(),fInicio.getDate() + 2);
		this.lector = lector;
		this.prestamo = prestamo;
	}


	public Date getfInicio() {
		return fInicio;
	}

	public void setfInicio(Date fInicio) {
		this.fInicio = fInicio;
	}

	public Date getfFin() {
		return fFin;
	}

	public void setfFin(Date fFin) {
		this.fFin = fFin;
	}
	
	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}
	
	
	public Prestamo getPrestamo() {
		return prestamo;
	}


	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}


	@Override
	public String toString() {
		return "Multa [fInicio=" + fInicio + ", fFin=" + fFin + ", lector=" + lector + ", prestamo=" + prestamo + "]";
	}


	
	
}
