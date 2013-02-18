package com.lzola.dao;

import org.synyx.hades.dao.GenericDao;

import com.lzola.domain.RezerwaMiesieczna;

public interface RezerwaMiesiecznaDao extends GenericDao<RezerwaMiesieczna, String>{

	RezerwaMiesieczna findByNumerSzkody(String numerSzkody);
	
}
