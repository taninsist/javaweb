<%--
  Created by IntelliJ IDEA.
  User: taning
  Date: 2021/12/30
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <form class="center-block" method="post" action="/register">
            <div class="form-group input-group">
                <span class="input-group-addon" id="basic-addon1">姓名：</span>
                <input type="text" name="account" value="" class="form-control" placeholder=""
                       aria-describedby="basic-addon1">
            </div>
            <div class="form-group input-group">
                <span class="input-group-addon" id="basic-addon1">密码：</span>
                <input type="text" name="password" value="" class="form-control" placeholder=""
                       aria-describedby="basic-addon1">
            </div>
            <div class="form-group input-group">
                <span class="input-group-addon" id="basic-addon1">性别：</span>
                <input type="text" name="sex" value="" class="form-control" placeholder=""
                       aria-describedby="basic-addon1">
            </div>
            <div class="form-group input-group">
                <span class="input-group-addon" id="basic-addon1">地址：</span>
                <input type="text" name="address" value="" class="form-control" placeholder=""
                       aria-describedby="basic-addon1">
            </div>
            <div class="form-group input-group">
                <span class="input-group-addon" id="basic-addon1">出生日期：</span>
                <input type="date" name="birthday" value="" class="form-control" placeholder=""
                       aria-describedby="basic-addon1">
            </div>
            <div class="form-group input-group">
                <span class="input-group-addon" id="basic-addon1">邮箱：</span>
                <input type="email" name="email" value="" class="form-control" placeholder=""
                       aria-describedby="basic-addon1">
            </div>
            <button class="btn btn-primary center-block">注 册</button>
            <p class="text-right text-primary rigister"><a href="/pages/login.jsp">登 录</a></p>
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
