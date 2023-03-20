<%-- 
    Document   : createPayment
    Created on : Mar 12, 2023, 10:35:00 PM
    Author     : ADMIN
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/createPayment.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Payment</title>
    </head>
    <body>
        <form action="paymentcreate" method="POST">
            <table border="0.5">
                <tbody>
                    <tr>
                        <td>User_id: </td>
                        <td><input type="text" name="user_id"/></td>
                    </tr>
                    <tr>
                        <td>Room_id:</td>
                        <td><input type="text" name="room_id"/></td>
                    </tr>
                    <tr>
                        <td>Amount</td>
                        <td><input type="text" name="amount"/></td>
                    </tr>
                    <tr>
                        <td>Payment_date</td>
                        <td><input type="date" name="date"/> <br/></td>
                    </tr>
                    <tr>
                        <td>Status</td>
                        <td><input type="text" name="status"/></td>
                    </tr>
                     <tr>
                        <td></td>
                        <td><input type="submit" value="Create"></td>
                    </tr>
                </tbody>
            </table>
            <br/>
           
        </form>
    </body>
</html>
