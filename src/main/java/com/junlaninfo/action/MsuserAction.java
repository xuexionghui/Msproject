package com.junlaninfo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.junlaninfo.entity.Msmerchant;
import com.junlaninfo.entity.Msuser;
import com.junlaninfo.entity.vo.Msuser.MsuserVo;
import com.junlaninfo.service.MsuserService;
@RequestMapping("msuseraction")
@Controller
public class MsuserAction {
	@Autowired
	private MsuserService msuserService;
	@RequestMapping("toadd")
	public String  toAdd() {
		 return "user/add";
	}
	
	@RequestMapping(value = "add",method=RequestMethod.POST)
	public String add(Msuser msuser) {
		msuserService.inserMsuser(msuser);
		return "redirect:querybyvo";//重定向到
	}
	@RequestMapping("toupdate")
	public String toUpdate(int id,HttpServletRequest request) {
		Msuser msuser = msuserService.queryMsuserbyid(id);
		request.setAttribute("msuser",msuser);
		return "user/update";
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(HttpServletRequest request,Msuser msuser){
		msuserService.updateMsuser(msuser);
		return "redirect:querybyvo";//重定向到
	}
	@RequestMapping("del")
	public String del(HttpServletRequest request,int id){
		msuserService.deleteMsuser(id);
		return "redirect:querybyvo";
	}
	
	@RequestMapping("querybyid")
	public String querybyid(HttpServletRequest request,int id){
	     Msuser msuser = msuserService.queryMsuserbyid(id);
		request.setAttribute("msuser", msuser);
		return "user/view";
	}
	
	@RequestMapping("querybyvo")
	public String querybyvo(HttpServletRequest request,MsuserVo msuserVo){
		List<Msuser> list = msuserService.queryMsuserbyvo(msuserVo);
		request.setAttribute("msuserlist", list);
		return "user/list";
	}
	

}
