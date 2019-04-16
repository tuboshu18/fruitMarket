package njci.software.market.dao;

import java.util.Map;

public interface AdminDao {

	Map<String, Object> login(String user, String pwd);

}
