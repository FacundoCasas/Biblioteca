import java.util.Random;

public class Copia {

	private long id;
	private estadoCopia estado;
	private Libro libro;
	private static Random numAletorio = new Random();
	
	public Copia(Libro libro) {
		this.libro = libro;
		this.estado = estadoCopia.BIBLIOTECA;
		this.id = generatorId();
		
	}


	private long generatorId() {
		long n = numAletorio.nextInt(100-10+1) + 25;
		return n;
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
