<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/30/2018
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    session.removeAttribute("login");
    session.invalidate();
    response.sendRedirect("login.jsp");

%>