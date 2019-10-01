<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="az.java.hospital.model.Patient" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/13/2018
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<Patient> patients= (List<Patient>) request.getAttribute("patientList");%>

    <table id="patientTableId" border="1" style="width: 100%">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Gender</th>
            <th>Date of Birth</th>
            <th>Email Address</th>
            <th>Address</th>

            <c:if test="${login.role.roleName eq 'ROLE_ADMIN'}">
                <th>Edit</th>
                <th>Delete</th>
            </c:if>
        </tr>
        </thead>
        <% for(Patient patient: patients) { %>
        <tr>
            <td><%=patient.getR()%></td>
            <td><%=patient.getName()%></td>
            <td><%=patient.getSurname()%></td>
            <td><%=patient.getGender()%></td>
            <td><%=patient.getDob()%></td>
            <td><%=patient.getEmailAdress()%></td>
            <td><%=patient.getAddress()%></td>
            <c:if test="${login.role.roleName eq 'ROLE_ADMIN'}">
                <td><a href="javascript: editPatient('<%=patient.getId()%>');">Edit</a></td>
                <td><a href="javascript: deletePatient('<%=patient.getId()%>');">Delete</a></td>
            </c:if>

        </tr>
        <% } %>
    </table>


