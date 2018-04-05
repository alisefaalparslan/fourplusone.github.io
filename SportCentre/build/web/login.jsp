<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <jsp:useBean id="user" scope="session" class="data.User" />
    <jsp:setProperty name="user" property="username"/>
    <jsp:setProperty name="user" property="password"/>

    <jsp:useBean id="db" scope="session" class="data.DBLayer" />


    <%
        if(db.checkUserExistance(user.getUsername(), user.getPassword(), true)){
            response.sendRedirect("member.html");
        }else{
            response.sendRedirect("logindenied.html");
        }        
    %>

</body>
</html>
