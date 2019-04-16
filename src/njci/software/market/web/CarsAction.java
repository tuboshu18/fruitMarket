package njci.software.market.web;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

import njci.software.market.domin.Cars;
import njci.software.market.service.CarsService;

public class CarsAction extends ActionSupport{
	private CarsService carsService;

	public CarsService getCarsService() {
		return carsService;
	}

	public void setCarsService(CarsService carsService) {
		this.carsService = carsService;
	}
	Map<String, Object> resultMap = new HashMap<String, Object>();
	public Map<String, Object> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	private Cars cars = new Cars();

	public Cars getCars() {
		return cars;
	}

	public void setCars(Cars cars) {
		this.cars = cars;
	}
	
	public String add(){
		Integer num = cars.getNum();
		Integer pid = cars.getPid();
		Integer uid = cars.getUid();
		resultMap = carsService.add(num,pid,uid);
		return SUCCESS;
	}
	public String remove(){
		Integer mid = cars.getMid();
		resultMap = carsService.remove(mid);
		return SUCCESS;
	}
	//hql没有写
	public String listByUid(){
		Integer uid =cars.getUid();
		resultMap = carsService.listByUid(uid);
		return SUCCESS;
	}
	public String update(){
		return SUCCESS;
	}
}
