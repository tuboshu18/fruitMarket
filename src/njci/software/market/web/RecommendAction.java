package njci.software.market.web;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import njci.software.market.domin.Recommend;
import njci.software.market.service.RecommendService;

public class RecommendAction extends ActionSupport{
	private RecommendService recommendService;

	public RecommendService getRecommendService() {
		return recommendService;
	}

	public void setRecommendService(RecommendService recommendService) {
		this.recommendService = recommendService;
	}
	
	private Recommend recommend;

	public Recommend getRecommend() {
		return recommend;
	}

	public void setRecommend(Recommend recommend) {
		this.recommend = recommend;
	}
	Map<String, Object> resultMap = new HashMap<String, Object>();
	public Map<String, Object> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	public String ins() throws Exception{
		String content = recommend.getContent();
		String title = recommend.getTitle();
		resultMap.clear();
		resultMap = recommendService.ins(title,content);
		return SUCCESS;
	}
	public String getAll(){
		resultMap.clear();
		resultMap = recommendService.getAll();
		return SUCCESS;
	}
	public String del(){
		Integer mid = recommend.getMid();
		resultMap.clear();
		resultMap = recommendService.del(mid);
		return SUCCESS;
	}
	public String getByid(){
		Integer mid = recommend.getMid();
		resultMap.clear();
		resultMap = recommendService.getByid(mid);
		return SUCCESS;
	}
}
