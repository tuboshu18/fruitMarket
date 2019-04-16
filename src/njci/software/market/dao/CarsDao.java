package njci.software.market.dao;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

public interface CarsDao {
	@Transactional(readOnly = false)
	Map<String, Object> add(Integer num, Integer pid, Integer uid);
	@Transactional(readOnly = false)
	Map<String, Object> remove(Integer mid);

	Map<String, Object> listByUid(Integer uid);

}
