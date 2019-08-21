package com.junlaninfo.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.junlaninfo.entity.Msproductdetail;
import com.junlaninfo.service.MsproductdetailService;

@Controller
//@RequestMapping("msproductdetailaction")
public class MsproductdetailAction {
	@Autowired
	private MsproductdetailService  msproductdetailService;
	
	@RequestMapping(value="toinsertMsproductdetail")
	public String toinsertMsproductdetail(HttpServletRequest req,int productid,int merchantid){
		req.setAttribute("productid", productid);
		req.setAttribute("merchantid", merchantid);
		return "msproductDetail/toinsertMsproductdetail";
	}
	
	@RequestMapping(value="insertMsproductdetail",method=RequestMethod.POST)
	public String insertMsproductdetail(Msproductdetail msproductdetail){
		msproductdetailService.insert(msproductdetail);
		return "redirect:msproductaction/listmsproduct";
	}
	@RequestMapping(value="queryMsproductdetailByid")
	public String queryMsproductdetailByid(HttpServletRequest req,int productid){
		Msproductdetail msproductdetail = msproductdetailService.query(productid);
		req.setAttribute("msproductdetail", msproductdetail);
		return "msproductDetail/msproductdetailview";
	}
	
	@RequestMapping(value="toupdateMsproductdetail")
	public String toupdateMsproductdetail(HttpServletRequest req,int productid){
		Msproductdetail msproductdetail = msproductdetailService.query(productid);
		req.setAttribute("msproductdetail", msproductdetail);
		return "msproductDetail/toupdateMsproductdetail";
	}
	
	@RequestMapping(value="updateMsproductdetail",method=RequestMethod.POST)
	public String updateMsproductdetail(HttpServletRequest req,Msproductdetail msproductdetail){
	    msproductdetailService.update(msproductdetail);
		return "redirect:msproductaction/listmsproduct";
	}

}
