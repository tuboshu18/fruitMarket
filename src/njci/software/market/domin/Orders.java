package njci.software.market.domin;

import java.util.Date;

public class Orders {
	private Integer mid;
	private Integer uid;
	private Integer pid;
	private Date dates;
	private String status;
	private Double price;
	private String name;
	private String address;
	private String goodsname;
	private Integer num;
	private Double total;
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Date getDates() {
		return dates;
	}
	public void setDates(Date dates) {
		this.dates = dates;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Orders [mid=" + mid + ", uid=" + uid + ", pid=" + pid + ", dates=" + dates + ", status=" + status
				+ ", price=" + price + ", name=" + name + ", address=" + address + ", goodsname=" + goodsname + ", num="
				+ num + ", total=" + total + "]";
	}
	
	
	
}
