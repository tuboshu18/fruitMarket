package njci.software.market.web;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

import njci.software.market.domin.User;
import njci.software.market.service.UserService;

public class UserAction extends ActionSupport {

	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private User user = new User();
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	Map<String, Object> resultMap = new HashMap<String, Object>();
	public Map<String, Object> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	public String login() throws Exception{
		
		String uname = user.getUsername();
		String pwd = user.getPwd();
		resultMap = userService.login(uname,pwd);
		
		
        return SUCCESS;
	}
	public String register() throws Exception{
		String uname = user.getUsername();
		String pwd = user.getPwd();
		resultMap = userService.register(uname,pwd);
		return SUCCESS;
	}
	String newpwd = new String();
	
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String modifyPwd(){
		String pwd = user.getPwd();
		Integer mid = user.getMid();
		resultMap = userService.modifyPwd(mid,pwd,newpwd);
		return SUCCESS;
	}
	public String getAddress(){
		Integer mid = user.getMid();
		resultMap = userService.getAddress(mid);
		return SUCCESS;
	}
	public String setAddress(){
		String address = user.getAddress();
		Integer mid = user.getMid();
		resultMap = userService.setAddress(mid,address);
		return SUCCESS;
	}
	public String getAll(){
		resultMap = userService.getAll();
		return SUCCESS;
	}
}
