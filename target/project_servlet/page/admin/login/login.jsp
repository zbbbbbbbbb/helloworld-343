
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center text-success">
                欢迎来到简略版后台管理系统
            </h3>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-4 column">
            <img width="100px" height="100px" src="../login/login1.jpg" />
        </div>
        <div class="col-md-4 column">
            <form role="form" action="/admin_user_login" method="post">
                <div class="form-group">
                    <label for="exampleInputEmail1">用户:</label><input type="text" name="username" class="form-control" id="exampleInputEmail1" />
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">密码:</label><input type="password" name="password" class="form-control" id="exampleInputPassword1" />
                </div>
                <button typeof="submit" class="btn_btn-default">登录</button>
            </form>
        </div>
        <div class="col-md-4 column">
            <img width="100px" height="100px" src="../login/login2.jpg" />
        </div>
    </div>
</div>
</body>
</html>
