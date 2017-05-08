package uo.asw.citizens;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

import uo.asw.citizensLoader.model.exception.BusinessException;
import uo.asw.citizensLoader.parser.Loader;
import uo.asw.dbmanagement.model.Citizen;



public class CitizensLoaderTest {

    @Test
    public void testLoadFromTxt() throws IOException, BusinessException {
    	
    	Loader loader = new Loader("texto", "src/test/resources/test.txt");
		List<Citizen> citizens = loader.readCitizens(loader.getFormato(), loader.getFilePath());
		assertEquals(7, citizens.size());
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Citizen pablo = citizens.get(0);
		assertEquals(pablo.getName(), "Pablo");
		assertEquals(pablo.getSurname(), "Alonso Gil");
		assertEquals(pablo.getEmail(), "pablo@example.com");
		String fechaNacimientoPablo = dateFormat.format(pablo.getBornDate());
		assertEquals(fechaNacimientoPablo, "10/10/1985");
		assertEquals(pablo.getPostAddress(), "Calle Mayor 2");
		assertEquals(pablo.getNationality(), "Noruega");
		assertEquals(pablo.getDni(), "90500094Y");
		assertEquals(pablo.getUserName(), "pablo@example.com");
		assertEquals(pablo.getPassword(), "Pablo123");
		
		Citizen eva = citizens.get(5);
		assertEquals(eva.getName(), "Eva");
		assertEquals(eva.getSurname(), "Belmonte Blanco");
		assertEquals(eva.getEmail(), "eva@example.com");
		String fechaNacimientoEva = dateFormat.format(eva.getBornDate());
		assertEquals(fechaNacimientoEva, "02/05/1960");
		assertEquals(eva.getPostAddress(), "Avenida del sur 5");
		assertEquals(eva.getNationality(), "Italiana");
		assertEquals(eva.getDni(), "59120962S");
		assertEquals(eva.getUserName(), "eva@example.com");
		assertEquals(eva.getPassword(), "Eva123");
    }
    
    
    @Test
    public void testLoadFromExcel() throws IOException, BusinessException {
		Loader loader = new Loader("excel", "src/test/resources/test.xlsx");
		List<Citizen> citizens = loader.readCitizens(loader.getFormato(), loader.getFilePath());
		assertEquals(3, citizens.size());
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Citizen juan = citizens.get(0);
		assertEquals(juan.getName(), "Juan");
		assertEquals(juan.getSurname(), "Torres Pardo");
		assertEquals(juan.getEmail(), "juan@example.com");
		String fechaNacimientoJuan = dateFormat.format(juan.getBornDate());
		assertEquals(fechaNacimientoJuan, "10/10/1985");
		assertEquals(juan.getPostAddress(), "C/ Federico García Lorca 2");
		assertEquals(juan.getNationality(), "Español");
		assertEquals(juan.getDni(), "90500084Y");
		assertEquals(juan.getUserName(), "juan@example.com");
		assertEquals(juan.getPassword(), "Juan123");
		
		Citizen ana = citizens.get(2);
		assertEquals(ana.getName(), "Ana");
		assertEquals(ana.getSurname(), "Torres Pardo");
		assertEquals(ana.getEmail(), "ana@example.com");
		String fechaNacimientoAna = dateFormat.format(ana.getBornDate());
		assertEquals(fechaNacimientoAna, "01/01/1960");
		assertEquals(ana.getPostAddress(), "Av. De la Constitución 8");
		assertEquals(ana.getNationality(), "Español");
		assertEquals(ana.getDni(), "09940449X");
		assertEquals(ana.getUserName(), "ana@example.com");
		assertEquals(ana.getPassword(), "Ana123");
    }
   
}
