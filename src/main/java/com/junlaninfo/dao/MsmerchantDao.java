package com.junlaninfo.dao;

import java.util.List;

import com.junlaninfo.entity.Msmerchant;
import com.junlaninfo.entity.vo.MsmerchantVo;

public interface MsmerchantDao {
	public Msmerchant  queryMsmerchantbyid(int id);
	public void  inserMsmerchant(Msmerchant msmerchant);
	public void updateMsmerchant( Msmerchant  msmerchant);
	public void deleteMsmerchant(int id);
	public List<Msmerchant> queryMsmerchantbyvo(MsmerchantVo msmerchantVo);
	public Msmerchant queryMsmerchantByaccount(String account);
}
