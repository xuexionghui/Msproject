package com.junlaninfo.dao;

import com.junlaninfo.entity.Msmerchant;

public interface MsmerchantDao {
	public Msmerchant  queryMsmerchantbyid(int id);
	public void  inserMsmerchant(Msmerchant msmerchant);
	public void updateMsmerchant(int id, Msmerchant  msmerchant);
	public void deleteMsmerchant(int id);
}
