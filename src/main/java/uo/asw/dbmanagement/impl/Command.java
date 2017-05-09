package uo.asw.dbmanagement.impl;

import uo.asw.dbmanagement.model.exception.BusinessException;

public interface Command {
	Object execute() throws BusinessException;
}
