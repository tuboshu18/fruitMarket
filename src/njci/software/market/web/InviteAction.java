package njci.software.market.web;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

import njci.software.market.domin.Invite;
import njci.software.market.service.InviteService;

public class InviteAction extends ActionSupport{
	private InviteService inviteService;

	public InviteService getInviteService() {
		return inviteService;
	}

	public void setInviteService(InviteService inviteService) {
		this.inviteService = inviteService;
	}
	
	Map<String, Object> resultMap = new HashMap<String, Object>();
	public Map<String, Object> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	private Invite invite = new Invite();
	public Invite getInvite() {
		return invite;
	}

	public void setInvite(Invite invite) {
		this.invite = invite;
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	

	public String ins()throws Exception{
		resultMap.clear();
		resultMap = inviteService.ins();
		return SUCCESS;
	}
	public String del()throws Exception{
		Integer mid = invite.getMid();
		resultMap.clear();
		resultMap = inviteService.del(mid);
		return SUCCESS;
	}
	public String listBack()throws Exception{
		resultMap.clear();
		resultMap= inviteService.listBack();
		return SUCCESS;
	}
}
