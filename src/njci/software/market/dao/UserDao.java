package njci.software.market.dao;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import njci.software.market.domin.User;

public interface UserDao {

	public Map<String, Object> login(String uname, String pwd);
	@Transactional(readOnly = false)
	public Map<String, Object> register(String uname,String pwd);
	@Transactional(readOnly = false)
	public Map<String, Object> modifyPwd(Integer mid, String pwd, String newpwd);
	public Map<String, Object> getAddress(Integer mid);
	@Transactional(readOnly = false)
	public Map<String, Object> setAddress(Integer mid, String address);
	public Map<String, Object> getAll();
}
