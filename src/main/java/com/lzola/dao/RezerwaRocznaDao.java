package com.lzola.dao;

import java.util.List;

import org.synyx.hades.dao.GenericDao;
import org.synyx.hades.dao.Param;
import org.synyx.hades.dao.Query;

import com.lzola.domain.RezerwaRoczna;
import com.lzola.domain.RezerwaRocznaKey;

public interface RezerwaRocznaDao extends GenericDao<RezerwaRoczna, RezerwaRocznaKey>{

	@Query("FROM RezerwaRoczna r WHERE r.key.numerSzkody = :numerSzkody")
	List<RezerwaRoczna> findByNumerSzkody(@Param("numerSzkody") String numerSzkody);
	
	@Query("SELECT COUNT(r) FROM RezerwaRoczna r WHERE r.key.numerSzkody = :numerSzkody")
	Long countByNumerSzkody(@Param("numerSzkody") String numerSzkody);
}
