package njci.software.market.service;

import java.util.Map;

public interface OrdersService {

	Map<String, Object> add(Integer uid, Integer pid, Integer num);

	Map<String, Object> select(String status, Integer uid);

	Map<String, Object> del(Integer mid);

	Map<String, Object> received(Integer mid);

	Map<String, Object> getAll();

	Map<String, Object> updateOrder(Integer mid, Integer status);

}
