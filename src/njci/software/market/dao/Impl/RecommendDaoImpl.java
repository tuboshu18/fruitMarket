package njci.software.market.dao.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import njci.software.market.dao.RecommendDao;
import njci.software.market.domin.Recommend;

public class RecommendDaoImpl extends HibernateDaoSupport implements RecommendDao{

	@Override
	public Map<String, Object> ins(String title, String content) {
		
		Recommend recommend = new Recommend();
		recommend.setAddtime(new Date());
		recommend.setContent(content);
		recommend.setTitle(title);
		this.getHibernateTemplate().save(recommend);
		Map<String, Object> result = new HashMap<String, Object>();
		if(StringUtils.isEmpty(content)||StringUtils.isEmpty(title)){
			result.put("451", "参数验证错误！");
			return result;
		}
		result.clear();
		result.put("添加成功", recommend);
		return result;
	}

	@Override
	public Map<String, Object> getAll() {
		String hql = "from Recommend recommend";
		List<Recommend> list = (List<Recommend>) this.getHibernateTemplate().find(hql);
		Map<String, Object> result = new HashMap<String, Object>();
		result.clear();
		result.put("data", list);
		return result;
	}

	@Override
	public Map<String, Object> del(Integer mid) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.clear();
		Recommend recommend = this.getHibernateTemplate().get(Recommend.class, mid);
		if(null==recommend){
			result.put("401", "没有信息");
		}else{
			this.getHibernateTemplate().delete(recommend);
			result.put("200", "删除成功");
		}
		return result;
	}

	@Override
	public Map<String, Object> getByid(Integer mid) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.clear();
		Recommend recommend = this.getHibernateTemplate().get(Recommend.class, mid);
		if(null==recommend){
			result.put("401", "没有信息");
		}else{
			result.put("msg", recommend);
		}
		return result;
	}

}
