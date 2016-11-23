<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/play.css">
<title>Insert title here</title>
</head>
<body>
<a>Index</a>
<hr>
<form action="search.do">
<button type="submit" onclick="javascript:window.location.href='search.do?currentPage=1'">Products</button>
</form>
<hr>
<form action="search.do">
<input type="text" name="keyword"><br>
<input type="hidden" name="currentPage" value="1">
<button type="submit">Search</button>
</form>
<hr>
<form action="register.do">
<a>用户名：</a><input type="text" name="username"><br>
<a>输入密码：</a><input type="password" name="password"><br>
<a>确认密码：</a><input type="password" name="chkpwd"><br>
<a>预存金额：</a><input type="text" name="balance"><br>

<div class="check">
	<div class="wrap">
		<div class="content">
			<a id="tips" style="color: #FFF;">请点击开始验证按钮，并在图片中找到文字下方图案</a>
			<div class="mid">
				<ul id="oul">
					<li id="li1"><img src="img/2.png" alt=""></li>
				</ul>
			</div>
			<p id="start">开始验证</p>
		</div>
	</div>
	<button id="btn" type="submit">确认注册</button>
	
	<script src="js/play.js"></script>
	<script>
		window.onload = function(){
			play.init();
		}
	</script>
</div>




</form>


</body>
</html>