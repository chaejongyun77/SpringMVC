<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-03
  Time: 오후 1:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    String errCode = (request.getAttribute("errCode") != null ? (String) request.getAttribute("errCode") : "");

%>
<form method="post" name="frmCalc" id="frmCalc" action="/calc">
    <input type="text" name ="num1" />
    <input type="text" name="num2"/>

    <div style="display : <%= (errCode.equals("1")  ?"block" : "none"  )%>"> 에러 </div>
    <button type="submit" >END</button>

</form>
</body>
</html>
