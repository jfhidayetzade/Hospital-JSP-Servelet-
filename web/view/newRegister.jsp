<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/24/2019
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div> Person type: </div>

<select id="doctorRegisterId" class="newTreatmentSelect">
    <option value="0" selected disabled>Doctor Selected</option>
    <c:forEach items="${doctorList}" var="dl">
        <option value="${dl.id}">${dl.name} ${dl.surname}</option>
    </c:forEach>
</select>

<div> Person </div>
<select id="patientRegisterId" class="newTreatmentSelect">
    <option value="0" selected disabled>Patient Selected</option>
    <c:forEach items="${patientList}" var="pl">
        <option value="${pl.id}">${pl.name} ${pl.surname}}</option>
    </c:forEach>
</select>

<div> Role </div>
<select id="roleRegisterId" class="newTreatmentSelect">

</select>



</body>
</html>
