package njci.software.market.web;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

import njci.software.market.domin.Orders;
import njci.software.market.service.OrdersService;

public class OrdersAction extends ActionSupport{
	private OrdersService ordersService;

	public OrdersService getOrdersService() {
		return ordersService;
	}

	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}
	private Orders orders = new Orders();

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	Map<String, Object> resultMap = new HashMap<String, Object>();
	public Map<String, Object> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	public String add(){
		Integer uid = orders.getUid();
		Integer pid = orders.getPid();
		Integer num = orders.getNum();
		resultMap = ordersService.add(uid,pid,num);
		return SUCCESS;
	}
	public String select(){
		String status = orders.getStatus();
		Integer uid = orders.getUid();
		resultMap = ordersService.select(status,uid);
		return SUCCESS;
	}
	
	public String del(){
		Integer mid = orders.getMid();
		resultMap = ordersService.del(mid);
		return SUCCESS;
	}
	public String received(){
		Integer mid = orders.getMid();
		resultMap = ordersService.received(mid);
		return SUCCESS;
	}
	public String getAll(){
		resultMap = ordersService.getAll();
		return SUCCESS;
	}
	public String upd(){
		Integer mid = orders.getMid();
		Integer status = orders.getNum();//用num做中间存储来存值修改的状态。
		resultMap = ordersService.updateOrder(mid,status);
		return SUCCESS;
	}
}
