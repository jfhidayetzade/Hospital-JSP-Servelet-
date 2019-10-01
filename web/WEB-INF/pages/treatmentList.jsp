<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="az.java.hospital.model.Treatment" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/14/2018
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%List<Treatment> treatments= (List<Treatment>) request.getAttribute("treatmentList");%>

<script>
    $( function() {
        $( "#accordion" ).accordion({
            collapsible: true
        });


        $( '.data' ).datepicker({
            changeMonth: true,
            changeYear: true
        });


        $('#advSorenessComboId').change(function () {
            getDoctorComboSorenessById($('#advSorenessComboId').val());
        });

        $('#advSearchBtnId').click(function () {
            advanceSearchTreatment();
        })

    } );
</script>

<div id="accordion">
    <h3>Advance Search</h3>
    <div>
        <select id="advSorenessComboId" style="width: 176px">
            <option value="0">Select Soreness</option>
            <c:forEach items="${sorenessList}" var="sl">
                <option value="${sl.id}">${sl.diagonis} ${sl.medicines}</option>
            </c:forEach>
        </select> &nbsp;
        <select id="advDoctorComboId" style="width: 176px">
            <option value="0">Select Doctor</option>
            <c:forEach items="${doctorList}" var="dl">
                <option value="${dl.id}">${dl.name} ${dl.surname}</option>
            </c:forEach>
        </select><br/>
        <input type="text" id="advBeginDateId" placeholder="Begin Date" class="data"> &nbsp;
        <input type="text" id="advEndDateId" placeholder="End Date" class="data"> &nbsp;
        <input type="button" id="advSearchBtnId" value="Search"> &nbsp;
    </div>

</div>

<div id="treatmentDivId">
    <table id="treatmentTableId" border="1" style="width: 100%;">
        <thead>
        <tr>
            <th>Id</th>
            <th>Patient Name&Surname</th>
            <th>Doctor Name&Surname</th>
            <th>Soreness Diagonis&Medicines</th>
            <c:if test="${login.role.roleName eq 'ROLE_ADMIN'}">
                <th>Edit</th>
                <th>Delete</th>
            </c:if>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${treatmentList}" var="tl">
            <tr>
                <td>${tl.r}</td>
                <td>${tl.patient.name} ${tl.patient.surname}</td>
                <td>${tl.doctor.name} ${tl.doctor.surname}</td>
                <td>${tl.soreness.diagonis} ${tl.soreness.medicines}</td>
                <c:if test="${login.role.roleName eq 'ROLE_ADMIN'}">
                    <td><a href="javascript: editTreatment('${tl.id}');"> Edit</a></td>
                    <td><a href="javascript: deleteTreatment('${tl.id}');"> Delete</a></td>
                </c:if>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>


