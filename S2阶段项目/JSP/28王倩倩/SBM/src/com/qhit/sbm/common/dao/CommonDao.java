package com.qhit.sbm.common.dao;

import java.util.List;

public interface CommonDao {
			
	/**
	 * 
	 * @param tableName
	 * @param wheres
	 * @param value
	 * @return
	 * 
	 */
	public int getCount(String tableName ,List<String> wheres,List<String> value);
}
