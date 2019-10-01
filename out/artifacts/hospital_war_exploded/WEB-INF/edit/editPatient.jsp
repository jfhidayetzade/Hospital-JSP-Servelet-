<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/15/2018
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $ (function () {
        $ ('#dobIdpU').datepicker({
            changeMonth: true,
            changeYear: true
        });
    });

</script>

<div class="lbladdesing"><label for="nameIdpU">Name:</label></div><input type="text" id="nameIdpU" value="${patient.name}"/><br>
<div class="lbladdesing"><label for="surnameIdpU">Surname:</label></div><input type="text" id="surnameIdpU" value="${patient.surname}"/><br>
<div class="lbladdesing"><label for="genderpIdU">Gender:</label></div><input type="text" id="genderpIdU" value="${patient.gender}"/><br>
<div class="lbladdesing"><label for="dobIdpU">Date of Birth:</label></div><input type="text" id="dobIdpU" value="${patient.dob}"/><br>
<div class="lbladdesing"><label for="emailIdpU">Email:</label></div><input type="text" id="emailIdpU" value="${patient.emailAdress}"/><br>
<div class="lbladdesing"><label for="addressIdpU">Address:</label></div><input type="text" id="addressIdpU" value="${patient.address}"/>
