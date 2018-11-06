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
<title>白鲸支付-注册</title>
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
				<h1>免费注册</h1>
				<form action="/whitewhalepay/merchantSignup" method="post" enctype="multipart/form-data">
					<div class="field-wrap">
						<label> 身份证号码<span class="req">*</span>
						</label> <input type="text" name="mctIdentNo" required autocomplete="off" />
					</div>
					<div class="field-wrap">
						<label> 密码<span class="req">*</span>
						</label> <input type=password name="loginSecret" required autocomplete="off" />
					</div>
					<div class="field-wrap">
						<label> 姓名<span class="req">*</span>
						</label> <input type="text" name="mctName" required autocomplete="off" />
					</div>
					<div class="field-wrap">
						<label> 手机号码<span class="req">*</span>
						</label> <input type="text" name="mctPhone" required autocomplete="off" />
					</div>
					<div class="field-wrap">
						
					</div>
					<div class="field-wrap">
						<input type="file" required name="mctIdCardPic1" autocomplete="off" accept="image/jpeg,image/jpg,image/png"/>
					</div>
					<div class="field-wrap">
						<input type="file" required name="mctIdCardPic2" autocomplete="off" accept="image/jpeg,image/jpg,image/png"/>
					</div>
					<button type="submit" class="button button-block" />
					Get Started
					</button>
				</form>
			</div>

			<div id="underwriter">
				<h1>免费注册</h1>
				<form action="/whitewhalepay/underwriterSignup" method="post" enctype="multipart/form-data">
					<div class="field-wrap">
						<label> 身份证号码<span class="req">*</span>
						</label> <input type="text" name="uwIdentNo" required autocomplete="off" />
					</div>
					<div class="field-wrap">
						<label> 密码<span class="req">*</span>
						</label> <input type=password name="loginSecret" required autocomplete="off" />
					</div>
					<div class="field-wrap">
						<label> 姓名<span class="req">*</span>
						</label> <input type="text" name="uwName" required autocomplete="off" />
					</div>
					<div class="field-wrap">
						<label> 手机号码<span class="req">*</span>
						</label> <input type="text" name="uwPhone" required autocomplete="off" />
					</div>
					<div class="field-wrap">
						<label> 支付宝名称<span class="req">*</span></label>
						<input type="text" name="uwAliPayName" required autocomplete="off" />
					</div>
					<div class="field-wrap">
						<input type="file" name="uwIdCardPic1" required autocomplete="off" accept="image/jpeg,image/jpg,image/png" />
					</div>
					<div class="field-wrap">
						 <input type="file" name="uwIdCardPic2" required autocomplete="off" accept="image/jpeg,image/jpg,image/png" />
					</div>
					<div class="field-wrap">
						<input type="file" name="uwAliPayQrCode" required autocomplete="off" accept="image/jpeg,image/jpg,image/png" />
					</div>
					<div class="field-wrap">
						 <input type="file" name="uwAliPayPic" required autocomplete="off" accept="image/jpeg,image/jpg,image/png" />
					</div>
					<button type="submit" class="button button-block" />
					Get Started
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
		if ('${signup_state }' == 'FAIL') {
			alert('注册失败\n失败原因：${signup_info }');
		}
	</script>
</body>
</html>
