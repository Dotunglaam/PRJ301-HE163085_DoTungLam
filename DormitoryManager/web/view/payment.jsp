<%-- 
    Document   : Payment
    Created on : Mar 12, 2023, 10:00:06 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment</title>
        <link href="css/payments.css" rel="stylesheet" type="text/css"/>
        <script>
            function paymentdelete(payment_id)
            {
                var a = confirm("are you sure?");
                if (a)
                {
                    window.location.href = 'paymentdelete?pid=' + payment_id;
                }
            }
        </script>
    </head>
    <body>
        <div><jsp:include page="menu.jsp"></jsp:include></div>
            <table class="table" border="1">
                <thead>
                    <tr>
                        <th>Payment_id</th>
                        <th>User_id</th>
                        <th>Room_id</th>
                        <th>Amount</th>
                        <th>Payment_date</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${payments}" var="p">
                    <tr>
                        <td>${p.payment_id}</td>
                        <td>${p.users.user_id}</td>
                        <td>${p.rooms.room_id}</td>
                        <td>${p.amount}</td>
                        <td>${p.payment_date}</td>
                        <td>${p.status}</td>
                        <td>   
                            <a href="paymentupdate?pid=${p.payment_id}">update</a>
                            <a href="#" onclick="paymentdelete(${p.payment_id})">delete</a>
                        </td>
                    </tr>
                </c:forEach>
        </tbody>

    </table>
    <a class="paymentcreate" href="paymentcreate">Create</a>
</body>
</html>
