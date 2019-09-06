<%@ page import="java.sql.DriverManager" %>
<%@ page import="dao.impl.ContentDAOImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.Content" %><%--
  Created by IntelliJ IDEA.
  User: 10514
  Date: 2019/9/6
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    ContentDAOImpl contentDAO = new ContentDAOImpl() ;
    List<Content> contents = contentDAO.list() ;
    for (Content content : contents){
%>
    <p>
        <%=content.toString()%>
    </p>
<%
    }
%>

</body>
</html>
