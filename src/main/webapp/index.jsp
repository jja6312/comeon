<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 페이지</title>
    <script type="text/javascript">
        window.onload=function(){
            const name = "${loginMember.name}";
            alert(name);
            if(!name){
                alert("이름이 없습니다");
            }
        }
    </script>
</head>
<body>

<div class="loginContainer">
    <%
        String userName = (String) session.getAttribute("name");
        if (userName != null) {
    %>
    <!-- 세션에 로그인 정보가 있을 경우 환영 메시지 표시 -->
    <h1><%= userName %>님 환영합니다!</h1>
    <a href="index.jsp">홈으로</a>
    <%
    } else {
    %>
    <!-- 로그인 폼 (세션 정보가 없을 경우) -->
    <form action="main" method="post">
        <input name="sign" value="login" hidden>
        <label for="id">ID:</label>
        <input id="id" name="id" type="text"><br>
        <label for="pw">PW:</label>
        <input id="pw" name="pw" type="text"><br>
        <input type="submit" value="로그인">
    </form>
    <% } %>
</div>

</body>
</html>
