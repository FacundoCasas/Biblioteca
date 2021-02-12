import java.util.Date;

public class Multa {
	private Date fInicio;
	private Date fFin;
	
	public Multa() {
		
	}

	@SuppressWarnings("deprecation")
	public Multa(Date fInicio) {
		this.fInicio = fInicio;
		this.fFin = new Date(fInicio.getYear(),fInicio.getMonth(),fInicio.getDate() + 2);
	}
//	Date(int year, int month, int date

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

	@Override
	public String toString() {
		return "Multa [fInicio=" + fInicio + ", fFin=" + fFin + "]";
	}
	
	
	
	
}
