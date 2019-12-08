<%--
  Created by IntelliJ IDEA.
  User: yicj
  Date: 2019/12/4
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>hello world</h2>

    <table width="517" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#33FFFF">
        <CAPTION>当日评价汇率</CAPTION>
        <tr bgcolor="#999900">
            <td width="250"><div align="center">Currency Pair</div></td>
            <td width="261"><div align="center">TTM Rate</div></td>
        </tr>
        <c:forEach items="${ttmRates}" var="ttmRate">
            <tr>
                <td><div align="center">${ttmRate.currencyPair}</div></td>
                <td><div align="center">${ttmRate.value}</div></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
