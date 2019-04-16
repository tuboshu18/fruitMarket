package njci.software.market.service.Impl;

import java.util.Map;

import njci.software.market.dao.GoodsDao;
import njci.software.market.service.GoodsService;

public class GoodsServiceImpl implements GoodsService{
	private GoodsDao goodsDao;

	public GoodsDao getGoodsDao() {
		return goodsDao;
	}

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	@Override
	public Map<String, Object> ins(String name, Double price, String type, String pic1, String pic2, Integer num) {
		
		return goodsDao.ins(name,price,type,pic1,pic2,num);
	}

	@Override
	public Map<String, Object> udp(Integer mid, String name, Double price, String type, String pic1, String pic2,
			Integer num) {
		return goodsDao.udp(mid,name,price,type,pic1,pic2,num);
	}

	@Override
	public Map<String, Object> del(Integer mid) {
		// TODO Auto-generated method stub
		return goodsDao.del(mid);
	}

	@Override
	public Map<String, Object> getAll() {
		// TODO Auto-generated method stub
		return goodsDao.getAll();
	}

	@Override
	public Map<String, Object> orderByTime() {
		// TODO Auto-generated method stub
		return goodsDao.orderByTime();
	}

	@Override
	public Map<String, Object> orderByPrice() {
		// TODO Auto-generated method stub
		return goodsDao.orderByPrice();
	}

	@Override
	public Map<String, Object> orderByTotol() {
		// TODO Auto-generated method stub
		return goodsDao.orderByTotol();
	}

	@Override
	public Map<String, Object> searchBytype(String type) {
		// TODO Auto-generated method stub
		return goodsDao.searchBytype(type);
	}

	@Override
	public Map<String, Object> todayGroupBuy() {
		// TODO Auto-generated method stub
		return goodsDao.todayGroupBuy();
	}

	@Override
	public Map<String, Object> tomorrowGroupBuy() {
		// TODO Auto-generated method stub
		return goodsDao.tomorrowGroupBuy();
	}

	@Override
	public Map<String, Object> topThree() {
		// TODO Auto-generated method stub
		return goodsDao.topThree();
	}

	@Override
	public Map<String, Object> getBymid(Integer mid) {
		// TODO Auto-generated method stub
		return goodsDao.getBymid(mid);
	}

	@Override
	public Map<String, Object> selectByType(String type) {
		// TODO Auto-generated method stub
		return goodsDao.selectByType(type);
	}
	
	
}
