package uo.asw.dbmanagement.impl;

import java.util.List;

import uo.asw.citizensLoader.persistence.CitizenFinder;
import uo.asw.dbmanagement.model.Citizen;



public class FindAllCitizens implements Command {
	
	public List<Citizen> execute() {
		return CitizenFinder.findAll();	
	}
}
