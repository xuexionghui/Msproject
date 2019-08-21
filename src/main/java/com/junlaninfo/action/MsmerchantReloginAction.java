package com.junlaninfo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.junlaninfo.entity.Msmerchant;
import com.junlaninfo.entity.Msuser;
import com.junlaninfo.service.MsmerchantService;



/**
 * �̼�ע���¼ģ��
 * @author Administrator
 *
 */
@Controller
@RequestMapping("msmerchantReloginAction")
public class MsmerchantReloginAction {
	
	@Autowired
	MsmerchantService msmerchantService;
	
	@RequestMapping(value = "toregiter")
	public String toregiter(){
		return "msmerchant/toregiter";
	}
	
	@RequestMapping(value = "regiter",method=RequestMethod.POST)
	public String regiter(HttpServletRequest req,Msmerchant msmerchant){
		msmerchantService.add(msmerchant);
		HttpSession sess = req.getSession();
		sess.setAttribute("msmerchant", msmerchant);
		return "redirect:tologin";
	}
	
	@RequestMapping(value = "tologin")
	public String tologin(HttpServletRequest req,Msuser msuser){
		
		return "msmerchant/tologin";
	}
	
	@RequestMapping(value = "login",method=RequestMethod.POST)
	public String login(HttpServletRequest req,String merchantaccount,String  merchantpassword){
		String returnurl = "adminpagehome/error";
		Msmerchant msmerchant = msmerchantService.queryMsmerchantByaccount(merchantaccount);
		if(msmerchant == null ){
			System.out.println("�޴��̼�");
			req.setAttribute("errorinfo", "没有 商户");
		}else if(!msmerchant.getMerchantpassword().equals(merchantpassword)){
			System.out.println("�̼��������");
			req.setAttribute("errorinfo", "密码不正确");
		}else{
			HttpSession sess = req.getSession();
			sess.setAttribute("msmerchant", msmerchant);
			returnurl = "adminpagehome/homepage";
		}
		return returnurl;
	}
	
	@RequestMapping(value = "exit")
	public String exit(HttpServletRequest req){
		HttpSession sess = req.getSession();
		sess.removeAttribute("msmerchant");
		return "adminpagehome/homepage";
	}
	
	
	
	
	
}
