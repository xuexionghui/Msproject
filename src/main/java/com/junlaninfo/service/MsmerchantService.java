package com.junlaninfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junlaninfo.dao.MsmerchantDao;
import com.junlaninfo.entity.Msmerchant;

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
      public void update (int id ,Msmerchant msmerchant) {
    	  msmerchantDao.updateMsmerchant(id, msmerchant);
      }
      public void delete(int id) {
    	  msmerchantDao.deleteMsmerchant(id);
      }
}
