<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>白鲸支付-登录</title>
<link
	href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="<%=basePath%>css/normalize.min.css">
<link rel="stylesheet" href="<%=basePath%>css/style.css">
</head>
<body>
	<div class="form">
	
		<ul class="tab-group">
			<li class="tab active"><a href="#merchant">商戶</a></li>
			<li class="tab"><a href="#underwriter">承兑商</a></li>
		</ul>
		
		<div class="tab-content">
		
			<div id="merchant">
				<h1>欢迎回来!</h1>		
				<form action="/whitewhalepay/merchantLogin" method="post">
					<div class="field-wrap">
						<label>身份证号<span class="req">*</span>
						</label> <input type="text" name="mctIdentNo" required autocomplete="off" />
					</div>
					<div class="field-wrap">
						<label>登录密码<span class="req">*</span>
						</label> <input type="password" name="loginSecret" required autocomplete="off" />
					</div>
					<p class="forgot">
						<a href="#">Forgot Password?</a>
					</p>
					<button class="button button-block" />
					登 录
					</button>
				</form>
			</div>

			<div id="underwriter">
				<h1>欢迎回来!</h1>		
				<form action="/whitewhalepay/underwriterLogin" method="post">
					<div class="field-wrap">
						<label>身份证号<span class="req">*</span>
						</label> <input type="text" name="uwIdentNo" required autocomplete="off" />
					</div>
					<div class="field-wrap">
						<label>登录密码<span class="req">*</span>
						</label> <input type="password" name="loginSecret" required autocomplete="off" />
					</div>
					<p class="forgot">
						<a href="#">Forgot Password?</a>
					</p>
					<button class="button button-block" />
					登 录
					</button>
				</form>
			</div>
			
		</div>
		<!-- tab-content -->
	</div>
	<!-- /form -->
	<script src='<%=basePath%>js/jquery.min.js'></script>
	<script src="<%=basePath%>js/index.js"></script>
	<script type="text/javascript">
		if ('${login_state }' == 'FAIL') alert('登录失败');
		if ('${signup_state }' == 'SUCCESS') alert('注册成功，请登录');
	</script>
</body>
</html>
