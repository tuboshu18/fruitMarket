package njci.software.market.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import njci.software.market.dao.UserDao;
import njci.software.market.domin.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
	@Override
	public Map<String, Object> login(String uname, String pwd) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String hql = "from User u where u.username = ? and u.pwd = ?";
		List<User> result =  (List<User>) this.getHibernateTemplate().find(hql, uname,pwd);
		if(result.isEmpty()){
			resultMap.put("code", 402);
			resultMap.put("msg", "用户名或密码错误！");
		}else{
			resultMap.put("code", 200);
			resultMap.put("msg", "登陆成功");
			resultMap.put("uid", result.get(0).getMid());
		}
		
		return resultMap;
	}

	@Override
	public Map<String, Object> register(String uname, String pwd) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.clear();
		User user = new User();
		user.setUsername(uname); 
		user.setPwd(pwd);
		user.setCount((double) 0);
		user.setAddress("");
		String hql = "from User u where u.username = ? and u.pwd = ?";
		List<User> result =  (List<User>) this.getHibernateTemplate().find(hql, uname,pwd);
		if(result.isEmpty()){
			this.getHibernateTemplate().save(user);
			resultMap.put("code", 200);
			resultMap.put("msg", "注册成功");
			
		}else{
			resultMap.put("code", 400);
			resultMap.put("msg", "用户已存在");
		}
		
		return resultMap;
	}

	@Override
	public Map<String, Object> modifyPwd(Integer mid, String pwd, String newpwd) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.clear();
		String hql = "from User u where u.mid = ?";
		List<User> result = (List<User>) this.getHibernateTemplate().find(hql, mid);
		if(result.isEmpty()){
			resultMap.put("code", 404);
			resultMap.put("msg", "用户不存在！");
		}else{
			if(pwd.equals(result.get(0).getPwd())){
				User user = result.get(0);
				user.setPwd(newpwd);
				this.getHibernateTemplate().update(user);
				resultMap.put("code", 200);
				resultMap.put("msg", "修改成功！");
			}else{
				resultMap.put("code", 408);
				resultMap.put("msg", "密码错误！");
			}
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> getAddress(Integer mid) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.clear();
		String hql = "from User u where u.mid = ?";
		List<User> result = (List<User>) this.getHibernateTemplate().find(hql, mid);
		if(result.isEmpty()){
			resultMap.put("code", 404);
			resultMap.put("msg", "用户不存在！");
		}else{
			String address = result.get(0).getAddress();
			if(address==null||address.equals("")){
				Map<String, Object> addressMap = new HashMap<String, Object>();
				addressMap.put("name", null);
				addressMap.put("tel", null);
				addressMap.put("locations", null);
				addressMap.put("address", null);
				resultMap.put("code", 200);
				resultMap.put("msg", "获取成功！");
				resultMap.put("data", addressMap);
				return resultMap;
			}
			String[]  addressArr = address.split(",");
			Map<String, Object> addressMap = new HashMap<String, Object>();
			addressMap.put("name", addressArr[0]);
			addressMap.put("tel", addressArr[1]);
			addressMap.put("locations", addressArr[2]);
			addressMap.put("address", addressArr[3]);
			resultMap.put("code", 200);
			resultMap.put("msg", "获取成功！");
			resultMap.put("data", addressMap);
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> setAddress(Integer mid, String address) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.clear();
		String hql = "from User u where u.mid = ?";
		List<User> result = (List<User>) this.getHibernateTemplate().find(hql, mid);
		if(result.isEmpty()){
			resultMap.put("code", 404);
			resultMap.put("msg", "用户不存在！");
		}else{
			User user = result.get(0);
			user.setAddress(address);
			this.getHibernateTemplate().update(user);
			resultMap.put("code", 200);
			resultMap.put("msg", "设置成功！");
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> getAll() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.clear();
		String hql = "from User u ";
		List<User> result = (List<User>) this.getHibernateTemplate().find(hql);
		resultMap.put("code", 200);
		resultMap.put("msg", "成功获取！");
		resultMap.put("data", result);
		return resultMap;
	}

}
