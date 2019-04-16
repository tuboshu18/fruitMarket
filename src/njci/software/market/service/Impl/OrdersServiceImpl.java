package njci.software.market.service.Impl;

import java.util.Map;

import njci.software.market.dao.OrdersDao;
import njci.software.market.service.OrdersService;

public class OrdersServiceImpl implements OrdersService{
	private OrdersDao ordersDao;

	public OrdersDao getOrdersDao() {
		return ordersDao;
	}

	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}

	@Override
	public Map<String, Object> add(Integer uid, Integer pid, Integer num) {
		// TODO Auto-generated method stub
		return ordersDao.add(uid,pid,num);
	}

	@Override
	public Map<String, Object> select(String status, Integer uid) {
		// TODO Auto-generated method stub
		return ordersDao.select(status,uid);
	}

	@Override
	public Map<String, Object> del(Integer mid) {
		// TODO Auto-generated method stub
		return ordersDao.del(mid);
	}

	@Override
	public Map<String, Object> received(Integer mid) {
		// TODO Auto-generated method stub
		return ordersDao.received(mid);
	}

	@Override
	public Map<String, Object> getAll() {
		// TODO Auto-generated method stub
		return ordersDao.getAll();
	}

	@Override
	public Map<String, Object> updateOrder(Integer mid, Integer status) {
		// TODO Auto-generated method stub
		return ordersDao.updateOrder(mid,status);
	}
	
}
