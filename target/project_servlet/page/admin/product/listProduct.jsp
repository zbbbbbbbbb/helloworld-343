<%--
  Created by IntelliJ IDEA.
  User: 周博
  Date: 2023-04-04
  Time: 0:10
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
    <jsp:include page="../include/header.jsp" />
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table">
                <thead>
                <tr>
                    <th>商品图片</th>
                    <th>商品名称</th>
                    <th>商品小标题</th>
                    <th>商品原价</th>
                    <th>商品优惠价</th>
                    <th>库存</th>
                    <th>商品创建时间</th>
                    <th>编辑</th>
                    <th>删除</th>
                    <th>图片管理</th>
                    <th>属性值设置</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pro}" var="p" varStatus="st">
                    <tr>
                        <td><img width="100px" height="50px" src="${p.images.get(0).url}"></td>
                        <td>${p.name}</td>
                        <td>${p.subTitle}</td>
                        <td>${p.originalPrice}</td>
                        <td>${p.promotePrice}</td>
                        <td>${p.stock}</td>
                        <td>${p.createDate}</td>
                        <td>
                            <a href="/admin_product_edit?id=${p.id}">
                                <button type="button" class="btn btn-default btn-primary">编辑</button>
                            </a>
                        </td>
                        <td>
                            <button style="background-color: red" type="button"
                                    class="btn btn-default btn-primary delete-btn"
                                    name="/admin_product_delete?id=${p.id}">删除
                            </button>
                        </td>
                        <td>
                            <a href="/admin_image_list?id=${p.id}">
                                <button type="button" class="btn btn-default btn-primary">编辑</button>
                            </a>
                        </td>
                        <td>
                            <a href="/admin_propertyValue_list?id=${p.id}">
                                <button type="button" class="btn btn-default btn-primary">编辑</button>
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
            <form class="form-horizontal" role="form" action="/admin_product_add" method="post">
                <div class="form-group">
                    <label for="cid" class="col-sm-2 control-label"></label>
                    <div class="col-sm-10">
                        <input type="hidden" class="form-control" id="cid" name="cid" value="${cid}" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="productName" class="col-sm-2 control-label">商品名称</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="productName" name="name" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="subTitle" class="col-sm-2 control-label">商品小标题</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="subTitle" name="subTitle" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="originalPrice" class="col-sm-2 control-label">商品原价</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="originalPrice" name="originalPrice" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="promotePrice" class="col-sm-2 control-label">商品优惠价</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="promotePrice" name="promotePrice" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="stock" class="col-sm-2 control-label">库存</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="stock" name="stock" />
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
