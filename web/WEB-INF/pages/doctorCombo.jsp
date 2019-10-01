<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/28/2018
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<option value="0" disabled>Select Doctor</option>
<c:forEach items="${doctorList}" var="dl">
    <option value="${dl.id}">${dl.name} ${dl.surname}</option>
</c:forEach>