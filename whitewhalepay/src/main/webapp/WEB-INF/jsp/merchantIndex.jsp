<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>商户主页</title>
</head>
<body>
	<table border="1" cellspacing="0">
            <tr>
                <th>${merchant.getMctName() }</th>
                <th>${merchant.getLoginSecret() }</th>
                <th>${merchant.getMctUsdtAct() }</th>
                <th>${merchant.getMctPhone() }</th>
                <th>${merchant.getMctIdentNo() }</th>
                <th>${merchant.getMctIdCardPic1() }</th>
                <th>${merchant.getMctIdCardPic2() }</th>
            </tr>
	</table>
</body>
</html>