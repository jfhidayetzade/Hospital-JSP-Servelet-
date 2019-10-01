<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/28/2018
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table id="treatmentTableId" border="1" style="width: 100%;">
    <thead>
    <tr>
        <th>Id</th>
        <th>Patient Name&Surname</th>
        <th>Doctor Name&Surname</th>
        <th>Soreness Diagonis&Medicines</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${treatmentList}" var="tl">
        <tr>
            <td>${tl.r}</td>
            <td>${tl.patient.name} ${tl.patient.surname}</td>
            <td>${tl.doctor.name} ${tl.doctor.surname}</td>
            <td>${tl.soreness.diagonis} ${tl.soreness.medicines}</td>
            <td><a href="javascript: editTreatment('${tl.id}');"> Edit</a></td>
            <td><a href="javascript: deleteTreatment('${tl.id}');"> Delete</a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>