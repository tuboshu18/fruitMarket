package njci.software.market.dao.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import njci.software.market.dao.OrdersDao;
import njci.software.market.domin.Goods;
import njci.software.market.domin.Orders;
import njci.software.market.domin.User;



public class OrdersDaoImpl extends HibernateDaoSupport implements OrdersDao{

	@Override
	public Map<String, Object> add(Integer uid, Integer pid, Integer num) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.clear();
		User user = this.getHibernateTemplate().get(User.class, uid);
		Goods goods = this.getHibernateTemplate().get(Goods.class, pid);
		if(null==user||null==goods){
			resultMap.put("code", 401);
			resultMap.put("msg", "发生错误");
			return resultMap;
		}else{
			Orders orders = new Orders();
			orders.setAddress(user.getAddress());
			orders.setDates(new Date());
			orders.setGoodsname(goods.getName());
			if(null!=user.getAddress()){
				orders.setName(user.getAddress().split(",")[0]);
			}
			
			orders.setNum(num);
			orders.setPid(pid);
			orders.setPrice(goods.getPrice());
			orders.setStatus("已支付");
			orders.setUid(uid);
			orders.setTotal(goods.getPrice()*num);
			
			this.getHibernateTemplate().save(orders);
			resultMap.put("code", 200);
			resultMap.put("msg", "添加成功");
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> select(String status, Integer uid) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.clear();
		String hql = "from Orders o where o.status = ? and o.uid = ?";
		List<Orders> ordersList = (List<Orders>) this.getHibernateTemplate().find(hql,status,uid);
		resultMap.put("code", 200);
		resultMap.put("msg", "ok");
		resultMap.put("data", ordersList);
		
		return 	resultMap;
	}

	@Override
	public Map<String, Object> del(Integer mid) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.clear();
		Orders orders = this.getHibernateTemplate().get(Orders.class, mid);
		if(null==orders){
			resultMap.put("code", 404);
			resultMap.put("msg", "没有数据");
		}else{
			orders.setStatus("已删除");
			this.getHibernateTemplate().update(orders);
			resultMap.put("code", 200);
			resultMap.put("msg", "ok");
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> received(Integer mid) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.clear();
		Orders orders = this.getHibernateTemplate().get(Orders.class, mid);
		if(null==orders){
			resultMap.put("code", 404);
			resultMap.put("msg", "没有数据");
		}else{
			orders.setStatus("已完成");
			this.getHibernateTemplate().update(orders);
			resultMap.put("code", 200);
			resultMap.put("msg", "ok");
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> getAll() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.clear();
		String hql = "from Orders o ";
		List<Orders> ordersList = (List<Orders>) this.getHibernateTemplate().find(hql);
		resultMap.put("code", 200);
		resultMap.put("msg", "成功获取！");
		resultMap.put("data", ordersList);
		return resultMap;
	}

	@Override
	public Map<String, Object> updateOrder(Integer mid, Integer status) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.clear();
		Orders orders = this.getHibernateTemplate().get(Orders.class, mid);
		if(status==0){
			orders.setStatus("已支付");
		}
		if(status==1){
			orders.setStatus("已发货");
		}
		if(status==2){
			orders.setStatus("已完成");
		}
		this.getHibernateTemplate().update(orders);
		resultMap.put("code", 200);
		resultMap.put("msg", "ok");
		return resultMap;
	}

}
