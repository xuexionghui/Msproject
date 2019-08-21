package com.junlaninfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junlaninfo.dao.MsuserDao;
import com.junlaninfo.entity.Msmerchant;
import com.junlaninfo.entity.Msuser;
import com.junlaninfo.entity.vo.Msuser.MsuserVo;

@Service
public class MsuserService {
	 @Autowired
	 private MsuserDao msuserDao;
	public Msuser  queryMsuserbyid(int id) {
		return msuserDao.queryMsuserbyid(id);
	}
	public void  inserMsuser(Msuser msuser) {
		msuserDao.inserMsuser(msuser);
	}
	public void updateMsuser( Msuser msuser) {
		msuserDao.updateMsuser(msuser);
		
	}
	public void deleteMsuser(int id) {
		msuserDao.deleteMsuser(id);
	}
	public List<Msuser> queryMsuserbyvo(MsuserVo msuserVo){
		return msuserDao.queryMsuserbyvo(msuserVo);
	}
	public Msuser queryMsuserByuseraccount(String account) {
		// TODO Auto-generated method stub
		return msuserDao.queryMsuserByuseraccount( account);
	}
}
