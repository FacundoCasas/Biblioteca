package biblioteca;
import java.util.List;


public class Libro {

	private String titulo;
	private tipoLibro tipo;
	private String editioral;
	private int anio;
	private Autor autor;
	private List<Copia> copias;
	private long id;

	public Libro(String titulo, tipoLibro tipo, String editioral, int anio, Autor autor) {
		this.titulo = titulo;
		this.tipo = tipo;
		this.editioral = editioral;
		this.anio = anio;
		this.autor = autor;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", tipo=" + tipo + ", editioral=" + editioral + ", anio=" + anio + ", autor="
				+ autor + ", copias=" + copias + ", id=" + id + "]";
	}
	
	
}
