package program;

import datamodels.Libro;
import services.CatalogElementoDAO;

public class BiblioCatalogoProgram {
	
public static void main(String[] args) {
		
		
	
		Libro item1 = new Libro("122", "Amazing Places", 1996, 430, "Tim Lovejoy", "Action");
		
		CatalogElementoDAO.inserisciLibro(item1);
		
		
}
}
