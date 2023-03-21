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
        <title>Menu</title>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="header">   
            <hr/>
            <ul class="header_ul"> 
                <li>Dormitory </li>
                <c:if test="${sessionScope.User.role_id == 2}">
                    <li>
                        <a href="home">Hello User:  ${sessionScope.User.full_name}</a>
                    </li>
                </c:if> 
                    
                <c:if test="${sessionScope.User.role_id == 1}">
                    <li>
                        <a href="homea">Hello Admin:  ${sessionScope.User.full_name}</a>
                    </li>
                </c:if>
                
                <c:if test="${sessionScope.User.role_id == 1}">    
                <form action="search">
                    <input type="text" name="txt" placeholder="Search" />
                    <input type="submit" value="Search">
                </form>
                </c:if>
                    
                <c:if test="${sessionScope.User != null}">
                    <li>
                        <a href="logout">Logout</a>
                    </li>
                </c:if>  
            </ul>
            <hr/>
            <div class="menu">
                <c:if test="${sessionScope.User.role_id == 2}">
                    <li>
                        <a href="home">Home</a>
                </c:if>    
                <c:if test="${sessionScope.User.role_id == 1}">
                    <li>
                        <a href="homea">Home</a>
                    </li>
                    <li>
                        <a href="student">Danh Sách sinh viên</a>
                    </li>
                    <li>
                        <a href="room">Danh sách phòng</a>
                    </li> 
                    <li>
                        <a href="payment">Hóa Đơn</a>
                    </li>
                    <li>
                        <a href="dorm">Danh sách Dormitories</a>
                    </li>
                </c:if>    
            </div>
        </div>
    </body>
</html>
