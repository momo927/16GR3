package com.qhit.sbm.common.service.Impl;

import java.util.List;

import com.qhit.sbm.account.dao.Impl.AccountDaoImpl;
import com.qhit.sbm.common.dao.CommonDao;
import com.qhit.sbm.common.dao.Impl.CommonDaoImpl;
import com.qhit.sbm.common.service.CommonService;

public class CommonServiceImpl implements CommonService {

	@Override
	public int getCount(String tableName, List<String> wheres, List<String> values) {
		CommonDao dao=new CommonDaoImpl();
		int row=dao.getCount(tableName, wheres, values);
		return row;
	}

}
