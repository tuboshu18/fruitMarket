package njci.software.market.service;

import java.util.Map;

import njci.software.market.dao.AdminDao;

public interface AdminService {

	Map<String, Object> login(String user, String pwd);
	
	
}
