
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<html>
<head>
    <title>게시판 등록</title>
</head>
<body>
<h1>게시판 등록</h1>
<%

    int[] arr =((int[])request.getAttribute("list") !=null ?(int[])request.getAttribute("list") : new int[4]) ;
 int  result = (request.getAttribute("result") != null ? (int) request.getAttribute("result") : 0);

     %>

<div>
    <form name="frmRegist" id="frmRegist" method="post" action="/bbs/regist">
        <input type="hidden" name="user_id" id="user_id" value="test">
        <table>
            <tr>
                <td><span>제목 : </span></td>
                <td><input type="text" name="title" id="title" value="" maxlength="200" placeholder="글 제목을 입력하세요."/></td>
                <div id="title_check_flag" style='display: <%=arr[0] ==0 ? "none": "block" %> '>제목을 입력해주세요. </div>
            </tr>
            <tr>
                <td><span>등록일 : </span></td>
                <td><input type="date" name="display_date" id="display_date" value="" /></td>
                <div id="reg_date_check_flag" style='display: <%=arr[1] ==0 ? "none": "block" %> '> 등록일을 입력해주세요. </div>
            </tr>
            <tr>
                <td><span>글 내용 : </span></td>
                <td><textarea name="content" id="content" rows="10" cols="80"></textarea></td>
                <div id="content_check_flag" style='display: <%=arr[2] ==0 ? "none": "block" %> '>내용을 입력해주세요. </div>

            </tr>
            <div id="result" style='display:<%= result != 1 ? "none" :"block" %>'> 삽입 오류가 생겼습니다. </div>
           <tr>
                <td><span>취미 : </span></td>
                <td>
                    <input type="checkbox" name="hobby" id="hobby_0" value="여행" /> 여행
                    <input type="checkbox" name="hobby" id="hobby_1" value="독서" /> 독서
                    <input type="checkbox" name="hobby" id="hobby_2" value="수영" /> 수영
                    <input type="checkbox" name="hobby" id="hobby_3" value="잠자기" /> 잠자기
                    <input type="checkbox" name="hobby" id="hobby_4" value="게임" /> 게임
                </td>
                <div id="check_box_flag" style='display: <%=arr[3] ==0 ? "none": "block" %> '>체크박스를 선택해주세요. </div>
            </tr>
            <tr>
                <td><span>성별 : </span></td>
                <td>
                    <input type="radio" name="sex" id="sex_0" value="남" /> 남
                    <input type="radio" name="sex" id="sex_1" value="여" /> 여
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit" id ="form_submit">등록</button>
                    <button type="reset">취소</button>
                </td>
            </tr>
        </table>
    </form>
</div>
<script>


/*const check_box = document.getElementsByName("hobby");
const radio_box = document.getElementsByName("sex");


console.log(check_box);
var box_check =true;
var num =0;

for(let i =0; i< check_box.length; i++){

    if(check_box[i].checked ==true){

        num ++;

    }
    if(num<1){
        box_check=false;
    }
}

const form_submit = document.querySelector("#form_submit");
form_submit.addEventListener("click",function(e){
   e.preventDefault();

   if( !(box_check)){
       alert("체크박스를 입력해주세요.");
       return false;
   }

   document.frmRegist.submit();
});*/

</script>
</body>
</html>
