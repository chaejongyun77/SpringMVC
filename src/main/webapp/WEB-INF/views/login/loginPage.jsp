<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-12
  Time: 오전 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    #logoutDiv{
        display:none;
    }
</style>
<body>
<%
    String loginCheck = (request.getAttribute("loginCheck") != null ? (String)request.getAttribute("loginCheck") : "");
    String user_id = (session.getAttribute("user_id") != null ?(String) session.getAttribute("user_id") : "고객");


%>
<div>
    <%=(!user_id.equals("고객") ? user_id : "고객")%>님 환영합니다.
</div>
<div id="loginON" style="display:<%=!user_id.equals("고객") ? "none" : "block"%>">
<form id="loginfrm" name="loginFrm" method="post" action="/member/login">
   아이디 :  <input type="text" name="id" id="id" value="${cookie.save_id.value}"> <br>${cookie.save_id.value}
    비밀번호 :  <input type="password" name ="pwd" id="pwd" value=""><br>
    <input type="checkbox" name="idSave" id="idSave" ${cookie.save_id.value == null ? "" : "checked"}> 아이디저장 <input type="checkbox" name="autoLogin" id="autoLogin">자동로그인<br>
    <input type="button" id="login_button" value="로그인">  <input type="button" id="pwd_search" value="비밀번호찾기">  <input type="button" id="sign_up" value="회원가입">

</form>
</div>
<div id="logoutDiv" style="display:<%=(user_id != "고객"  ? "block" : "")%>  ">

    <input type="button" name="logout_button" id="logout_button" value="로그아웃">

</div>
<script>
    const login_button = document.querySelector("#login_button");
    const idSave = document.querySelector("#idSave");
    login_button.addEventListener("click" ,function(e){
        e.preventDefault();

        document.loginFrm.submit();
    });

    const logout_button = document.querySelector("#logout_button");
    logout_button.addEventListener("click",function (e){
       e.preventDefault();
       alert("로그아웃");
       location.href="/member/logout";

    });

</script>
</body>
</html>
