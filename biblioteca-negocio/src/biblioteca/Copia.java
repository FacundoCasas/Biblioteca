package biblioteca;

public class Copia extends Libro{

	private long id;
	private estadoCopia estado;
	private long libroId;

	public Copia(Libro libro, long id) {
		super(libro.getTitulo(), libro.getTipo(), libro.getEditioral(), libro.getAnio(), libro.getAutor());
		this.libroId = libro.getLibroId();
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

	public long getLibro() {
		return libroId;
	}

	public void setLibro(long libroId) {
		this.libroId = libroId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (libroId ^ (libroId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Copia other = (Copia) obj;
		if (libroId != other.libroId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Copia [id=" + id + ", estado=" + estado + ", libroId=" + libroId + ", Libro()=" + super.toString()
				+ "]";
	}


	

}
