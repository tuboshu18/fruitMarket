package njci.software.market.web;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import njci.software.market.domin.Goods;
import njci.software.market.service.GoodsService;

public class GoodsAction extends ActionSupport{
	private GoodsService goodsService;

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	private Goods goods =  new Goods();

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	Map<String, Object> resultMap = new HashMap<String, Object>();
	public Map<String, Object> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	/**
	 * 添加商品
	 * @return
	 */
	public String ins(){
		String name =  goods.getName();
		Double price = goods.getPrice();
		String type = goods.getType();
		String pic1 = goods.getPic1();
		String pic2 = goods.getPic2();
		Integer num = goods.getNum();
		resultMap = goodsService.ins(name,price,type,pic1,pic2,num);
		return SUCCESS;
	}
	/**
	 * 更新商品
	 * @return
	 */
	public String udp(){
		Integer mid = goods.getMid();
		String name =  goods.getName();
		Double price = goods.getPrice();
		String type = goods.getType();
		String pic1 = goods.getPic1();
		String pic2 = goods.getPic2();
		Integer num = goods.getNum();
		resultMap = goodsService.udp(mid,name,price,type,pic1,pic2,num);
		return SUCCESS;
	}
	/**
	 * 删除商品
	 * @return
	 */
	public String del(){
		Integer mid = goods.getMid();
		resultMap= goodsService.del(mid);
		return SUCCESS;
	}
	/**
	 * 获取所有的商品
	 * @return
	 */
	public String getAll(){
		resultMap = goodsService.getAll();
		return SUCCESS;
	}
	/**根据时间来获取商品
	 * 
	 * @return
	 */
	public String orderByTime(){
		resultMap = goodsService.orderByTime();
		return SUCCESS;
	}
	/**
	 * 通过价格进行排序
	 * @return
	 */
	public String orderByPrice(){
		resultMap = goodsService.orderByPrice();
		return SUCCESS;
	}
	/**
	 * 通过销量进行排序
	 * @return
	 */
	public String orderByTotol(){
		resultMap = goodsService.orderByTotol();
		return SUCCESS;
	}
	/**
	 * 通过类型来搜索
	 * @return
	 */
	public String searchByType(){
		String type = goods.getType();
		resultMap = goodsService.searchBytype(type);
		return SUCCESS;
	}
	public String todayGroupBuy(){
		resultMap = goodsService.todayGroupBuy();
		return SUCCESS;
	}
	
	public String tomorrowGroupBuy(){
		resultMap = goodsService.tomorrowGroupBuy();
		return SUCCESS;
	}
	
	public String topThree(){
		resultMap = goodsService.topThree();
		return SUCCESS;
	}
	
	public String getBymid(){
		Integer mid = goods.getMid();
		resultMap = goodsService.getBymid(mid);
		return SUCCESS;
	}
	public String selectByType(){
		String type = goods.getType();
		resultMap = goodsService.selectByType(type);
		return SUCCESS;
	}
}
