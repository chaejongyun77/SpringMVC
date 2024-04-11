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
    <title>게시판 상세</title>
</head>
<body>
<h1>게시판 상세</h1>
<form name="frmDelete" id="frmDelete" method="post" action="/bbs/delete">
<input type="hidden" id="idx" name="idx" value="${dto.idx}">
<div>게시판 번호 : ${dto.idx}</div>
<div>게시판 제목 : ${dto.title}</div>
<div>게시판 내용 : ${dto.content}</div>
<div>게시판 날짜 : ${dto.display_date}</div>
<div>게시판 조회수 : ${dto.read_cnt}</div>

<div>
    <button type="button" onclick="location.href='/bbs/list'">리스트</button>
    <button type="button" onclick="location.href='/bbs/update?idx=${dto.idx}'">수정</button>
    <button type="button" onclick="goDelete();">삭제</button>
</div>
</form>
<script>
    function goDelete(){

        document.getElementById("frmDelete").submit();
    }
</script>
</body>
</html>
