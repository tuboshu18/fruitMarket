package njci.software.market.domin;

import java.util.Date;

public class Goods {
	private Integer mid;
	private String name;
	private Double price;
	private String type;
	private Integer num;
	private String pic1;
	private String pic2;
	private Date dates;
	private Integer discount;
	private Integer total;
	private Integer operateid;
	private Date operatertime;
	private Integer status;
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getPic1() {
		return pic1;
	}
	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}
	public String getPic2() {
		return pic2;
	}
	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}
	public Date getDates() {
		return dates;
	}
	public void setDates(Date dates) {
		this.dates = dates;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getOperateid() {
		return operateid;
	}
	public void setOperateid(Integer operateid) {
		this.operateid = operateid;
	}
	public Date getOperatertime() {
		return operatertime;
	}
	public void setOperatertime(Date operatertime) {
		this.operatertime = operatertime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Goods [mid=" + mid + ", name=" + name + ", price=" + price + ", type=" + type + ", num=" + num
				+ ", pic1=" + pic1 + ", pic2=" + pic2 + ", dates=" + dates + ", discount=" + discount + ", total="
				+ total + ", operateid=" + operateid + ", operatertime=" + operatertime + ", status=" + status + "]";
	}
	
}
