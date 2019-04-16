package njci.software.market.service;

import java.util.Map;

public interface CarsService {

	Map<String, Object> add(Integer num, Integer pid, Integer uid);

	Map<String, Object> remove(Integer mid);

	Map<String, Object> listByUid(Integer uid);

}
