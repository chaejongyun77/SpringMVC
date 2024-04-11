<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<h1><%= "Hello World!" %></h1>
안녕하세요
<br/>
<a href="hello-servlet">Hello Servlet</a>

<ul>
<li><a href="/bbs/regist"> 등록</a></li>
<li><a href="/bbs/view"> 상세</a></li>
<li><a href="/bbs/update"> 수정</a></li>
<li><a href="/bbs/delete"> 삭제</a></li>
<li><a href="/bbs/list"> 리스트</a></li>
  <li><a href="/test" > 테스트 </a></li>
  <div>
    <c:forEach var="num" items="${list}">

      <span> ${num}</span>
    </c:forEach>

    <c:set var ="number" value="1"></c:set>

    <c:choose >
      <c:when test="ssds">
        안녕하세요1
      </c:when>
      <c:otherwise>
        반갑습니단11

      </c:otherwise>
    </c:choose>
  </div>
</ul>
</body>

</html>