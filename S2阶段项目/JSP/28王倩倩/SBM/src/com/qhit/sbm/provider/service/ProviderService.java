package com.qhit.sbm.provider.service;

import java.util.List;

import com.qhit.sbm.provider.bean.Provider;

public interface ProviderService {
			
	/**
	 * 
	 * @return
	 * 查询全部供应商
	 */
	 public List<Provider> getAllProvider();
}
