package njci.software.market.dao.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import njci.software.market.dao.GoodsDao;
import njci.software.market.domin.Goods;

public class GoodsDaoImpl extends HibernateDaoSupport implements GoodsDao {

	@Override
	public Map<String, Object> ins(String name, Double price, String type, String pic1, String pic2, Integer num) {
		Goods goods = new Goods();
		goods.setName(name);
		goods.setPic1(pic1);
		goods.setPic2(pic2);
		goods.setPrice(price);
		goods.setNum(num);
		goods.setType(type);
		this.getHibernateTemplate().save(goods);
		Map<String, Object> result = new HashMap<String, Object>();
		result.clear();
		result.put("200", "添加成功！");
		return result;
	}

	@Override
	public Map<String, Object> udp(Integer mid, String name, Double price, String type, String pic1, String pic2,
			Integer num) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.clear();
		Goods goods = this.getHibernateTemplate().get(Goods.class, mid);
		if (null == goods) {
			result.put("401", "商品不存在");
		} else {
			goods.setName(name);
			goods.setPic1(pic1);
			goods.setPic2(pic2);
			goods.setPrice(price);
			goods.setNum(num);
			goods.setType(type);
			this.getHibernateTemplate().update(goods);
			result.put("200", "修改成功！");
		}

		return result;
	}

	@Override
	public Map<String, Object> del(Integer mid) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.clear();
		Goods goods = this.getHibernateTemplate().get(Goods.class, mid);
		if (null == goods) {
			result.put("code", 401);
			result.put("msg", "商品不存在");
		} else {
			this.getHibernateTemplate().delete(goods);
			result.put("code", 200);
			result.put("msg", "删除成功");
		}
		return result;
	}

	@Override
	public Map<String, Object> getAll() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.clear();
		String hql = "from Goods goods";
		List<Goods> list = (List<Goods>) this.getHibernateTemplate().find(hql);
		result.put("code", 200);
		result.put("msg", list);
		return result;
	}

	@Override
	public Map<String, Object> orderByTime() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.clear();
		String hql = "from Goods goods order by dates asc"; // 升序
		List<Goods> list = (List<Goods>) this.getHibernateTemplate().find(hql);
		result.put("listTime", list);
		return result;
	}

	@Override
	public Map<String, Object> orderByPrice() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.clear();
		String hql = "from Goods goods order by price asc"; // 升序
		List<Goods> list = (List<Goods>) this.getHibernateTemplate().find(hql);
		result.put("listPrice", list);
		return result;
	}

	@Override
	public Map<String, Object> orderByTotol() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.clear();
		String hql = "from Goods goods order by total asc"; // 升序
		List<Goods> list = (List<Goods>) this.getHibernateTemplate().find(hql);
		result.put("code", 200);
		result.put("data", list);
		return result;
	}

	@Override
	public Map<String, Object> searchBytype(String type) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.clear();
		String hql = "";
		List<Goods> list = (List<Goods>) this.getHibernateTemplate().find(hql);
		result.put("code", 200);
		result.put("data", list);
		return result;
	}

	@Override
	public Map<String, Object> todayGroupBuy() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.clear();
		String hql = "from Goods goods";
		List<Goods> list = (List<Goods>) this.getHibernateTemplate().find(hql);
		List<Goods> todayGroup = new ArrayList<>();
		if(list.isEmpty()){
			result.put("code", 404);
			result.put("msg", "没有数据");
			return result;
		}else{
			//lis不为空
			if (list.size() < 10) {
				todayGroup = list;
			} else {
				todayGroup.add(list.get(0));
				todayGroup.add(list.get(1));
				todayGroup.add(list.get(2));
				todayGroup.add(list.get(3));
				todayGroup.add(list.get(4));
				todayGroup.add(list.get(5));
				todayGroup.add(list.get(6));
				todayGroup.add(list.get(7));
				todayGroup.add(list.get(8));
				todayGroup.add(list.get(9));
			}
			//对list按规则进行再次排序，取前三个
			Collections.sort(list, new Comparator<Goods>() {

				@Override
				public int compare(Goods o1, Goods o2) {
					if (o1.getTotal() > o2.getTotal()) {
						return -1;
					} else {
						return 1;
					}
				}

			});
			
			List<Goods> topThree = new ArrayList<>();
			if(list.size()<3){
				topThree = list;
			}else{
				list.get(0).setOperateid(1);;
				list.get(1).setOperateid(2);
				list.get(2).setOperateid(3);
				topThree.add(list.get(0));
				topThree.add(list.get(1));
				topThree.add(list.get(2));
			}
			
			result.put("code", 200);
			result.put("topThree", topThree);
			result.put("todayGroup", todayGroup);
		}
		
		
		return result;
	}

	@Override
	public Map<String, Object> tomorrowGroupBuy() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.clear();
		String hql = "from Goods goods";
		List<Goods> list = (List<Goods>) this.getHibernateTemplate().find(hql);
		List<Goods> todayGroup = new ArrayList<>();
		if(list.isEmpty()){
			result.put("code", 404);
			result.put("msg", "没有数据");
			return result;
		}else{
			//lis不为空
			if (list.size() < 10) {
				todayGroup = list;
			} else {
				todayGroup.add(list.get(list.size()-10));
				todayGroup.add(list.get(list.size()-9));
				todayGroup.add(list.get(list.size()-8));
				todayGroup.add(list.get(list.size()-7));
				todayGroup.add(list.get(list.size()-6));
				todayGroup.add(list.get(list.size()-5));
				todayGroup.add(list.get(list.size()-4));
				todayGroup.add(list.get(list.size()-3));
				todayGroup.add(list.get(list.size()-2));
				todayGroup.add(list.get(list.size()-1));
			}
			//对list按规则进行再次排序，取前三个
			Collections.sort(list, new Comparator<Goods>() {

				@Override
				public int compare(Goods o1, Goods o2) {
					if (o1.getTotal() > o2.getTotal()) {
						return -1;
					} else {
						return 1;
					}
				}

			});
			
			List<Goods> topThree = new ArrayList<>();
			if(list.size()<3){
				topThree = list;
			}else{
				list.get(0).setOperateid(1);;
				list.get(1).setOperateid(2);
				list.get(2).setOperateid(3);
				topThree.add(list.get(0));
				topThree.add(list.get(1));
				topThree.add(list.get(2));
			}
			
			result.put("code", 200);
			result.put("topThree", topThree);
			result.put("todayGroup", todayGroup);
		}
		
		
		return result;
	}

	@Override
	public Map<String, Object> topThree() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.clear();
		String hql = "from Goods goods";
		List<Goods> randGroup = (List<Goods>) this.getHibernateTemplate().find(hql);
		if(randGroup.isEmpty()){
			resultMap.put("code", 404);
			resultMap.put("msg", "没有数据");
		}else{
			List<Goods> list = new ArrayList<>();
			if(3>randGroup.size()){
				for(int i=0;i<randGroup.size();i++){
					int index = (int) (Math.random()* randGroup.size());
					list.add(randGroup.get(index));
				}
			}else{
				for(int i=0;i<3;i++){
					int index = (int) (Math.random()* randGroup.size());
					list.add(randGroup.get(index));
				}
			}
			
			resultMap.put("code", 200);
			resultMap.put("msg", list);
		}

		return resultMap;
	}

	@Override
	public Map<String, Object> getBymid(Integer mid) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.clear();
		Goods goods = this.getHibernateTemplate().get(Goods.class, mid);
		if(null==goods){
			resultMap.put("code", 404);
			resultMap.put("msg", "没有数据");
			
		}else{
			resultMap.put("code", 200);
			resultMap.put("msg", "没有数据");
			resultMap.put("data", goods);
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> selectByType(String type) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.clear();
		String hql = "from Goods goods where goods.type = ?";
		List<Goods> goodsList = (List<Goods>) this.getHibernateTemplate().find(hql, type);
		if(goodsList.isEmpty()){
			resultMap.put("code", 200);
			resultMap.put("msg", "");
		}else{
			resultMap.put("code", 200);
			resultMap.put("msg", goodsList);
		}
		return resultMap;
	}

}
