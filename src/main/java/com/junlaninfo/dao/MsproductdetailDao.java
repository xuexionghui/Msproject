package com.junlaninfo.dao;

import com.junlaninfo.entity.Msproductdetail;

public interface MsproductdetailDao {
	
	public void insertMsproductdetail(Msproductdetail msproductdetail);
	public Msproductdetail queryMsproductdetailByid(int productid);
	public void updateMsproductdetail(Msproductdetail msproductdetail);

}
