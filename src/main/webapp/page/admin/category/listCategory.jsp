<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../include/header.jsp" />
<div class="container">
<%--    <div class="row clearfix">--%>
<%--        <div class="col-md-12 column">--%>
<%--            <ul class="nav nav-tabs">--%>
<%--                <li class="active">--%>
<%--                    <a href="#">首页</a>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <a href="#">简介</a>--%>
<%--                </li>--%>
<%--                <li class="disabled">--%>
<%--                    <a href="#">信息</a>--%>
<%--                </li>--%>
<%--                <li class="dropdown pull-right">--%>
<%--                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">下拉<strong class="caret"></strong></a>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="alert alert-success alert-dismissable">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4>
                    欢迎!
                </h4> 尊贵的用户${user.name}<a href="/admin_user_exitLogin" class="alert-link">退出登录</a>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>分类名称</th>
                    <th>编辑</th>
                    <th>删除</th>
                    <th>属性管理</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cs}" var="c" varStatus="st">
                <tr>
                    <td>${c.id}</td>
                    <td><a href="/admin_product_list?id=${c.id}">${c.name}</a></td>
                    <td>
                        <a href="/admin_category_edit?id=${c.id}">
                            <button type="button" class="btn btn-default btn-primary">编辑</button>
                        </a>
                    </td>
                    <td>
                            <button style="background-color: red" type="button" class="btn btn-default btn-primary delete-btn"
                            name="/admin_category_delete?id=${c.id}">删除</button>
                    </td>
                    <td>
                        <a href="/admin_property_list?id=${c.id}">
                            <button type="button" class="btn btn-default btn-primary">属性管理</button>
                        </a>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form class="form-horizontal" role="form" action="/admin_category_add">
                <div class="form-group">
                    <label for="categoryName" class="col-sm-2 control-label">分类名称</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="categoryName" name="name" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">添加</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script>
    $(function () {
        $('.delete-btn').click(function () {
            let url= $(this).attr("name");
            let that = $(this);
            $.get(
                url,
                function (result) {
                    if (result=="success"){
                        that.parent().parent().hide();
                    }else {
                        alert("出现错误，请刷新页面！")
                    }
                }
            )
        })
    })
</script>
</html>
