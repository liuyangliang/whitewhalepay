<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
	<table border="1" cellspacing="0">
        <tr>
            <th>UwId</th>
            <th>BankCardNo</th>
            <th>BankInfo</th>
        </tr>
        <s:iterator value="#request.bandCardList" id="bandCard" status="st">
            <tr>
                <th>${bandCard.getUwId()}</th>
                <th>${bandCard.getBankCardNo()}</th>
                <th>${bandCard.getBankInfo()}</th>
            </tr>
        </s:iterator>
    </table>

</body>
</html>
