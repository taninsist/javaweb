<%--
  Created by IntelliJ IDEA.
  User: taning
  Date: 2021/12/23
  Time: 15:47
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
<div class="container_default" id="main">
    <aside>
        <div class="title">
            <h2 class="text-center">后台管理</h2>
        </div>
        <p>菜单</p>
        <ul class="nav">
            <li class="glyphicon glyphicon-th-large active"><a href="/pages/home.jsp">首页</a>
            </li>

            <li class="glyphicon glyphicon glyphicon-user"><a href="/find-user">用户管理</a></li>
            <li class="glyphicon glyphicon-folder-open"><a href="/product-manage">产品管理</a></li>
            <li class="glyphicon glyphicon-signal"><a href="/find-order-by-page">订单管理</a></li>
            <li class="glyphicon glyphicon-pawn "><a href="/">退出</a></li>
        </ul>
    </aside>
    <div class="left">
<%--        <header>用户管理</header>--%>
        <main id="home" style="height: 100%;">
           <img src="../img/ban.jpg" width="100%" height="100%">
        </main>
    </div>
</div>
<script src="/js/jquery-3.6.0.min.js"></script>
<script>


</script>

</body>
</html>
