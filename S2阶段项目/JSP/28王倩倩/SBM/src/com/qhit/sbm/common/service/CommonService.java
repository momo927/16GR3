package com.qhit.sbm.common.service;

import java.util.List;

public interface CommonService {
		/**
		 * 
		 * @param tableName
		 * @param wheres
		 * @param value
		 * @return
		 * 
		 */
		public int getCount(String tableName ,List<String> wheres,List<String> values);
}
