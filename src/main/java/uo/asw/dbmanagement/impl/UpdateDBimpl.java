package uo.asw.dbmanagement.impl;

import java.util.List;

import uo.asw.dbmanagement.UpdateDB;
import uo.asw.dbmanagement.model.Citizen;
import uo.asw.dbmanagement.model.exception.BusinessException;


public class UpdateDBimpl implements UpdateDB {

	private CommandExecutor executor = new CommandExecutor();
	
	@Override
	public void insertCitizen(Citizen citizen) throws BusinessException {
		executor.execute(new AddCitizen( citizen ));
	}
	
	@Override
	public boolean isCitizenInDatabase(Citizen citizen) throws BusinessException {
		return (Boolean)executor.execute(new IsCitizenInDatabase( citizen ));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Citizen> findAllCitizens() throws BusinessException {
		return (List<Citizen>) executor.execute(new FindAllCitizens());
	}

	@Override
	public void deleteAllCitizens(List<Citizen> citizens) throws BusinessException {
		executor.execute(new DeleteAllCitizens(citizens));
	}
}
