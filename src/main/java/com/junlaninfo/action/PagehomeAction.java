package com.junlaninfo.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.junlaninfo.entity.Msproduct;
import com.junlaninfo.entity.Msproductdetail;
import com.junlaninfo.entity.vo.Msproduct.ConstomProduct;
import com.junlaninfo.entity.vo.Msproduct.MsProductVo;
import com.junlaninfo.service.MsoderService;
import com.junlaninfo.service.MsproductdetailService;


@Controller
@RequestMapping("pagehomeAction")
public class PagehomeAction {
	
	@Autowired
	private com.junlaninfo.service.MsproductService msproductService;
	
	@Autowired
	private MsoderService msoderService;
	
	@Autowired
	private MsproductdetailService msproductDetailService;
	
	@RequestMapping("tohome")
	public String tohome(HttpServletRequest req,MsProductVo msProductVo){
	
		/*
		 * ConstomProduct constomProduct = new ConstomProduct(); Date now = new Date();
		 * DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); String
		 * nowstring = dateFormat.format(now);
		 * constomProduct.setStartendtime(nowstring); constomProduct.setAuditstate(2);
		 * msProductVo.setConstomProduct(constomProduct);
		 */
//		private Date startstarttime;//��ɱ��ʼʱ���ѯ��Χ��ʼʱ��
//		private Date endstarttime;//��ɱ��ʼʱ���ѯ��Χ����ʱ��
	//	msProductVo.setConstomProduct(constomProduct);
		List<Msproduct> msPoductByVo = msproductService.queryMsPoductByVo(msProductVo);
		req.setAttribute("list", msPoductByVo);
		return "homepage/homepage";
}
	
	@RequestMapping("viewproductdetail")
	public String viewproductdetail(HttpServletRequest req,int id){
	   Msproduct msproduct = msproductService.queryProductById(id);
		Msproductdetail msproductdetail = msproductDetailService.query(id);
		req.setAttribute("msproduct", msproduct);
		req.setAttribute("msproductdetail", msproductdetail);
		return "order/selldetail";
	}
	
}
