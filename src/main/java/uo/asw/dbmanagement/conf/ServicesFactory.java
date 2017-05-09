package uo.asw.dbmanagement.conf;

import uo.asw.dbmanagement.UpdateDB;
import uo.asw.dbmanagement.impl.UpdateDBimpl;

public class ServicesFactory {

	public static UpdateDB getCitizenService() {
		return new UpdateDBimpl();
	}
}
