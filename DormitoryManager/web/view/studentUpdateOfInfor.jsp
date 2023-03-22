<%-- 
    Document   : studentUpdateOfInfor
    Created on : Mar 22, 2023, 10:30:14 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                text-align: center;
                justify-content: center;
                font-size: 30px;
            }
            .error{
                color: red;
            }
            table{
                margin: auto;
                margin-top: 20%;
            }
            input{
                height: 30px;
                font-size: 20px;
            }
            .error{
                color: red;
            }
        </style>
    </head>
    <body>
        <form action="update" method="POST">
            <table border="0.5">
                <tbody>
                    <tr>

                        <td>User_id:</td>
                        <td><input type="text" readonly="" name="user_id" value="${user.getUser_id()}" /></td>

                    </tr>
                    <tr>
                        <td>Full_name:</td>
                        <td><input type="text" name="full_name" value="${user.full_name}"></td>
                    </tr>
                    <tr>
                        <td>Gender:</td>
                        <td>
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
                        </td>
                    </tr>
                    <tr>
                        <td>Dob</td>
                        <td><input type="date" required name="dob" value="${user.dob}"></td>
                    </tr>
                    <tr>
                        <td>phone</td>
                        <td><input type="text" name="phone" value="${user.phone}"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Save"></td>
                    </tr>
                </tbody>
            </table>
                    <div class="error">
                        ${error}
                    </div>
            <br/>

        </form>
    </body>
</html>
