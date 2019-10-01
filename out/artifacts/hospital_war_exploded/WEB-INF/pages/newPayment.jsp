<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/30/2018
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<div>Patient: </div>
<select id="patientComboIdPayment" class="newTreatmentSelect">
    <option value="0" selected disabled>Select Patient</option>
    <c:forEach items="${patientList}" var="pl">
        <option value="${pl.id}">${pl.name} ${pl.surname}</option>
    </c:forEach>



</select>

<div>Doctor: </div>
<select id="doctorComboIdPayment" class="newTreatmentSelect">
    <option value="0" selected disabled>Select Doctor</option>
    <c:forEach items="${doctorList}" var="dl">
        <option value="${dl.id}">${dl.name} ${dl.surname}</option>
    </c:forEach>

</select>

<div>Soreness: </div>
<select id="sorenessComboIdPayment" class="newTreatmentSelect">
    <option value="0" selected disabled>Select Soreness</option>
    <c:forEach items="${sorenessList}" var="sl" >
        <option value="${sl.id}">${sl.diagonis} ${sl.medicines}</option>
    </c:forEach>
</select>

