<%-- 
    Document   : login
    Created on : Feb 9, 2023, 5:53:35 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="../css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="text">
            <h1>Login</h1>
            <h2>Dormitory System<h2>
                    <hr/ style="margin: 0">
                    </div>

                    <form action="login" method="POST">
                        <table class="table" border="0">
                            <tbody>
                                <tr>
                                    <td>Username</td>
                                    <td><input type="text" name="user"/></td>
                                </tr>
                                <tr>
                                    <td>Password</td>
                                    <td><input type="password" name="pass"/></td>
                                </tr>
                                <tr>
                                    <td>Campus Code</td>
                                    <td >
                                        <select  <input type="text" name="name">
                                            <option>Hòa Lạc     </option>
                                            <option>Cần Thơ     </option>
                                            <option>Hồ Chí Minh </option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input id="submmit" type="submit" value="Login" /></td>                                  
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><a id="register" href="register" >Tạo tài khoản mới</a> </td>
                                    
                                </tr>
                            </tbody>
                        </table>

                    </form>
                    <hr/ style="margin-left: 178px ">
                    </body>
                    </html>
