
public class Copia {

	private long id;
	private estadoCopia estado;
	private Libro libro;
	
	public Copia(Libro libro) {
		this.libro = libro;
		this.estado = estadoCopia.BIBLIOTECA;		
	}

	public Copia(Libro libro,long id) {
		this.libro = libro;
		this.estado = estadoCopia.BIBLIOTECA;	
		this.id = id;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public estadoCopia getEstado() {
		return estado;
	}


	public void setEstado(estadoCopia estado) {
		this.estado = estado;
	}


	public Libro getLibro() {
		return libro;
	}


	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	
	
	
}
