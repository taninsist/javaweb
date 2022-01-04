<%--
  Created by IntelliJ IDEA.
  User: taning
  Date: 2021/12/20
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../bootstrap-3.4.1-dist/bootstrap.min.css">
    <link rel="stylesheet" href="../css/index.css">
    <title>Document</title>
</head>

<body>
<div class="container">
    <div class="wrap" id="login">
        <h1 class="text-center"><b>企业</b>权限管理系统</h1>
        <form class="center-block" method="post" action="/loginServlet">
            <div class="form-group input-group">
                <span class="input-group-addon" id="basic-addon1">账号：</span>
                <input type="text" name="account" value="tan" class="form-control" placeholder=""
                       aria-describedby="basic-addon1">
            </div>
            <div class="form-group input-group">
                <span class="input-group-addon" id="basic-addon1">密码：</span>
                <input type="text" name="password" value="123" class="form-control" placeholder=""
                       aria-describedby="basic-addon1">
            </div>
            <div class="form-group input-group">
                <span class="input-group-addon " id="basic-addon1">验证码：</span>
                <input type="text" class=" authCode" name="authcode" placeholder="" aria-describedby="basic-addon1">
                <img id="codeImg" src="${pageContext.request.contextPath}/servlet/ImageServlet"
                     style="position: relative;z-index: 99">

            </div>
            <button class="btn btn-primary center-block">登录</button>
            <p class="text-right text-primary rigister"><a href="/pages/register.jsp">注 册</a></p>
        </form>
    </div>
</div>
<script>
    let codeImg = document.getElementById("codeImg");


    codeImg.onclick = function () {
        this.src = "${pageContext.request.contextPath}/servlet/ImageServlet?" + new Date();
    }

</script>

</body>

</html>
