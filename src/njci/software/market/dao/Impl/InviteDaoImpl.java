package njci.software.market.dao.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sun.org.apache.xerces.internal.util.Status;

import njci.software.market.dao.InviteDao;
import njci.software.market.domin.Invite;
import njci.software.market.utils.StringUtils;

public class InviteDaoImpl extends HibernateDaoSupport implements InviteDao{
	private static Integer stsus_new = 0;
	private static Integer stsus_usered = 1;
	@Override
	public Map<String, Object> ins() {
		
		Invite invite = new Invite();
		invite.setDates(new Date());
		invite.setStatus(stsus_new);
		invite.setCode(StringUtils.generateShortUUID());//生成的邀请码
		
		this.getHibernateTemplate().save(invite);
		Map<String, Object> result = new HashMap<String, Object>();
		result.clear();
		result.put("生成的邀请码", invite);
		return result;
	}

	@Override
	public Map<String, Object> del(Integer mid) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.clear();
		Invite invite = this.getHibernateTemplate().get(Invite.class, mid);
		if(null==invite){
			result.put("402", "邀请码不存在，删除失败");
		}else{
			this.getHibernateTemplate().delete(invite);
			result.put("200", "删除成功！");
		}
		
		return result;
	}

	@Override
	public Map<String, Object> listBack() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.clear();
		String hql = "from Invite invite";  
		List<Invite> listInvite = (List<Invite>) this.getHibernateTemplate().find(hql);
		if(listInvite.isEmpty()){
			result.put("404", "没有数据！");
		}else {
			result.put("200", listInvite);
		}
		
		return result;
	}

	@Override
	public Map<String, Object> insFront() {
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.clear();
		String hql = "from Invite invite";  
		List<Invite> listInvite = (List<Invite>) this.getHibernateTemplate().find(hql);
		if(listInvite.isEmpty()){
			result.put("404", "没有数据！");
		}else {
			result.put("200", listInvite);
		}
		
		return result;
	}

}
