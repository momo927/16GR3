package com.qhit.sbm.goods.dao;

import com.qhit.sbm.goods.bean.Goods;

public interface GoodsDao {
     
	  /**
	   * 
	   * @param goodsName
	   * @return
	   * 根据商品名称查询商品信息
	   */
	  public Goods getGoodsInfoByName(String goodsName); 
	  
	  /**
	   * 
	   * @param num
	   * @param goodsId
	   * @return
	   * 
	   * 更新库存
	   */
	  public int updateStore(int num, int goodsId);
	
}
