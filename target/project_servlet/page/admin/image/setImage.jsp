<%--
  Created by IntelliJ IDEA.
  User: 周博
  Date: 2023-04-06
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <jsp:include page="../include/header.jsp"/>
    <div class="row clearfix">
        <div class="col-md-12 column">

            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>
                        图片
                    </th>
                    <th>
                        删除
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${images}" var="c" varStatus="st">
                    <tr>
                        <td>
                            <img height="200px" width="200px" src="${c.url}">
                        </td>
                        <td>
                            <button type="button" class="btn btn-default btn-danger delete-btn" id="${c.id}">删除
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" action="/admin_image_insert" method="post">
                <div class="form-group">
                    <label for="url">提交图片url路径：</label>
                    <input type="hidden" name="pid" value="${pid}"/>
                    <input type="type" class="form-control" id="url" name="url"/>
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
<script>
    $(function () {
        $('.delete-btn').click(function () {
            let id = $(this).attr("id");
            let url = "/admin_image_delete?id=" + id;
            let that = $(this);
            $.get(
                url,
                function (result) {
                    if (result == "success") {
                        that.parent().parent().hide();
                    } else {
                        alert("出现错误，请刷新页面！")
                    }
                }
            )
        })
    })
</script>
</html>
