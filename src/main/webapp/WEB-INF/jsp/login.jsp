<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <link rel="shortcut icon" href="static/images/title.jpg" type="image/x-icon">
    <title>SpringBoot</title>
    <style>
        #form-div {
            text-align: center;
        }

        #form-div {
            margin-top: 300px;
        }

        body {
            background-image: url("static/images/login.jpg");
            background-repeat: no-repeat;
            background-size: 100% 100%;
        }

        html {
            height: 100%;
            width: 100%;
        }

        p {
            color: yellowgreen;
            font-weight: 700;
        }
    </style>
</head>
<body>
<div id="form-div">
    <form id="form1" method="post" action="/login">
        <p>用户名：<input name="username" type="text" size="25" value="" style="font-family: 楷体"/></p>
        <p>密　码：<input name="password" type="password" size="25" value="" style="font-family: 楷体"/></p>
        <p><input type="submit" value="登    录" onclick="login()"
                  style="width:181px;margin-left:63px;height: 27px;font-family: 楷体;font-size: 17px">
        </p>
    </form>
</div>
</body>
</html>
