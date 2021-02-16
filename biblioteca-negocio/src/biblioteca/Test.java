package biblioteca;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) throws ParseException {

		Biblioteca bib = new Biblioteca();
		Libro principito = new Libro("Principito", tipoLibro.NOVELA, "Cabka", 1997, new Autor());
		
		bib.anadirLibro(principito);
		bib.anadirLibro(principito);
		bib.listarLibros();
//		System.out.println(bib.getHoy());
//		Date(int year, int month, int date
//		SimpleDateFormat objSDF = new SimpleDateFormat("hh: mm: ss a dd-MMM-aaaa");
//		Date date2 = new Date();
//		Date date1 = new Date(1998,03,05);
//		System.out.println(date2.toString());
//		System.out.println(objSDF.format(date2));
		
//		
//		if (date1.after(date2)) {
//			System.out.println("Funca owo");
//		}
//		Date date1 = new Date(date2.getYear(),date2.getMonth() + 1,date2.getDate());
//		System.out.println(date1);
		

        SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy");
        String fecha1 = "20-08-1981";
        String fecha2 = "20-08-1999";
        String fecha3 = "15-02-2021";
        Date dt_1 = objSDF.parse(fecha1);
        Date dt_2 = objSDF.parse(fecha2);
        Date dt_3 = objSDF.parse(fecha3);
        long mil1 = dt_1.getTime();
        long mil2 = dt_2.getTime();
        long mil3 = dt_3.getTime();
        long resultado = (mil2-mil1) + mil3; 
        System.out.println(resultado);
        Date res = new Date(resultado);
        System.out.println(objSDF.format(res));
        System.out.println(objSDF.format(dt_1));
		
		
	}
	
}
