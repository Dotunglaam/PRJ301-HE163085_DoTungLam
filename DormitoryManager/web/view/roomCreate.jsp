<%-- 
    Document   : roomCreate
    Created on : Mar 15, 2023, 6:45:36 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Room</title>
        <link href="css/createRoom.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="roomcreate" method="POST">
            <table border="0.5">
                <tbody>
                    <tr>
                        <td>Name: </td>
                        <td><input type="text" name="name"/></td>
                    </tr>
                    <tr>
                        <td>current_people</td>
                        <td><input type="text" name="current_people"/></td>
                    </tr>
                    <tr>
                        <td>price</td>
                        <td><input type="text" name="price"/></td>
                    </tr>
                    <tr>
                        <td>dormitory_id</td>
                        <td><input type="text" name="dormitory_id"/> <br/></td>
                    </tr>
                    <tr>
                        <td>room_type</td>
                        <td><input type="text" name="room_type"/></td>
                    </tr>
                    <tr>
                        <td>floor</td>
                        <td><input type="text" name="floor"/></td>
                    </tr>
                    <tr>
                        <td>status</td>
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
