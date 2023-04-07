<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 周博
  Date: 2023-04-03
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="container">
    <jsp:include page="../include/header.jsp" />
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table">
                <thead>
                <tr>
                    <th>属性id</th>
                    <th>属性名称</th>
                    <th>编辑</th>
                    <th>删除</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pr}" var="c" varStatus="st">
                    <tr>
                        <td>${c.id}</td>
                        <td>${c.name}</td>
                        <td>
                            <a href="/admin_property_edit?id=${c.id}">
                                <button type="button" class="btn btn-default btn-primary">编辑</button>
                            </a>
                        </td>
                        <td>
                            <button style="background-color: red" type="button"
                                    class="btn btn-default btn-primary delete-btn"
                                    name="/admin_property_delete?id=${c.id}">删除
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="row clearfix">
    <div class="col-md-12 column">
        <form class="form-horizontal" role="form" action="/admin_property_add" method="post">
            <div class="form-group">
                <label for="propertyName" class="col-sm-2 control-label">属性名称</label>
                <div class="col-sm-10">
                    <input type="hidden" name="cid" value="${pr.get(0).category.id}" >
                    <input type="text" class="form-control" id="propertyName" name="name" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default" >添加</button>
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
