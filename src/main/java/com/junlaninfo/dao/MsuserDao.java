package com.junlaninfo.dao;

import java.util.List;

import com.junlaninfo.entity.Msmerchant;
import com.junlaninfo.entity.Msuser;

import com.junlaninfo.entity.vo.Msuser.MsuserVo;

public interface MsuserDao {
	
	public Msuser  queryMsuserbyid(int id);
	public void  inserMsuser(Msuser msuser);
	public void updateMsuser( Msuser msuser);
	public void deleteMsuser(int id);
	public List<Msuser> queryMsuserbyvo(MsuserVo msuserVo);

}
