package com.qhit.sbm.goods.service.Impl;

import com.qhit.sbm.goods.bean.Goods;
import com.qhit.sbm.goods.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {

	@Override
	public Goods getGoodsInfoByName(String goodsName) {
		
		return new GoodsServiceImpl().getGoodsInfoByName(goodsName);
	}

	@Override
	public int updateStore(int num, int goodsId) {
		// TODO Auto-generated method stub
		return new GoodsServiceImpl().updateStore(num, goodsId);
	}

}
