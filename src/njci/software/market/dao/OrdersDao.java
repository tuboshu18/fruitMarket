package njci.software.market.dao;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

public interface OrdersDao {
	@Transactional(readOnly = false)
	Map<String, Object> add(Integer uid, Integer pid, Integer num);

	Map<String, Object> select(String status, Integer uid);
	@Transactional(readOnly = false)
	Map<String, Object> del(Integer mid);
	@Transactional(readOnly = false)
	Map<String, Object> received(Integer mid);

	Map<String, Object> getAll();
	@Transactional(readOnly = false)
	Map<String, Object> updateOrder(Integer mid, Integer status);

}
