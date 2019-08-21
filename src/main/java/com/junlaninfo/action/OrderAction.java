package com.junlaninfo.action;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.junlaninfo.entity.Msorder;
import com.junlaninfo.entity.Msproduct;
import com.junlaninfo.entity.Msuser;
import com.junlaninfo.pay.WeixinPay;
import com.junlaninfo.pay.Yinghangkapay;
import com.junlaninfo.pay.ZhifubaoPay;
import com.junlaninfo.service.MsoderService;
import com.junlaninfo.service.MsproductService;

@Controller
public class OrderAction {
	
	@Autowired
	MsoderService msoderService;
	
	@Autowired
	MsproductService msproductService;
	@Autowired
	WeixinPay  weixinPay;
	@Autowired
	Yinghangkapay yinghangkapay;
	@Autowired
	ZhifubaoPay  zhifubaoPay;
	
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
		  req.setAttribute("error", "用户未登录");
		  return "user/tologin";
	  }
	  return "order/payorder";
	  
  }
  /*
   * 根据用户ID查询订单
   */
  
  @RequestMapping("queryorderbyuserid")
  public String queryorderbyuserid(HttpServletRequest req){
	 HttpSession session = req.getSession();
	 Msuser user = (Msuser) session.getAttribute("msuser");
	 if (user==null) {
		return  "user/tologin";
	}
	 List<Msorder> list=msproductService.queryorderbyuserid(user.getId());
     return "order/listOrder";
  }
  /*
   * 跳转到付款页面
   */
  @RequestMapping("topaywithorder")
  public String topaywithorder(HttpServletRequest req,int id,String tradeserialnumber, int payamount){
	  req.setAttribute("id", id);
	  req.setAttribute("tradeserialnumber", tradeserialnumber);
	  req.setAttribute("payamount", payamount);
	  return "order/payreal";//跳转到支付方式页面
	  }
  /*
   * 支付
   */
  @RequestMapping(value="paywithorder",method=RequestMethod.POST)
  public String paywithorder(HttpServletRequest req,int paytype,int id,String tradeserialnumber, int payamount){
	  int paystatus = 2;
	  if(paytype == 1){//1支付宝
		  paystatus = zhifubaoPay.paywithorder(tradeserialnumber, payamount);
	  }else if(paytype == 2){//2 微信
		  paystatus = weixinPay.paywithorder(tradeserialnumber, payamount);
	  }else if(paytype == 3){//3银行
		  paystatus = yinghangkapay.paywithorder(tradeserialnumber, payamount);
	  }
	  if(paystatus == 1){
		  msoderService.updateorderpaystatusbyid(2,id,paytype);
	  }
	  return "redirect:queryorderbyuserid";
	  
  }
}
