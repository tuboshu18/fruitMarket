package njci.software.market.domin;

public class Admin {
	private Integer mid;
	private String username;
	private String password;
	private Integer rate;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "Admin [mid=" + mid + ", username=" + username + ", password=" + password + ", rate=" + rate + "]";
	}
	
}
