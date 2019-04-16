package njci.software.market.web;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

import njci.software.market.domin.Admin;
import njci.software.market.service.AdminService;

public class AdminAction extends ActionSupport{
	private AdminService adminService;

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	Map<String, Object> resultMap = new HashMap<String, Object>();
	public Map<String, Object> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	private Admin admin = new Admin();
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String login() throws Exception{
		String user = admin.getUsername();
		String pwd = admin.getPassword();
		resultMap = adminService.login(user,pwd);
		return SUCCESS;
	}
	
}
