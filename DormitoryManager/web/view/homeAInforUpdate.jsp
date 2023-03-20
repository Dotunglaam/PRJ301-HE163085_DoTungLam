<%-- 
    Document   : homeAInfor
    Created on : Mar 19, 2023, 8:19:22 PM
    Author     : ADMIN
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Infor</title>
        <link href="css/updatePayment.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body>
        <body>
        <form action="inforupdate" method="POST">
            <table border="0.5">
                <tbody>
                    <tr>
                        <td>IN_ID</td>
                        <td><input type="text" name="id" value="${in.in_id}"/> <br/></td>
                    </tr>
                    <tr>
                        <td>Room registration date</td>
                        <td><input type="date" name="rrd" value="${in.room_registration_date}"/> <br/></td>
                    </tr>
                    <tr>
                        <td>Cancellation date</td>
                        <td><input type="date" name="cd" value="${in.cancellation_date}"/></td>
                    </tr>
                     <tr>
                        <td></td>
                        <td><input type="submit" value="Create"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="error">${error}</td>
                    </tr>
                </tbody>
            </table>
            <br/>
           
        </form>
    </body>
    </body>
</html>
