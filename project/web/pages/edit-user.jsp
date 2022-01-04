<%--
  Created by IntelliJ IDEA.
  User: taning
  Date: 2021/12/23
  Time: 18:31
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
            <li class="glyphicon glyphicon-th-large "><a href="/pages/home.jsp">首页</a>
            </li>
            <li class="glyphicon glyphicon glyphicon-user active"><a href="/find-user">用户管理</a></li>
            <li class="glyphicon glyphicon glyphicon-user"><a href="/find-product-by-page">产品管理</a></li>
            <li class="glyphicon glyphicon glyphicon-user"><a href="/find-order-by-page">订单管理</a></li>
        </ul>
    </aside>
    <div class="left">
        <header>
            <h4>用户管理</h4>
        </header>
        <main>
            <div class="center-block">
                <form action="/edit-user" method="post">
                    <span class="glyphicon glyphicon-remove close"> </span>
                    <div class="form-group input-group">
                        <span class="input-group-addon"  id="basic-addon1"> 姓名：</span>
                        <input type="text"  name="account" value="${user.account}" class="form-control" placeholder=""
                               aria-describedby="basic-addon1">
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon"  id="basic-addon1"> 密码：</span>
                        <input type="text"  name="account" value="${user.password}" class="form-control" placeholder=""
                               aria-describedby="basic-addon1">
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon"  id="basic-addon1"> 性别：</span>
                        <input type="text" name="sex" value="${user.sex}" class="form-control"
                               placeholder=""
                               aria-describedby="basic-addon1">
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon" id="basic-addon1"> 地址：</span>
                        <input type="text" name="address" value="${user.address}" class="form-control" placeholder=""
                               aria-describedby="basic-addon1">
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon" id="basic-addon1"> 出生日期：</span>
                        <input type="text" name="birthday" value="${user.birthday}" class="form-control" placeholder=""
                               aria-describedby="basic-addon1">
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon" id="basic-addon1"> 邮箱：</span>
                        <input type="email" name="email" value="${user.email}"
                               class="form-control"
                               placeholder=""
                               aria-describedby="basic-addon1">
                    </div>
                    <button type="submit" name="id" value="${user.id}">确定修改</button>
                    <button type="reset">重置</button>
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
