<%--
  Created by IntelliJ IDEA.
  User: 周博
  Date: 2023-04-04
  Time: 11:31
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
    <form class="form-horizontal" role="form" action="/admin_product_update" method="post">
        <div class="form-group">
            <label for="id" class="col-sm-2 control-label"></label>
            <div class="col-sm-10">
                <input type="hidden" class="form-control" id="id" name="id" value="${pro.id}" />
            </div>
        </div>
        <div class="form-group">
            <label for="productName" class="col-sm-2 control-label">商品名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="productName" name="name" value="${pro.name}"/>
            </div>
        </div>
        <div class="form-group">
            <label for="subTitle" class="col-sm-2 control-label">商品小标题</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="subTitle" name="subTitle" value="${pro.subTitle}" />
            </div>
        </div>
        <div class="form-group">
            <label for="originalPrice" class="col-sm-2 control-label">商品原价</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="originalPrice" name="originalPrice" value="${pro.originalPrice}" />
            </div>
        </div>
        <div class="form-group">
            <label for="promotePrice" class="col-sm-2 control-label">商品优惠价</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="promotePrice" name="promotePrice" value="${pro.promotePrice}" />
            </div>
        </div>
        <div class="form-group">
            <label for="stock" class="col-sm-2 control-label">库存</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="stock" name="stock" value="${pro.stock}"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">更新</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
