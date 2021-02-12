package biblioteca;
import java.util.Date;

public class Prestamo {
	
	private Date inicio;
	private Date fin;
	private Lector lector;
	private Copia copia;
	
	public Prestamo() {
		
	}

	@SuppressWarnings("deprecation")
	public Prestamo(Date inicio, Lector lector, Copia copia) {
		this.inicio = inicio;
		this.fin = new Date(inicio.getYear(),inicio.getMonth() + 1,inicio.getDate());
		this.lector = lector;
		this.copia = copia;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}

	public Copia getCopia() {
		return copia;
	}

	public void setCopia(Copia copia) {
		this.copia = copia;
	}

	


	
}
