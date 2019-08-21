<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   欢迎：${msuser.useraccount}
<a href="/Msproject/userregiterloginAction/toregiter">注册</a></br>
<a href="/Msproject/userregiterloginAction/tologin">登录</a>
<a href="/Msproject/userregiterloginAction/exit">退出登录</a>
    <table border="1">
       <tr>
		<td>商品id</td>
		<td>商品标题</td>
		<td>图片地址</td>
		<td>秒杀价格</td>
		<td>商家id</td>
		<td>秒杀原价</td>
		<td>申请时间</td>
		<td>转态</td>
		<td>秒杀开始时间</td>
		<td>秒杀结束时间</td>
		<td>秒杀商品数</td>
		<td>库存</td>
		<td>商品描述</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${list}" var="item">
	<tr>
		<td>${item.productid }</td>
		<td>${item.producttitle }</td>
		<td>${item.productpicture }</td>
		<td>${item.miaoshaprice }</td>
		<td>${item.msmerchantid }</td>
		<td>${item.originalprice }</td>
		<td>${item.applydate }</td>
		<td>${item.auditstate }</td>
		<td>${item.starttime }</td>
		<td>${item.endtime }</td>
		<td>${item.productcount }</td>
		<td>${item.stockcount }</td>
		<td>${item.description }</td>
		<td><a href="viewproductdetail?id=${item.id }">查看</a></td>>
	</c:forEach>
    </table>
</body>
</html>