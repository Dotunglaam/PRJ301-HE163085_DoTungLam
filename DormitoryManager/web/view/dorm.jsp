<%-- 
    Document   : dorm
    Created on : Mar 11, 2023, 4:48:09 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dorm</title>
        <link href="css/dorm.css" rel="stylesheet" type="text/css"/>
        <script> 
            function deleteDorm(dormitory_id)
            {
                var a = confirm("are you sure?");
                if(a)
                {
                    window.location.href='dormdelete?did='+ dormitory_id;
                }
            }
        </script>
    </head>
    <body>
        <div><jsp:include page="menu.jsp"></jsp:include></div>
            <table class="table" border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                    </tr>
                </thead>
            <tbody>
                <c:forEach items="${dorm}" var="d">
                    <tr>
                        <td>${d.dormitory_id}</td>
                        <td>${d.name}</td>
                        <td>   
                            <a href="dormupdate?did=${d.dormitory_id}">update</a>
                            <a href="#" onclick="deleteDorm(${d.dormitory_id})">delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            
            </table>
            <a class="dormcreate" href="dormcreate">Create</a>
    </body>
</html>
