<%-- 
    Document   : studentsUpdate
    Created on : Mar 16, 2023, 3:42:49 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Update</title>
    </head>
    <body>
        <form action="studentupdate" method="POST">
            <table border="0.5">
                <tbody>
                    <tr>
                        <td>Role_id:</td>
                        <td><input type="text" name="role_id" value="${user.getRole_id()}" /></td>
                <input type="hidden"  name="sid" value="${sid}">
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
