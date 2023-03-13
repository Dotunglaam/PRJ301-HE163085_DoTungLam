<%-- 
    Document   : home
    Created on : Mar 9, 2023, 7:03:43 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link href="css/homeAdmin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div><jsp:include page="menu.jsp"></jsp:include></div>

        <table class="table" border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>USER_ID</th>
                        <th>ROOM_ID</th>
                        <th>PAYMENT_ID</th>
                        <th>[Room registration date</th>
                        <th>[Cancellation date]</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${dorm}" var="d">
                    <tr>
                         <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>   
                        <a href="update?sid=${s.id}">update</a>
                        <a href="#" onclick="deleteStudent(${s.id})">delete</a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
        </table>
        <a class="create" href="create">Create</a>
    </body>
</html>
