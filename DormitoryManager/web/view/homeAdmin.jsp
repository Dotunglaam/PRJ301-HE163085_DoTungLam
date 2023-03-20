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
        <script>
            function infordelete(in_id)
            {
                var a = confirm("are you sure?");
                if (a)
                {
                    window.location.href = 'infordelete?inid=' + in_id;
                }
            }
        </script>
    </head>
    <body>
        <div><jsp:include page="menu.jsp"></jsp:include></div>
            
        <table class="table" border="1">
                <thead>
                    <tr>
                        <th>IN_ID</th>
                        <th>NAME</th>
                        <th>ROOM_NAME</th>
                        <th>FLOOR</th>
                        <th>PAYMENT_ID</th>
                        <th>[Room registration date</th>
                        <th>[Cancellation date]</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${infor}" var="i">
                    <tr>
                        <td>${i.in_id}</td>
                        <td>${i.getUsers().full_name}</td>
                        <td>${i.getRooms().name}</td>
                        <td>${i.getRooms().floor}</td>
                        <td>${i.getPayments().payment_id}</td>
                        <td>${i.room_registration_date}</td>
                        <td>${i.cancellation_date}</td>
                        <td>   
                            <a href="inforupdate?inid=${i.in_id}">update</a>
                            <a href="#" onclick="infordelete(${i.in_id})">delete</a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
        </table>
    </body>
</html>
