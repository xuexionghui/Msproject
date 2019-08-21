package com.junlaninfo.dao;

import com.junlaninfo.entity.Msorder;

public interface MsoderDao {

	void insertMsOrder(Msorder msorder);

	void updateorderpaystatusbyid(int i, int id, int paytype);

}
