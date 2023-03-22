<%-- 
    Document   : roomUpdate
    Created on : Mar 15, 2023, 6:47:38 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/updateRoom.css" rel="stylesheet" type="text/css"/>
        <style>
            .error{
                color: red;

        </style>
    </head>
    <body>
        <form action="roomupdate" method="POST">
            <table border="0.5">
                <tbody>
                    <tr>
                        <td>Room_id: </td>
                        <td><input type="text"readonly name="room_id" value="${room.getRoom_id()}"/></td>
                    </tr>
                    <tr>
                        <td>Name: </td>
                        <td><input type="text" name="name" value="${room.getName()}"/></td>
                    </tr>
                    <tr>
                        <td>current_people</td>
                        <td><input type="text" name="current_people" value="${room.getCurrent_people()}"/></td>
                    </tr>
                    <tr>
                        <td>price</td>
                        <td><input type="text" name="price" value="${room.getPrice()}"/></td>
                    </tr>
                    <tr>
                        <td>dormitory_id</td>
                        <td><input type="text" name="dormitory_id" value="${room.getDormitories().getDormitory_id()}"/> <br/></td>
                    </tr>
                    <tr>
                        <td>room_type</td>
                        <td><input type="text" name="room_type" value="${room.getRoom_type()}"/></td>
                    </tr>
                    <tr>
                        <td>floor</td>
                        <td><input type="text" name="floor" value="${room.getFloor()}"/></td>
                    </tr>
                    <tr>
                        <td>status</td>
                        <td><input type="text" name="status" value="${room.getStatus()}" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Create"></td>
                    </tr>
                </tbody>
            </table></br>
                    <div class="error">
                        ${error}
                    </div>
            <br/>

        </form>
    </body>
</html>
