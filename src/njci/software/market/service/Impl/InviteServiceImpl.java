package njci.software.market.service.Impl;

import java.util.Map;

import njci.software.market.dao.InviteDao;
import njci.software.market.service.InviteService;

public class InviteServiceImpl implements InviteService{
	private InviteDao inviteDao;

	public InviteDao getInviteDao() {
		return inviteDao;
	}

	public void setInviteDao(InviteDao inviteDao) {
		this.inviteDao = inviteDao;
	}

	@Override
	public Map<String, Object> ins() {
		return inviteDao.ins();
	}

	@Override
	public Map<String, Object> del(Integer mid) {
		return inviteDao.del(mid);
	}

	@Override
	public Map<String, Object> listBack() {
		
		return inviteDao.listBack();
	}
	
}
