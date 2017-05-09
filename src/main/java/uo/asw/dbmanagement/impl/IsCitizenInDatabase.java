package uo.asw.dbmanagement.impl;

import uo.asw.citizensLoader.persistence.CitizenFinder;
import uo.asw.dbmanagement.model.Citizen;

public class IsCitizenInDatabase implements Command {

	private Citizen citizen;

	public IsCitizenInDatabase(Citizen citizen) {
		this.citizen = citizen;
	}

	public Object execute() {
		return CitizenFinder.isInDatabase(citizen);
	}
}
