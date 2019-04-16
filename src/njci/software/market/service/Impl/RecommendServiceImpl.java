package njci.software.market.service.Impl;

import java.util.Map;

import njci.software.market.dao.RecommendDao;
import njci.software.market.service.RecommendService;

public class RecommendServiceImpl implements RecommendService{
	private RecommendDao recommendDao;

	public RecommendDao getRecommendDao() {
		return recommendDao;
	}

	public void setRecommendDao(RecommendDao recommendDao) {
		this.recommendDao = recommendDao;
	}

	@Override
	public Map<String, Object> ins(String title, String content) {
			return recommendDao.ins(title,content);
	}

	@Override
	public Map<String, Object> getAll() {
		
		return recommendDao.getAll();
	}

	@Override
	public Map<String, Object> del(Integer mid) {
		
		return recommendDao.del(mid);
	}

	@Override
	public Map<String, Object> getByid(Integer mid) {
		
		return recommendDao.getByid(mid);
	}
	
}
