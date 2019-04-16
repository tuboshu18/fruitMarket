package njci.software.market.domin;

import java.util.Date;

public class Invite {
	private Integer mid;
	private String code;
	private Date dates;
	private Integer status;
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getDates() {
		return dates;
	}
	public void setDates(Date dates) {
		this.dates = dates;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Invite [mid=" + mid + ", code=" + code + ", dates=" + dates + ", status=" + status + "]";
	}
	
	
	
}
