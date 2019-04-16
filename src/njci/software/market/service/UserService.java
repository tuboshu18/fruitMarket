package njci.software.market.service;

import java.util.Map;

public interface UserService {

	public Map<String, Object> login(String uname, String pwd);

	public Map<String, Object> register(String uname, String pwd);

	public Map<String, Object> modifyPwd(Integer mid, String pwd, String newpwd);

	public Map<String, Object> getAddress(Integer mid);

	public Map<String, Object> setAddress(Integer mid, String address);

	public Map<String, Object> getAll();
	
}
