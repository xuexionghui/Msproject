<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看商品详情</title>
</head>
<body>
  <form action="">
       秒杀商品的id: ${msproductinfo.productid }</br>
		秒杀商品的标题: ${msproductinfo.producttitle }</br>
		秒杀商品的图片地址: ${msproductinfo.productpicture }</br>
		秒杀商品价格: ${msproductinfo.miaoshaprice }</br>
		商家的id: ${msproductinfo.msmerchantid }</br>
		商品原价: ${msproductinfo.originalprice }</br>
		秒杀商品的申请时间: ${msproductinfo.applydate }</br>
		秒杀商品的审核时间: ${msproductinfo.auditstate }</br>
		秒杀的开始时间: ${msproductinfo.starttime }</br>
		秒杀的结束时间: ${msproductinfo.endtime }</br>
		秒杀数量: ${msproductinfo.productcount }</br>
		秒杀的库存: ${msproductinfo.stockcount }</br>
		秒杀的描述: ${msproductinfo.description }</br>
  </form>

</body>
</html>