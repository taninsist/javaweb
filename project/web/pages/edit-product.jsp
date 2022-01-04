<%--
  Created by IntelliJ IDEA.
  User: taning
  Date: 2021/12/28
  Time: 18:12
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
<div class="container_default edit-user" id="edit-user">
    <aside>
        <div class="title">
            <h2 class="text-center">后台管理</h2>
        </div>
        <p>菜单</p>
        <ul class="nav">
            <li class="glyphicon glyphicon-th-large active"><a href="/pages/home.jsp">首页</a>
            </li>
            <li class="glyphicon glyphicon glyphicon-user"><a href="/find-user">用户管理</a></li>
            <li class="glyphicon glyphicon glyphicon-user"><a href="/project-manage">产品管理</a></li>
        </ul>
    </aside>
    <div class="left">
        <header>用户管理</header>
        <main>
            <div class="center-block">
                <form action="/edit-product" method="post">
                    <span class="glyphicon glyphicon-remove close"> </span>
                    <div class="form-group input-group">
                        <span class="input-group-addon" id="basic-addon1">产品编号：</span>
                        <input type="text" name="num" value="${product.productNum}" class="form-control" placeholder=""
                               aria-describedby="basic-addon1">
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon" id="basic-addon1">产品名称：</span>
                        <input type="text" name="name" value="${product.productName}" class="form-control"
                               placeholder=""
                               aria-describedby="basic-addon1">
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon" id="basic-addon1">城市：</span>
                        <input type="text" name="city" value="${product.cityName}" class="form-control" placeholder=""
                               aria-describedby="basic-addon1">
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon" id="basic-addon1">出发时间：</span>
                        <input type="date" name="departureTime" value="${product.departureTime}"
                               class="form-control"
                               placeholder=""
                               aria-describedby="basic-addon1">
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon" id="basic-addon1">价格：</span>
                        <input type="text" name="price" value="${product.productPrice}" class="form-control"
                               placeholder=""
                               aria-describedby="basic-addon1">
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon" id="basic-addon1">分类：</span>
                        <input type="text" name="sort" value="${product.productDesc}" class="form-control"
                               placeholder=""
                               aria-describedby="basic-addon1">
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon" id="basic-addon1">状态：</span>
                        <input type="text" name="status" value="${product.productStatus}" class="form-control"
                               placeholder=""
                               aria-describedby="basic-addon1">
                    </div>
                    <button class="btn btn-primary center-block" name="id" value="${product.id}">编 辑</button>
                    <button type="reset" class="btn btn-primary center-block">重 置</button>
                </form>
            </div>
        </main>
    </div>
</div>
<script src="/js/jquery-3.6.0.min.js"></script>
<script>


</script>

</body>
</html>
