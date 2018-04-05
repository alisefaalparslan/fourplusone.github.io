<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <jsp:useBean id="user" scope="session" class="data.User" />
    
    <%
           user.setUsername("Bokali");
           user.setNameSurname("komiqmi");
    %>
    <jsp:getProperty name="user" property="nameSurname"/>
    <jsp:getProperty name="user" property="username"/>
    <jsp:getProperty name="user" property="password"/>
    <jsp:getProperty name="user" property="confirmpass"/>
    <jsp:getProperty name="user" property="email"/>
    <jsp:getProperty name="user" property="phoneNumber"/>
    <%
        request.getParameter(user.getUsername());
        response.sendRedirect("profile.html");
    %>

</body>
</html>
