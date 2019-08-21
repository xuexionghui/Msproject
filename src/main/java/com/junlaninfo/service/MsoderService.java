package com.junlaninfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junlaninfo.dao.MsoderDao;
import com.junlaninfo.entity.Msorder;

@Service
public class MsoderService {

	@Autowired
	private MsoderDao msoderDao;
	public void insertMsOrder(Msorder msorder) {
		msoderDao.insertMsOrder(msorder);
		
	}
	public void updateorderpaystatusbyid(int i, int id, int paytype) {
		msoderDao.updateorderpaystatusbyid(i,id,paytype);
		
	}

}
