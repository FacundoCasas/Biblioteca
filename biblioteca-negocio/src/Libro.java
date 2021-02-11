import java.util.List;

public class Libro {

	private String titulo;
	private tipoLibro tipo;
	private String editioral;
	private int anio;
	private Autor autor;
	private List<Copia> copias;
	private long id;

	public Libro() {

	}

	public Libro(String titulo, tipoLibro tipo, String editioral, int anio, Autor autor) {
//		for (Copia copia : copias) {
//			if (copia.getTitulo() != titulo) {
//				this.titulo = titulo;
//				this.tipo = tipo;
//				this.editioral = editioral;
//				this.anio = anio;
//				this.autor = autor;
//				break;
//			} else {
//				System.out.println("Ese libro ya existe se genero una copia");
//			}
//
//		}
		this.titulo = titulo;
		this.tipo = tipo;
		this.editioral = editioral;
		this.anio = anio;
		this.autor = autor;
		this.id = generatorId();
	}

	private long generatorId() {
		
		return 1;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public tipoLibro getTipo() {
		return tipo;
	}

	public void setTipo(tipoLibro tipo) {
		this.tipo = tipo;
	}

	public String getEditioral() {
		return editioral;
	}

	public void setEditioral(String editioral) {
		this.editioral = editioral;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List<Copia> getCopias() {
		return copias;
	}

	public void setCopias(List<Copia> copias) {
		this.copias = copias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anio;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((copias == null) ? 0 : copias.hashCode());
		result = prime * result + ((editioral == null) ? 0 : editioral.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (anio != other.anio)
			return false;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (copias == null) {
			if (other.copias != null)
				return false;
		} else if (!copias.equals(other.copias))
			return false;
		if (editioral == null) {
			if (other.editioral != null)
				return false;
		} else if (!editioral.equals(other.editioral))
			return false;
		if (tipo != other.tipo)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}


	
}
