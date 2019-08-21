package com.junlaninfo.action;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.junlaninfo.entity.Msorder;
import com.junlaninfo.entity.Msproduct;
import com.junlaninfo.entity.Msuser;
import com.junlaninfo.service.MsoderService;
import com.junlaninfo.service.MsproductService;

@Controller
public class OrderAction {
	
	@Autowired
	MsoderService msoderService;
	
	@Autowired
	MsproductService msproductService;
	
  @RequestMapping("payorder")
  public String payorder(Msorder msorder){
	  Date now = new Date();
	  msorder.setCreatetime(now);
	  int paystatus = 1;
	  msorder.setPaystatus(paystatus);
	  String tradeserialnumber = UUID.randomUUID().toString();
	  msorder.setTradeserialnumber(tradeserialnumber);
	  msoderService.insertMsOrder(msorder);
	  return "redirect:/pagehomeAction/tohome";
	  
  }
  
  
  @RequestMapping("topayorder")
  public String topayorder(HttpServletRequest req,int id,int num){
	  Msproduct msproductinfo = msproductService.queryProductById(id);
	  req.setAttribute("msproductinfo", msproductinfo);
	  req.setAttribute("productnum", num);
	  int payamount = num * msproductinfo.getMiaoshaprice();
	  req.setAttribute("payamount", payamount);
	  HttpSession sess = req.getSession();
	  Msuser msuser = (Msuser) sess.getAttribute("msuser");
	  if(msuser != null ){
		  req.setAttribute("msuserid", msuser.getId());
	  }else{
		  req.setAttribute("error", "δ��¼");
		  return "user/tologin";
	  }
	  return "order/payorder";
	  
  }
}
