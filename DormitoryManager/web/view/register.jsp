<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link href="css/register.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div>
            <h1>Tạo tài khoản mới</h1>

            <div class="register">
                <form class="form" action="register" method="POST">
                    <input class="textbox" type="text" placeholder="Tên" name="displayname" required=""/> <br/>
                    <input class="textbox" type="text" placeholder="Tài Khoản" name="username" required=""/> <br/>
                    <input class="textbox" type="password" placeholder="Mật Khẩu" name="password" required=""/> <br/>
                    <input class="textbox" type="password" placeholder="Nhập lại mật khẩu" name="repassword" required><br>
                    <div class="gender">
                        <input type="radio" name="gender" 
                                <c:if test="${user.gender}">
                                    checked="checked" 
                                </c:if>
                                value="male"/> Male 
                        <input type="radio" name="gender"
                                <c:if test="${!user.gender}">
                                    checked="checked" 
                                </c:if>
                                value="female"/> Female <br/>
                    </div>
                    <input class="textbox" type="date" name="dob" required=""/> <br/>
                    <input class="textbox" type="number" placeholder="SDT" name="phone" required=""/> <br/>
                    <p >${registerFailed}</p>
                    <input id="register" type="submit" value="Đăng Ký" /><br>
                    <a id="login" href="login">Bạn đã có tài khoản?</a><br>
                </form>
            </div>
        </div>
    </body>
</html>
