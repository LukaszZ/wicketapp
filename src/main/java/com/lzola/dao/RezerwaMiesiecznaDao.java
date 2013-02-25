package com.lzola.dao;

import java.util.List;

import org.synyx.hades.dao.GenericDao;
import org.synyx.hades.dao.Param;
import org.synyx.hades.dao.Query;

import com.lzola.domain.RezerwaMiesieczna;
import com.lzola.domain.RezerwaMiesiecznaKey;

public interface RezerwaMiesiecznaDao extends GenericDao<RezerwaMiesieczna, RezerwaMiesiecznaKey>{

	@Query("FROM RezerwaMiesieczna r WHERE r.key.numerSzkody = :numerSzkody")
	List<RezerwaMiesieczna> findByNumerSzkody(@Param("numerSzkody") String numerSzkody);
	
}
