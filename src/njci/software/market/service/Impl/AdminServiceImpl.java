package njci.software.market.service.Impl;

import java.util.Map;

import njci.software.market.dao.AdminDao;
import njci.software.market.service.AdminService;

public class AdminServiceImpl implements AdminService{
	private AdminDao adminDao;

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public Map<String, Object> login(String user, String pwd) {
		
		return adminDao.login(user,pwd);
	}
	
}
