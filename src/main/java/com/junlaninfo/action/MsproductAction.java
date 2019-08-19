package com.junlaninfo.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.junlaninfo.entity.Msproduct;
import com.junlaninfo.entity.vo.Msproduct.MsProductVo;
import com.junlaninfo.service.MsproductService;

@Controller
@RequestMapping("msproductaction")
public class MsproductAction {
	@Autowired
	private MsproductService msproductService;
	
	@RequestMapping(value="toApplymsproduct")
	public String  toadd() {
		return "msproduct/applymsproduct";
	}
	
	@RequestMapping(value = "applymsproduct",method = RequestMethod.POST)
	public String add( Msproduct msproduct) {
		msproductService.add(msproduct);
		return "redirect:listmsproduct";
	}
	@RequestMapping(value="listmsproduct")
	public String listmsproduct(HttpServletRequest req,MsProductVo msProductVo){
		List<Msproduct> msPoductByVo = msproductService.queryMsPoductByVo(msProductVo);
		req.setAttribute("list", msPoductByVo);
		return "msproduct/list";
	}
	
	@RequestMapping(value="querymsproductByid")
	public String querymsproductByid(HttpServletRequest req,int id){
		Msproduct msproduct=msproductService.queryProductById( id);
		req.setAttribute("msproductinfo", msproduct);
		return "msproduct/view";
	}
	@RequestMapping(value="deletemsproductByid")
	public String deletemsproductByid(HttpServletRequest req,int id){
		msproductService.delete(id);
		return "redirect:listmsproduct";
	}
	
	@RequestMapping(value="toupdatemsproduct")
	public String toupdatemsproduct(HttpServletRequest req,int id){
		Msproduct msproduct = msproductService.queryProductById(id);
		Date starttime = msproduct.getStarttime();
		Date endtime = msproduct.getEndtime();
		String starttimeString="";
		String endtimeString="";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		starttimeString=dateFormat.format(starttime);
		endtimeString=dateFormat.format(endtime);
		req.setAttribute("msproductinfo", msproduct);
		req.setAttribute("starttimestring", starttimeString);
		req.setAttribute("endtimestring", endtimeString);
		return "msproduct/updatemsproduct";
	}
	
	@RequestMapping(value="updatemsproduct",method=RequestMethod.POST)
	public String updatemsproduct(HttpServletRequest req,Msproduct msproductinfo){
		msproductService.update(msproductinfo);
		return "redirect:listmsproduct";
	}
	
	
	@RequestMapping(value="toupdatemsproductstate")
	public String toupdatemsproductstate(HttpServletRequest req,int id){
		Msproduct msproduct = msproductService.queryProductById(id);
		Date starttime = msproduct.getStarttime();
		Date endtime = msproduct.getEndtime();
		String starttimestring = "";
		String endtimestring = "";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if(starttime != null){
			starttimestring = dateFormat.format(starttime);
		}
		if(endtime != null){
			endtimestring = dateFormat.format(endtime);
		}
		
		req.setAttribute("msproductinfo", msproduct);
		req.setAttribute("starttimestring", starttimestring);
		req.setAttribute("endtimestring", endtimestring);
		return "msproduct/auditmsproduct";
	}
	
	@RequestMapping(value="updatemsproductstate",method=RequestMethod.POST)
	public String updatemsproductstate(HttpServletRequest req,int id,int state){
	   msproductService.updateState(id,state);
		return "redirect:listmsproduct";
	}
	
	

}
