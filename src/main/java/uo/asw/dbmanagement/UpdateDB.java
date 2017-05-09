package uo.asw.dbmanagement;

import java.util.List;

import uo.asw.dbmanagement.model.Citizen;
import uo.asw.dbmanagement.model.exception.BusinessException;


public interface UpdateDB {

	void insertCitizen(Citizen citizen) throws BusinessException;

	boolean isCitizenInDatabase(Citizen citizen) throws BusinessException;
	
	List<Citizen> findAllCitizens() throws BusinessException;

	void deleteAllCitizens(List<Citizen> citizens) throws BusinessException;
	
}
