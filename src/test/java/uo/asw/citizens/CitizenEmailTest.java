package uo.asw.citizens;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import uo.asw.citizensLoader.parser.Loader;
import uo.asw.citizensLoader.parser.emailWriter.TxtEmailWriter;
import uo.asw.dbmanagement.model.Citizen;

public class CitizenEmailTest {

	 @Test
	 public void sendEmailTest() throws IOException{
		 File file = new File("src/test/resources/emails.txt");
		 file.delete();
		 Loader loader = new Loader("excel", "src/test/resources/test.xlsx");
		 List<Citizen> citizens = loader.readCitizens(loader.getFormato(), loader.getFilePath());
		 List<String> email = new ArrayList<>();
		 for (Citizen citizen : citizens) {
			 loader.sendEmail(citizen, new TxtEmailWriter());
			 email.add(citizen.getEmail());
		 }
		 
		 
		 BufferedReader fichero = new BufferedReader(new FileReader("src/test/resources/emails.txt"));
		 String texto = "";
		 int emailEncontrados = 0;
		 while (fichero.ready()) {
				texto = fichero.readLine();
				for (String e : email) {
					if (texto.contains(e)) {
						emailEncontrados++;
						break;
					}
				}
		 }
		 fichero.close();
		 
		 //Email x 2 se repite dos veces en el mensaje
		 assertEquals(emailEncontrados, email.size() * 2);
		 
	 }
}
