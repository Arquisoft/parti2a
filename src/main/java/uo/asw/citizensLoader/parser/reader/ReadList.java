package uo.asw.citizensLoader.parser.reader;

import java.io.IOException;
import java.util.List;

import uo.asw.dbmanagement.model.Citizen;



public interface ReadList {

	List<Citizen> readList(String filePath) throws IOException;

}
