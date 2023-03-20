<%-- 
    Document   : updateDorm
    Created on : Mar 12, 2023, 4:16:24 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dorm Update</title>
        <link href="css/updateDorm.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="dormupdate" method="POST">
            <table border="0.5">
                <tbody>
                    <tr>
                        <td>Dormitory_id:</td>
                        <td><input type="text" readonly name="id" value="${dorm.dormitory_id}"  /></td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" value="${dorm.name}" name="name"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Save"/></td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
