package com.junlaninfo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.junlaninfo.entity.Msuser;
import com.junlaninfo.service.MsuserService;

/*
 *   用户注册登录接口
 */
@Controller
@RequestMapping("userregiterloginAction")
public class UserregiterloginAction {
	@Autowired
    private MsuserService  msuserService;
	@RequestMapping(value = "toregiter")
	public String toregiter(){
		return "user/toregiter";
	}
	
	@RequestMapping(value = "regiter",method=RequestMethod.POST)
	public String regiter(HttpServletRequest req,Msuser msuser){
		msuserService.inserMsuser(msuser);
		HttpSession sess = req.getSession();
		sess.setAttribute("msuser", msuser);
		System.out.println(msuser);
		return "redirect:tologin";
	}
	
	@RequestMapping(value = "tologin")
	public String tologin(HttpServletRequest req,Msuser msuser){
		
		return "user/tologin";
	}
	
	@RequestMapping(value = "login",method=RequestMethod.POST)
	public String login(HttpServletRequest req,Msuser msuser){
		String returnurl = "homepage/error";
		String account = msuser.getUseraccount();
		String password = msuser.getUserpassword();
		Msuser msuserresult = msuserService.queryMsuserByuseraccount(account);
		if(msuserresult == null ){
			System.out.println("�޴��û�");
			req.setAttribute("errorinfo", "没有此用户");
		}else if(!msuserresult.getUserpassword().equals(password)){
			System.out.println("�");
			req.setAttribute("errorinfo", "密码不对");
		}else{
			HttpSession sess = req.getSession();
			sess.setAttribute("msuser", msuserresult);
			returnurl = "homepage/homepage";
		}
		return returnurl;
	}
	
	@RequestMapping(value = "exit")
	public String exit(HttpServletRequest req){
		HttpSession sess = req.getSession();
		sess.removeAttribute("msuser");
		return "homepage/homepage";
	}

}
