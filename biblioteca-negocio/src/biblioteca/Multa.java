package biblioteca;
import java.util.Date;

public class Multa {
	private Date fInicio;
	private Date fFin;
	private Lector lector;
	
	public Multa() {
		
	}

	@SuppressWarnings("deprecation")
	public Multa(Date fInicio,Lector lector) {
		this.fInicio = fInicio;
		this.fFin = new Date(fInicio.getYear(),fInicio.getMonth(),fInicio.getDate() + 2);
		this.setLector(lector);
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
	
	@Override
	public String toString() {
		return "Multa [fInicio=" + fInicio + ", fFin=" + fFin + "]";
	}
	
}
