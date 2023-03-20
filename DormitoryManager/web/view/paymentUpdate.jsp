<%-- 
    Document   : updatePayment
    Created on : Mar 12, 2023, 10:36:10 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Update</title>
        <link href="css/updatePayment.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="paymentupdate" method="POST">
            <table border="0.5">
                <tbody>

                    <tr>
                        <td>Payment_id: </td>
                        <td><input type="text" readonly name="pid" value="${pay.getPayment_id()}"/></td>
                    </tr>
                    <tr>
                        <td>User_id: </td>
                        <td><input type="text" name="user_id" value="${pay.users.user_id}"/></td>
                    </tr>
                    <tr>
                        <td>Room_id:</td>
                        <td><input type="text" name="room_id" value="${pay.getRooms().getRoom_id()}"/></td>
                    </tr>
                    <tr>
                        <td>Amount</td>
                        <td><input type="number" name="amount" value="${pay.getAmount()}"/></td>
                    </tr>
                    <tr>
                        <td>Payment_date</td>
                        <td><input type="date" name="date" value="${pay.getPayment_date()}"/> <br/></td>
                    </tr>
                    <tr>
                        <td>Status</td>
                        <td><input type="text" name="status" value="${pay.getStatus()}"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Save"></td>
                    </tr>
                </tbody>
            </table>
            <br/>

        </form>
    </body>
</html>
