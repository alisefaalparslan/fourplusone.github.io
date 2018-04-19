<%-- 
    Document   : a
    Created on : 18.Nis.2018, 20:03:03
    Author     : alisefa
--%>
<%@page import="dao.deneme"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <%=
  deneme tc = new deneme();
  tc.firttry();
%>
    <jsp:useBean id="own" scope="session" class="dao.deneme" />
    <h1>Hello World!</h1>
</body>
</html>
