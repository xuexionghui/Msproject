package com.junlaninfo.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.junlaninfo.entity.Msmerchant;
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
	public void add(Msmerchant msmerchant){
		/*
		 * Msmerchant msmerchant2 = new Msmerchant();
		 * msmerchant2.setMerchantaccount("11"); msmerchant2.setMerchantname("11");
		 * msmerchant2.setMerchantpassword("11"); msmerchant2.setMerchantscope("11");
		 * msmerchant2.setMerchantshopname("11");
		 */
		msmerchantService.add(msmerchant);
		System.out.println(msmerchant);
		//return "redirect:querybyvo";
	}
}
