<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/15/2018
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $( function() {
        $( "#dobId" ).datepicker({
            changeMonth: true,
            changeYear: true
        });
    } );
</script>

<div class="lbladdesing"><label for="nameIdDU">Name:</label><input type="text" id="nameIdDU" value="${doctor.name}"></div><br/>
<div class="lbladdesing"><label for="surnameIdDU">Surname:</label><input type="text" id="surnameIdDU" value="${doctor.surname}"></div><br/>
<div class="lbladdesing"><label for="taskDU">Task:</label><input type="text" id="taskDU" value="${doctor.task}"></div><br/>
<div class="lbladdesing"><label for="departmentDU">Department:</label><input type="text" id="departmentDU" value="${doctor.departament}"></div>
