<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加产品</title>
</head>
<body>
  <form action="applymsproduct" method="post">
    商品id:<input name="productid"></br>
	商品标题:<input name="producttitle"></br>
	商品图片地址:<input name="productpicture"></br>
	秒杀价格:<input name="miaoshaprice"></br>
	商品原价:<input name="originalprice"></br>
	商家id:<input name="Msmerchantid"></br>
	秒杀开始时间:<input name="starttimestring"></br>
	秒杀结束时间:<input name="endtimestring"></br>
	秒杀商品数量:<input name="productcount"></br>
	库存:<input name="stockcount"></br>
	描述:<input name="description"></br>
	<input type="button" value="提交"  onclick="submit(this)">
  </form>
  <script type="text/javascript">
    function submit(obj){
    	obj.parent.submit();
    }  
  </script>

</body>
</html>