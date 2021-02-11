import java.util.Date;

public class Prestamo {
	
	private Date Inicio;
	private Date fin;
	
	public Prestamo() {
		
	}
	
	

	public Prestamo(Date inicio, Date fin) {
		Inicio = inicio;
		this.fin = fin;
	}



	public Date getInicio() {
		return Inicio;
	}

	public void setInicio(Date inicio) {
		Inicio = inicio;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}
	
}
