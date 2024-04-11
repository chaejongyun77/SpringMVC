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
    <title>게시판 수정</title>
</head>
<body>
<%

    int[] arr =((int[])request.getAttribute("list") !=null ?(int[])request.getAttribute("list") : new int[3]) ;


%>
<h1>게시판 수정</h1>

<div>
    <form name="frmModify" id="frmModify" method="post" action="/bbs/update?idx=${BbsDTO.idx}">
        <input type="hidden" id="user_id" name="user_id" value="${BbsDTO.user_id}"/>
        <table>
            <tr>
                <td><span>제목 : </span></td>
                <td><input type="text" name="title" id="title" value="${BbsDTO.title}" maxlength="200" placeholder="글 제목을 입력하세요."/></td>
                <div id="title_check_flag" style='display: <%=arr[0] ==0 ? "none": "block" %> '>제목을 입력해주세요. </div>
            </tr>
            <tr>
                <td><span>등록일 : </span></td>
                <td><input type="date" name="display_date" id="display_date" value="${BbsDTO.display_date}" /></td>
                <div id="reg_date_check_flag" style='display: <%=arr[1] ==0 ? "none": "block" %> '> 등록일을 입력해주세요. </div>
            </tr>
            <tr>
                <td><span>글 내용 : </span></td>
                <td><textarea name="content" id="content" rows="10" cols="80">${BbsDTO.content}</textarea></td>
                <div id="content_check_flag" style='display: <%=arr[2] ==0 ? "none": "block" %> '>내용을 입력해주세요.</div>
            </tr>
            <tr>
               <%-- <td><span>취미 : </span></td>
                <td>
                    <input type="checkbox" name="hobby" id="hobby_0" value="여행" /> 여행
                    <input type="checkbox" name="hobby" id="hobby_1" value="독서" /> 독서
                    <input type="checkbox" name="hobby" id="hobby_2" value="수영" /> 수영
                    <input type="checkbox" name="hobby" id="hobby_3" value="잠자기" /> 잠자기
                    <input type="checkbox" name="hobby" id="hobby_4" value="게임" /> 게임
                </td>
            </tr>--%>
         <%--   <tr>
                <td><span>성별 : </span></td>
                <td>
                    <input type="radio" name="sex" id="sex_0" value="남" /> 남
                    <input type="radio" name="sex" id="sex_1" value="여" /> 여
                </td>
            </tr>--%>
            <tr>
                <td colspan="2">
                    <button type="submit" id="update_button">수정</button>
                    <button type="button" onclick="location.href='/bbs/view?idx=1'">취소</button>
                </td>
            </tr>
        </table>
    </form>
    <script>
            const update_button = document.querySelector("#update_button");
            const title_check_flag = document.querySelector("#title_check_flag");
            update_button.addEventListener("click",function(e){
                e.preventDefault();
                const title =document.querySelector("#title").value.trim();
                const display_date =document.querySelector("#display_date").value.trim();
                const content =document.querySelector("#content").value.trim();

                if(title <1){
                    alert("제목을 입력해주세요.");
                    title_check_flag.style.display="block";
                    return false;
                }
                if(display_date<1){
                    alert("날짜를 입력해주세요.")
                    return false;
                }
                if(content <1){
                    alert("내용을 입력해주세요.")
                    return false;
                }

                document.frmModify.submit();

            });

    </script>
</div>
</body>
</html>
