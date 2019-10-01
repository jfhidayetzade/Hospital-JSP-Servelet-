<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/29/2018
  Time: 01:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Hospital</title>

    <script type="text/javascript" src="js/jquery/jquery-latest.js"></script>
    <script type="text/javascript" src="js/jquery/jquery.layout-latest.js"></script>
    <script type="text/javascript" src="js/jquery/jquery-ui.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
    <%--<script type="text/javascript">
        history.pushState(null,null,'login.jsp');
        window.addEventListener('popstate',function (event) {
            history.pushState(null,null,'login.jsp')
        });
    </script>--%>
  </head>
  <body>

  <div class="ui-layout-north">

    <h1 style="text-align: center">
      Hospital
    </h1>
    <div style="float:right;">Welcome, ${login.name} ${login.surname}
    <a href="logout.jsp"><img src="img/logout.png" style="width: 25px; height: 25px"></a></div>
    <div>

    </div>


  </div>

  <div class="ui-layout-center">



  </div>

  <div class="ui-layout-west">

    <c:choose>
      <c:when test="${login.role.roleName eq 'ROLE_ADMIN'}">
        <input  type="button" value="PatientData" id="patientDataBtnId" class="btnDesing"><br/>
        <input  type="button" value="DoctorData" id="doctorDataBtnId" class="btnDesing"><br/>
        <input  type="button" value="SorenessData" id="sorenessDataBtnId" class="btnDesing"><br/>
        <input  type="button" value="TreatmentData" id="treatmentDataBtnId" class="btnDesing"><br/>
        <input  type="button" value="PaymentData" id="paymentDataBtnId" class="btnDesing"><br/>
        <input  type="button" value="Register" id="registerDataId" class="btnDesing"/>
      </c:when>

      <c:when test="${login.role.roleName eq 'ROLE_DOCTOR'}">
        <input  type="button" value="DoctorData" id="doctorDataBtnId" class="btnDesing"><br/>
        <input  type="button" value="SorenessData" id="sorenessDataBtnId" class="btnDesing"><br/>
        <input  type="button" value="TreatmentData" id="treatmentDataBtnId" class="btnDesing"><br/>
        <input  type="button" value="PaymentData" id="paymentDataBtnId" class="btnDesing"><br/>
      </c:when>

      <c:when test="${login.role.roleName eq 'ROLE_PATIENT'}">
        <input  type="button" value="DoctorData" id="doctorDataBtnId" class="btnDesing"><br/>
        <input  type="button" value="SorenessData" id="sorenessDataBtnId" class="btnDesing"><br/>
        <input  type="button" value="TreatmentData" id="treatmentDataBtnId" class="btnDesing"><br/>
      </c:when>
    </c:choose>

  </div>

  <div class="ui-layout-south">

  </div>

  <div class="ui-layout-east">

    <c:choose>
      <c:when test="${login.role.roleName eq 'ROLE_ADMIN'}">
        <input type="button" value="New" id="newBtnId" style="width: 100%; height: 50px"><br/>
        <input type="text" placeholder="search" id="keyworId" style="width:114px; margin-top: 20px ">
        <a href="javascript: simpleSearch();" style="text-decoration: none;"><input type="button" value="search" height="60px"></a>
      </c:when>

      <c:when test="${login.role.roleName eq 'ROLE_DOCTOR'}">
        <input type="text" placeholder="search" id="keyworId" style="width:114px; margin-top: 20px ">
        <a href="javascript: simpleSearch();" style="text-decoration: none;"><input type="button" value="search" height="60px"></a>
      </c:when>

      <c:when test="${login.role.roleName eq 'ROLE_PATIENT'}">
        <input type="text" placeholder="search" id="keyworId" style="width:114px; margin-top: 20px ">
        <a href="javascript: simpleSearch();" style="text-decoration: none;"><input type="button" value="search" height="60px"></a>
      </c:when>
    </c:choose>


  </div>

  <div id="newPatientId"></div>
  <div id="newDoctortId"></div>
  <div id="newSorenessId"></div>
  <div id="newTreatmentId"></div>
  <div id="newEmployeeId"></div>
  <div id="newPaymentId"></div>
  <div id="newRegisterId"></div>
  <%--EditDialog--%>
  <div id="editPatientId"></div>
  <div id="editDoctorDialogId"></div>
  <div id="editSorenessId"></div>
  <div id="editTreatmentDialogId"></div>

  </body>
</html>
