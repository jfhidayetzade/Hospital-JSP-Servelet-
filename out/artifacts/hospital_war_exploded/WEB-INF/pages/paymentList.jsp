<%@ page import="java.util.List" %>
<%@ page import="az.java.hospital.model.Payment" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/30/2018
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<Payment> payments = (List<Payment>) request.getAttribute("paymentList");%>

    <table border="1" style="width: 100%">
        <thead>
            <tr>
                <th>Id</th>
                <th>Patient</th>
                <th>Doctor</th>
                <th>Soreness</th>
                <th>Date</th>
                <th>Amount</th>
            </tr>
        </thead>

        <tbody>
        <% for (Payment payment: payments){ %>
            <tr>
                <td><%=payment.getR()%></td>
                <td><%=payment.getPatient().getName()%></td>
                <td><%=payment.getDoctor().getName()%></td>
                <td><%=payment.getSoreness().getDiagonis()%></td>
                <td><%=payment.getDate()%></td>
                <td><%=payment.getAmount()%></td>
            </tr>

        <% } %>
        </tbody>
    </table>
