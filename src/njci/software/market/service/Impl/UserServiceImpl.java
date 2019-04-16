package njci.software.market.service.Impl;

import java.util.Map;

import njci.software.market.dao.UserDao;
import njci.software.market.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Map<String, Object> login(String uname, String pwd) {
		
		return userDao.login(uname,pwd);
	}

	@Override
	public Map<String, Object> register(String uname, String pwd) {
		// TODO Auto-generated method stub
		return userDao.register(uname, pwd);
	}

	@Override
	public Map<String, Object> modifyPwd(Integer mid, String pwd, String newpwd) {
		// TODO Auto-generated method stub
		return userDao.modifyPwd(mid,pwd,newpwd);
	}

	@Override
	public Map<String, Object> getAddress(Integer mid) {
		// TODO Auto-generated method stub
		return userDao.getAddress(mid);
	}

	@Override
	public Map<String, Object> setAddress(Integer mid, String address) {
		// TODO Auto-generated method stub
		return userDao.setAddress(mid,address);
	}

	@Override
	public Map<String, Object> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}
	
}
