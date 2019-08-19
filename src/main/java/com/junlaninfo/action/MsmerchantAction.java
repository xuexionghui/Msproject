package com.junlaninfo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.junlaninfo.entity.Msmerchant;
import com.junlaninfo.entity.vo.MsmerchantVo;
import com.junlaninfo.service.MsmerchantService;

@Controller
@RequestMapping("msmerchantAction")
public class MsmerchantAction {
	@Autowired
	MsmerchantService msmerchantService;
	
	@RequestMapping("toadd")
	public String toadd(){
		return "msmerchant/add";
	}
	
	@RequestMapping(value = "add",method=RequestMethod.POST)
	public String  add(Msmerchant msmerchant){
		/*
		 * Msmerchant msmerchant2 = new Msmerchant();
		 * msmerchant2.setMerchantaccount("11"); msmerchant2.setMerchantname("11");
		 * msmerchant2.setMerchantpassword("11"); msmerchant2.setMerchantscope("11");
		 * msmerchant2.setMerchantshopname("11");
		 */
		msmerchantService.add(msmerchant);
		System.out.println(msmerchant);
		return "redirect:querybyvo";
		
	}
	

	@RequestMapping("toupdate")
	public  String toUpdate(HttpServletRequest request,int id) {
		Msmerchant msmerchant = msmerchantService.queryMsmerchant(id);
		request.setAttribute("msmerchant", msmerchant);
		return "msmerchant/update";
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(Msmerchant msmerchant) {
		msmerchantService.update( msmerchant);
		return "redirect:querybyvo";
	}
	

@RequestMapping("del")
public String del(HttpServletRequest request,int id){
	msmerchantService.delete(id);;
	return "redirect:querybyvo";
}

@RequestMapping("querybyid")
public String querybyid(HttpServletRequest request,int id){
	Msmerchant msmerchant = msmerchantService.queryMsmerchant(id);
	request.setAttribute("msmerchant", msmerchant);
	return "msmerchant/view";
}

@RequestMapping("querybyvo")
public String querybyvo(HttpServletRequest request,MsmerchantVo msmerchantVo){
	List<Msmerchant> list = msmerchantService.queryMsmerchantList(msmerchantVo);
	request.setAttribute("msmerchantlist", list);
	return "msmerchant/list";
}





}
