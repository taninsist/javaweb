<%--
  Created by IntelliJ IDEA.
  User: taning
  Date: 2021/12/29
  Time: 10:21
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
            <li class="glyphicon glyphicon-th-large"><a href="/pages/home.jsp">首页</a>
            </li>
            <li class="glyphicon glyphicon glyphicon-user"><a href="/find-user">用户管理</a></li>
            <li class="glyphicon glyphicon glyphicon-user"><a href="/find-product-by-page">产品管理</a></li>
            <li class="glyphicon glyphicon glyphicon-user active"><a href="/find-order-by-page">订单管理</a></li>
        </ul>
    </aside>
    <div class="left">
        <header>订单编辑</header>

        <main>
            <div class="center-block">
                <form action="/edit-order" method="post">
                    <span class="glyphicon glyphicon-remove close"> </span>
                    <div class="form-group input-group">
                        <span class="input-group-addon"  id="basic-addon1">产品名称：</span>
                        <input type="text" name="num" disabled value="${order.productName}" class="form-control" placeholder=""
                               aria-describedby="basic-addon1">
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon"  id="basic-addon1">下单用户：</span>
                        <input type="text" name="name"  disabled   value="${order.userName}" class="form-control"
                               placeholder=""
                               aria-describedby="basic-addon1">
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon" id="basic-addon1">支付状态(0:未支付;1:已支付)：</span>
                        <input type="text" name="status" value="${order.status}" class="form-control" placeholder=""
                               aria-describedby="basic-addon1">
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon" id="basic-addon1">备注：</span>
                        <input type="text" name="desc" value="${order.desc}" class="form-control" placeholder=""
                               aria-describedby="basic-addon1">
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon" id="basic-addon1">订单时间：</span>
                        <input type="date" name="departureTime" disabled value="${order.date}"
                               class="form-control"
                               placeholder=""
                               aria-describedby="basic-addon1">
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon" id="basic-addon1">支付类型(0:支付宝;1:微信;2:其他)：</span>
                        <input type="text" name="payType" value="${order.payType}" class="form-control"
                               placeholder=""
                               aria-describedby="basic-addon1">
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon" id="basic-addon1">订单编号：</span>
                        <input type="text" name="sort" disabled value="${order.num}" class="form-control"
                               placeholder=""
                               aria-describedby="basic-addon1">
                    </div>

                    <button class="btn btn-primary center-block" name="id" value="${order.id}">编 辑</button>
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
