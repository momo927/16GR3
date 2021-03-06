package com.qhit.sbm.account.service;

import java.util.List;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.goods.bean.Goods;

public interface AccountService {
	/**
	 * @param pageBean
	 * @return
	 * 分页的业务
	 */
	public PageBean getPageBean(PageBean pageBean);
	
	
	/**
	 * @param goods
	 * @param businessNum
	 * @param providerId
	 * @param isPayed
	 * @return
	 * 添加账单
	 */
	public int addAccount(Goods goods, int businessNum, int providerId, int isPayed);
	
	

	/**
	 * @param accountId
	 * @return
	 * 删除
	 */
	public int deleteAccountById(int accountId);
	
	
	/**
	 * @param accountId
	 * @param providerId
	 * @param isPayed
	 * @return
	 * 更新
	 */
	public int upDateAccountById(int accountId, int providerId, int isPayed);

	/**
	 * @param wheres
	 * @param values
	 * @return
	 * 根据参数查询
	 */
	public PageBean gatPageBeanByParam(List<String> wheres, List<String> values);


	
	
}