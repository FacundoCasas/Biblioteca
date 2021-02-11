
public class Test {

	public static void main(String[] args) {

		Bibilioteca bib = new Bibilioteca();
		Libro principito = new Libro("Principito", tipoLibro.NOVELA, "Cabka", 1997, new Autor());
		
		bib.anadirLibro(principito);
		bib.anadirLibro(principito);
		bib.listarLibros();
		
		
	}

}
