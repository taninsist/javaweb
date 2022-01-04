<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: taning
  Date: 2021/12/22
  Time: 13:40
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
<body style="position: relative">
<div class="container_default" id="main">
    <aside>
        <div class="title">
            <h2 class="text-center">企业权限管理系统</h2>
        </div>
        <p>菜单</p>
        <ul class="nav">
            <li class="glyphicon glyphicon-th-large"><a href="/pages/home.jsp">首页</a>
            </li>
            <li class="glyphicon glyphicon glyphicon-user active"><a href="">用户管理</a></li>
            <li class="glyphicon glyphicon-folder-open"><a href="/product-manage">产品管理</a></li>
            <li class="glyphicon glyphicon-signal"><a href="/find-order-by-page">订单管理</a></li>
            <li class="glyphicon glyphicon-pawn "><a href="/">退出</a></li>
        </ul>
    </aside>
    <div class="left">
        <header >
            <h4>用户管理</h4>
        </header>
        <main style="overflow: hidden">
            <div class="tools-area" style="margin: 20px 20px;">
                <span class="show-add-pan">
                    <button type="button" class="btn btn-primary glyphicon glyphicon-plus-sign">
                        <span style="position: relative;top: -2px">添加</span>
                    </button>
                </span>
                <span class="batch">
                    <button type="button" class="btn btn-danger glyphicon glyphicon-trash batch">
                        <span style="position: relative;top: -2px">批量删除</span>
                    </button>
                </span>
            </div>
            <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                <thead>
                <tr>
                    <th><input name="ids" type="checkbox" value="${u.id}"></th>
                    <th class="sorting_asc">序号</th>
                    <th class="sorting_desc">姓名</th>
                    <th class="sorting_asc sorting_asc_disabled">密码</th>
                    <th class="sorting_desc sorting_desc_disabled">性别</th>
                    <th class="sorting">地址</th>
                    <th class="text-center sorting">出生日期</th>
                    <th class="text-center">邮箱</th>
                    <th class="text-center">操作</th>
                </tr>
                </thead>
                <tbody>

                <form action="/batch-del-user" method="post" class="batch-form">
                    <%--                    <jsp:useBean id="userList" scope="request" type="java.util.List"/>--%>
                    <c:forEach items="${userList}" var="u" varStatus="i">
                        <tr>
                            <td><input name="ids" type="checkbox" value="${u.id}"></td>
                            <td>${(i.index+1)+(current - 1) * limit}</td>
                            <td>${u.account}</td>
                            <td>${u.password}</td>
                            <td>${u.sex}</td>
                            <td>${u.address}</td>
                            <td class="text-center">${u.birthday}</td>
                            <td class="text-center">${u.email}</td>
                            <td class="text-center">
                                <a href="/to-edit-user?id=${u.id}">编辑</a>
                                <input value="${u.id}" type="hidden">
                                <button type="button" class="btn btn-danger btn-xs delBtn">删除</button>
                            </td>
                        </tr>

                    </c:forEach>
                </form>
                </tbody>
            </table>
            <%--   删除   --%>
            <form method="get" action="/delUser" class="delUserForm">
                <input name="id" value="2" type="hidden">
            </form>
            <%--    分页  --%>
            <style>
                .pagination > li > a > button {
                    border: none;
                    background: none;
                    padding: 6px 12px;
                }

                .pagination > li > a > button[disabled] {
                    background: #d9d6d6;
                    cursor: no-drop;
                }

                .pagination > li > a {
                    padding: 0;
                }
            </style>
            <nav aria-label="Page navigation">

                <form action="/findUserByPage">
                    <ul class="pagination">
                        <%--                        <c:if test="${(current-1)< 1}">--%>
                        <%--                        <p style="float: left">总数：${Math.ceil(total / 10)}</p>--%>
                        <li>
                            <a href="#" aria-label="Previous">
                                <button ${(current-1) <= 0?"disabled" : ""} name="current" value="${current - 1}">
                                    &laquo;
                                </button>
                            </a>

                            <a href="/selectUserSerlet?current=${current-1}"></a>
                        </li>
                        <c:forEach begin="1" end="${maxPage}" varStatus="i">
                            <li class="${current == i.index? "active":""}">
                                <a>
                                    <button name="current" value="${i.index}">${i.index}</button>
                                </a>
                            </li>
                        </c:forEach>
                        <%--           下一页                 --%>
                        <li>
                            <a aria-label="Next">
                                <button ${(current) >= maxPage?"disabled" : ""} name="current" value="${current + 1}">
                                    &raquo;
                                </button>
                            </a>
                        </li>
                        <input name="q" value="${keyword}" style="position: relative;top: 2px;margin-left: 20px"
                               placeholder="账号 密码 邮箱 性别 地址">
                        <button type="submit" class="btn btn-info glyphicon glyphicon-zoom-in" name="flag"
                                value="searchUser">
                            搜索
                        </button>
                    </ul>
                </form>

            </nav>

        </main>
    </div>
</div>
<style>

    .add-user-pan {
        position: absolute;
        top: 0;
        width: 100%;
        height: 100%;
        background: rgba(0, 0, 0, .5);
        display: none;
    }

    .add-user-pan form {
        transform: translateY(50%);
        width: 350px;
        padding: 70px 40px 50px;
        background: #fff;
        top: 50%;
    }

    .add-user-pan span.close {
        color: red;
        position: absolute;
        top: 20px;
        right: 20px;
        font-size: 20px;
        cursor: pointer;
        opacity: 1;

    }
</style>
<div class="add-user-pan">
    <form class="center-block" method="post" action="/register">
        <span class="glyphicon glyphicon-remove close"> </span>
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
        <button class="btn btn-primary center-block">添 加</button>
    </form>
</div>

<script src="/js/jquery-3.6.0.min.js"></script>
<script>

    let bodyH = $("body").height();
    let addPan = $(".add-user-pan");

    $(".delBtn").on("click", function () {
        let id = $(this).prev()[0].value;

        let form = $("form.delUserForm")[0];
        $("input[name=id]")[0].value = id;


        form.submit();
    })

    //取消冒泡
    $(".center-block").on("click", function (e) {
        e.stopPropagation()
    })

    $(".show-add-pan").on("click", function () {

        addPan.slideDown();
    })

    $(".add-user-pan").on("click", function (e) {
        console.log(e)
        $(this).slideUp()

    })

    $(".add-user-pan span.close").on("click", function (e) {

        addPan.slideUp()
    })

    //批量删除
    $(".batch").on("click", function () {
        $("form.batch-form").submit();
    })


    function init() {
        //添加面板事件
        window.addEventListener("resize", function () {
            bodyH = $("body").height();
        })

    }

    init()
</script>

</body>
</html>
