import java.util.Date;

public class Multa {
	private Date fInicio;
	private Date fFin;
	
	public Multa() {
		
	}

	public Multa(Date fInicio, Date fFin) {
		this.fInicio = fInicio;
		this.fFin = fFin;
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
	
	
	
	
}
