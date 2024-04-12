<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-04
  Time: 오전 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<html>
<head>
    <title>게시판 리스트</title>
</head>
<body>
<h1>게시판 리스트</h1>
<ul>

    <c:forEach var="bbsDto" items="${list}">
        <li><a href="/bbs/view?idx=${bbsDto.idx}">${bbsDto} </a></li>

    </c:forEach>\

    <h1> Listener</h1>
    <h2>${appName}</h2>


</ul>


<br>

<button id="btn_regist" onclick="location.href='/bbs/regist'">글등록</button>
</body>
</html>
