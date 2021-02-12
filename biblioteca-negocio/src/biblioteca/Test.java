package biblioteca;
import java.util.Date;

public class Test {

	public static void main(String[] args) {

		Biblioteca bib = new Biblioteca();
		Libro principito = new Libro("Principito", tipoLibro.NOVELA, "Cabka", 1997, new Autor());
		
		bib.anadirLibro(principito);
		bib.anadirLibro(principito);
		bib.listarLibros();
//		System.out.println(bib.getHoy());
//		Date(int year, int month, int date
//		Date date1 = new Date(1998,03,05);
//		Date date2 = new Date();
//		
//		if (date1.after(date2)) {
//			System.out.println("Funca owo");
//		}
//		Date date1 = new Date(date2.getYear(),date2.getMonth() + 1,date2.getDate());
//		System.out.println(date1);
	}
	
}
