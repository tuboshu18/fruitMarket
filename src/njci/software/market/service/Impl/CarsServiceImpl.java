package njci.software.market.service.Impl;

import java.util.Map;

import njci.software.market.dao.CarsDao;
import njci.software.market.service.CarsService;

public class CarsServiceImpl implements CarsService{
	private CarsDao carsDao;

	public CarsDao getCarsDao() {
		return carsDao;
	}

	public void setCarsDao(CarsDao carsDao) {
		this.carsDao = carsDao;
	}

	@Override
	public Map<String, Object> add(Integer num, Integer pid, Integer uid) {
		
		return carsDao.add(num,pid,uid);
	}

	@Override
	public Map<String, Object> remove(Integer mid) {
		
		return carsDao.remove(mid);
	}

	@Override
	public Map<String, Object> listByUid(Integer uid) {
		
		return carsDao.listByUid(uid);
	}
	
}
