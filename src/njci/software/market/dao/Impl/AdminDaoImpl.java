package njci.software.market.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import njci.software.market.dao.AdminDao;
import njci.software.market.domin.User;

public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao{

	@Override
	public Map<String, Object> login(String user, String pwd) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String hql = "from Admin a where a.username = ? and a.password = ?";
		List<User> result =  (List<User>) this.getHibernateTemplate().find(hql, user,pwd);
		if(result.isEmpty()){
			System.out.println("登陆失败");
			resultMap.put("code", "402");
		}else{
			System.out.println(result.get(0));
			resultMap.put("code", "200");
		}
		
		return resultMap;
	}

}
