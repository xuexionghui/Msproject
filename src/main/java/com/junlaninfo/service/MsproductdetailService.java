package com.junlaninfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junlaninfo.dao.MsproductdetailDao;
import com.junlaninfo.entity.Msproductdetail;

@Service
public class MsproductdetailService {
	@Autowired
	private MsproductdetailDao msproductdetailDao;

	public void insert(Msproductdetail msproductdetail) {
		// TODO Auto-generated method stub
		msproductdetailDao.insertMsproductdetail(msproductdetail);
	}

	public Msproductdetail query(int productid) {
		// TODO Auto-generated method stub
		 return msproductdetailDao.queryMsproductdetailByid(productid);
	}

	public void update(Msproductdetail msproductdetail) {
		// TODO Auto-generated method stub
		msproductdetailDao.updateMsproductdetail(msproductdetail);
		
	}

}
