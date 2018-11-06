<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>承兑商主页</title>
</head>
<body>
	<table border="1" cellspacing="0">
            <tr>
                <th>${underwriter.getUwName() }</th>
                <th>${underwriter.getLoginSecret() }</th>
                <th>${underwriter.getUwUsdtAct() }</th>
                <th>${underwriter.getUwPhone() }</th>
                <th>${underwriter.getUwIdentNo() }</th>
                <th>${underwriter.getUwIdCardPic1() }</th>
                <th>${underwriter.getUwIdCardPic2() }</th>
                <th>${underwriter.getUwAliPayName() }</th>
                <th>${underwriter.getUwAliPayQrCode() }</th>
                <th>${underwriter.getUwAliPayPic() }</th>
            </tr>
	</table>
</body>
</html>