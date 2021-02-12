import java.util.Date;

public class Prestamo {
	
	private Date inicio;
	private Date fin;
	private long nroSocio;
	private long idLibro;
	
	public Prestamo() {
		
	}
	
	

	@SuppressWarnings("deprecation")
	public Prestamo(Date inicio,long nroSocio,long idLibro) {
		this.inicio = inicio;
		this.fin = new Date(inicio.getYear(),inicio.getMonth() + 1,inicio.getDate());
		this.nroSocio = nroSocio;
		this.idLibro = idLibro;
	}

	

	public long getIdLibro() {
		return idLibro;
	}



	public void setIdLibro(long idLibro) {
		this.idLibro = idLibro;
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



	public long getNroSocio() {
		return nroSocio;
	}



	public void setNroSocio(long nroSocio) {
		this.nroSocio = nroSocio;
	}
	
	
}
