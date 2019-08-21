package com.junlaninfo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junlaninfo.dao.MsproductDao;
import com.junlaninfo.entity.Msorder;
import com.junlaninfo.entity.Msproduct;
import com.junlaninfo.entity.vo.Msproduct.MsProductVo;

@Service
public class MsproductService {
	@Autowired
	MsproductDao msproductDao;
    public void add(Msproduct msproduct) {
    	String starttimestring = msproduct.getStarttimestring();
    	String endtimestring = msproduct.getEndtimestring();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	 try {
			Date startTime = dateFormat.parse(starttimestring);
			Date endStime = dateFormat.parse(endtimestring);
			msproduct.setStarttime(startTime);
			msproduct.setEndtime(endStime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	msproduct.setApplydate(new Date());
    	msproduct.setAuditstate(1);  //申请状态
    	msproductDao.applymsproduct(msproduct);
    }
	public List<Msproduct> queryMsPoductByVo(MsProductVo msProductVo) {
		 return msproductDao.listmsproduct(msProductVo);
		
	}
	public Msproduct queryProductById(int id) {
		// TODO Auto-ge
		return msproductDao.querymsproductByid(id);
	}
	public void delete(int id) {
		msproductDao.deletemsproductByid(id);
		
	}
	public void update(Msproduct msproductinfo) {
		msproductDao.updatemsproduct(msproductinfo);
		
	}
	public void updateState(int id, int state) {
		Msproduct msproduct = new Msproduct();
		msproduct.setId(id);
		msproduct.setAuditstate(state);
		msproductDao.updatemsproductstate(msproduct);
		
	}
	/*
	 * 根据用户的ID查询订单
	 */
	public List<Msorder> queryorderbyuserid(int id) {
		
		return msproductDao.queryorderbyuserid(id);
	}
}
