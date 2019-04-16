package njci.software.market.dao;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

public interface InviteDao {
	@Transactional(readOnly = false)
	public Map<String, Object> ins();
	@Transactional(readOnly = false)
	public Map<String, Object> del(Integer mid);
	public Map<String, Object> listBack();
	public Map<String, Object> insFront();
}
