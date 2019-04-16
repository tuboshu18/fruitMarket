package njci.software.market.dao;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

public interface GoodsDao {
	@Transactional(readOnly = false)
	Map<String, Object> ins(String name, Double price, String type, String pic1, String pic2, Integer num);
	@Transactional(readOnly = false)
	Map<String, Object> udp(Integer mid, String name, Double price, String type, String pic1, String pic2, Integer num);
	@Transactional(readOnly = false)
	Map<String, Object> del(Integer mid);

	Map<String, Object> getAll();

	Map<String, Object> orderByTime();

	Map<String, Object> orderByPrice();

	Map<String, Object> orderByTotol();
	
	Map<String, Object> searchBytype(String type);
	Map<String, Object> todayGroupBuy();
	Map<String, Object> tomorrowGroupBuy();
	Map<String, Object> topThree();
	Map<String, Object> getBymid(Integer mid);
	Map<String, Object> selectByType(String type);

}
