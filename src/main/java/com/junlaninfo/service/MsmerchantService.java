package com.junlaninfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junlaninfo.dao.MsmerchantDao;
import com.junlaninfo.entity.Msmerchant;
import com.junlaninfo.entity.vo.MsmerchantVo;

@Service
public class MsmerchantService {
     @Autowired
     private MsmerchantDao msmerchantDao;
      public Msmerchant queryMsmerchant(int id)  {
    	  return msmerchantDao.queryMsmerchantbyid(id);
      }
      
      public void  add(Msmerchant msmerchant) {
    	  msmerchantDao.inserMsmerchant(msmerchant);
      }
      public void update (Msmerchant msmerchant) {
    	  msmerchantDao.updateMsmerchant( msmerchant);
      }
      public void delete(int id) {
    	  msmerchantDao.deleteMsmerchant(id);
      }

	public List<Msmerchant> queryMsmerchantList(MsmerchantVo msmerchantVo) {
		// TODO Auto-generated method stub
		return msmerchantDao.queryMsmerchantbyvo(msmerchantVo);
	}
}
