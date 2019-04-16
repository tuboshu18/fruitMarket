package njci.software.market.dao;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

public interface RecommendDao {
	@Transactional(readOnly = false)
	Map<String, Object> ins(String title, String content);

	Map<String, Object> getAll();
	@Transactional(readOnly = false)
	Map<String, Object> del(Integer mid);

	Map<String, Object> getByid(Integer mid);

}
