<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/Msproject/userregiterloginAction/login" method="post">
	用户账号:<input name="useraccount"></br>
	用户密码:<input name="userpassword"></br>
	<input type="button" value="提交" onclick="submit(this)">
</form>

</body>
<script type="text/javascript">
	function submit(obj){
		obj.parent.sumbit();
	}
</script>
</html>