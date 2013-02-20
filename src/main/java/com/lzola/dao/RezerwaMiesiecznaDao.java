package com.lzola.dao;

import java.util.List;

import org.synyx.hades.dao.GenericDao;

import com.lzola.domain.RezerwaMiesieczna;

public interface RezerwaMiesiecznaDao /*extends GenericDao<RezerwaMiesieczna, String>*/{

	List<RezerwaMiesieczna> findByNumerSzkody(String numerSzkody);
	
}
