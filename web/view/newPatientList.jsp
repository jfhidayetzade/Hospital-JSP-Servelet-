<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/14/2018
  Time: 11:42
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

<div class="lbladdesing"><label for="nameId">Name:</label><input type="text" id="nameId"></div><br/>
<div class="lbladdesing"><label for="surnameId">Surname:</label><input type="text" id="surnameId"></div><br/>
<div class="lbladdesing"><label for="genderId">Gender:</label><input type="text" id="genderId"></div><br/>
<div class="lbladdesing"><label for="dobId">Date of Birth:</label><input type="text" id="dobId"></div><br/>
<div class="lbladdesing"><label for="emailId">Email Address:</label><input type="text" id="emailId"></div><br/>
<div class="lbladdesing"><label for="addressId">Address:</label><input type="text" id="addressId"></div><br/>
