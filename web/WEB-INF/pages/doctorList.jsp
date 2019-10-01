<%@ page import="java.util.List" %>
<%@ page import="az.java.hospital.model.Doctor" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/14/2018
  Time: 09:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%List<Doctor> doctors= (List<Doctor>) request.getAttribute("doctorList");%>
<table id="doctorTableId" border="1" style="width: 100%">
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Task</th>
            <th>Department</th>
            <c:if test="${login.role.roleName eq 'ROLE_ADMIN'}">
                <th>Edit</th>
                <th>Delete</th>
            </c:if>
        <tr>
    </thead>

    <tbody>
        <% for(Doctor doctor: doctors) {%>
            <tr>
                <td><%=doctor.getR()%></td>
                <td><%=doctor.getName()%></td>
                <td><%=doctor.getSurname()%></td>
                <td><%=doctor.getTask()%></td>
                <td><%=doctor.getDepartament()%></td>
                <c:if test="${login.role.roleName eq 'ROLE_ADMIN'}">
                    <td><a href="javascript: editDoctor(<%=doctor.getId()%>);">Edit</a></td>
                    <td><a href="javascript: deleteDoctor('<%=doctor.getId()%>');">Delete</a></td>
                </c:if>
            </tr>

        <% } %>
    </tbody>
</table>
