package com.junlaninfo.dao;

import java.util.List;

import com.junlaninfo.entity.Msproduct;
import com.junlaninfo.entity.vo.Msproduct.MsProductVo;

public interface MsproductDao {
   public int applymsproduct(Msproduct msproduct);

public List<Msproduct> listmsproduct(MsProductVo msProductVo);

public Msproduct querymsproductByid(int id);

public void deletemsproductByid(int id);

public void updatemsproduct(Msproduct msproductinfo);

public void updatemsproductstate(Msproduct
		msproduct);
}
