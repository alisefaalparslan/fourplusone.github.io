<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <jsp:useBean id="user" scope="session" class="data.User" />
    <jsp:setProperty name="user" property="nameSurname"/>
    <jsp:setProperty name="user" property="username"/>
    <jsp:setProperty name="user" property="password"/>
    <jsp:setProperty name="user" property="confirmpass"/>
    <jsp:setProperty name="user" property="email"/>
    <jsp:setProperty name="user" property="phoneNumber"/>

    <jsp:useBean id="db" scope="session" class="data.DBLayer" />


    <%
        if (user.getPassword().equals(user.getConfirmpass())) {
            if (db.checkUserExistance(user.getUsername(), user.getPassword(), false)) {
                response.sendRedirect("signup.html");
            } else {
                db.addUser(user);
                response.sendRedirect("member.html");
            }
        } else {
            response.sendRedirect("signup.html");
        }

    %>

</body>
</html>
