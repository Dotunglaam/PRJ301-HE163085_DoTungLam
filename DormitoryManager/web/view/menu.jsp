<%-- 
    Document   : menu
    Created on : Mar 3, 2023, 9:57:02 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul>
            <li>Dormitory </li>
            <c:if test="${sessionScope.User != null}">
                <li>
                    <a href="#">Hello ${sessionScope.User.full_name}</a>
                </li>
                <li>
                    <a href="logout">Logout</a>
                </li>
            </c:if>
            <c:if test="${sessionScope.User != null}">
                <li>
                    <a href="#">Hello ${sessionScope.User.full_name}</a>
                </li>
                <li>
                    <a href="logout">Logout</a>
                </li>
            </c:if>
        </ul>
    </body>
</html>
