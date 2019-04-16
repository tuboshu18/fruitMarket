package njci.software.market.service;

import java.util.Map;

public interface RecommendService {

	Map<String, Object> ins(String title, String content);

	Map<String, Object> getAll();

	Map<String, Object> del(Integer mid);

	Map<String, Object> getByid(Integer mid);

}
