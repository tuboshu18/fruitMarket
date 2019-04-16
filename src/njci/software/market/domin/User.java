package njci.software.market.domin;

public class User {
	private Integer mid;
	private String username;
	private String pwd;
	private Double count;
	private String address;
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Double getCount() {
		return count;
	}
	public void setCount(Double count) {
		this.count = count;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [mid=" + mid + ", username=" + username + ", pwd=" + pwd + ", count=" + count + ", address="
				+ address + "]";
	}
	
	
	
}
