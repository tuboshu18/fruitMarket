package njci.software.market.dao.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import njci.software.market.dao.CarsDao;
import njci.software.market.domin.Cars;
import njci.software.market.domin.Goods;
import njci.software.market.domin.Orders;
import njci.software.market.domin.User;

public class CarsDaoImpl extends HibernateDaoSupport implements CarsDao{

	@Override
	public Map<String, Object> add(Integer num, Integer pid, Integer uid) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.clear();
		Cars cars = new Cars();
		cars.setAddtime(new Date());
		cars.setNum(num);
		cars.setPid(pid);
		cars.setUid(uid);
		Goods goods = this.getHibernateTemplate().get(Goods.class, pid);
		User user = this.getHibernateTemplate().get(User.class, uid);
		if(null==goods||null==user){
			result.put("code", 404);
			result.put("msg", "商品或用户不存在");
		}else {
			cars.setAddtime(new Date());
			cars.setImg(goods.getPic1());
			cars.setName(goods.getName());
			cars.setPrice(goods.getPrice());
			this.getHibernateTemplate().save(cars);
			result.put("code", 200);
			result.put("msg", "添加成功！");
		}
		this.getHibernateTemplate().save(cars);
		result.put("code", 200);
		result.put("msg", "添加成功！");
		return result;
	}

	@Override
	public Map<String, Object> remove(Integer mid) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.clear();
		Cars cars = this.getHibernateTemplate().get(Cars.class, mid);
		if(null==cars){
			result.put("code", 401);
			result.put("msg", "没有找到加入购物车的商品");
			
		}else{
			this.getHibernateTemplate().delete(cars);
			result.put("code", 200);
			result.put("msg", "去除成功");
		}
		return result;
	}

	@Override
	public Map<String, Object> listByUid(Integer uid) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.clear();
		if(null==uid){
			result.put("code", 405);
			result.put("msg", "参数传递错误");
			result.put("data", null);
			return result;
		}
		String hql = "from Cars cars where cars.uid = ?";
		List<Cars> list = (List<Cars>) this.getHibernateTemplate().find(hql, uid);
		if(list.isEmpty()){
			result.put("code", 401);
			result.put("msg", "没有数据");
			result.put("data", null);
		}else{
			result.put("code", 200);
			result.put("msg", "ok");
			result.put("data", list);
		}
		return result;
	}

}
