<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="az.java.hospital.model.Soreness" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/14/2018
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%List<Soreness> sorenessList= (List<Soreness>) request.getAttribute("sorenessList");%>

<table id="sorenessTableId" border="1" style="width: 100%">
    <thead>
        <tr>
            <th>Id</th>
            <th>Diagonis</th>
            <th>Medicines</th>
            <c:if test="${login.role.roleName eq 'ROLE_ADMIN'}">
                <th>Edit</th>
                <th>Delete</th>
            </c:if>
        </tr>
    </thead>

    <tbody>
        <% for(Soreness soreness: sorenessList) { %>
        <tr>
            <td><%=soreness.getR()%></td>
            <td><%=soreness.getDiagonis()%></td>
            <td><%=soreness.getMedicines()%></td>
            <c:if test="${login.role.roleName eq 'ROLE_ADMIN'}">
                <td><a href="javascript: editSoreness('<%=soreness.getId()%>');">Edit</a></td>
                <td><a href="javascript: deleteSoreness('<%=soreness.getId()%>');">Delete</a></td>
            </c:if>
        </tr>
        <% } %>
    </tbody>
</table>
