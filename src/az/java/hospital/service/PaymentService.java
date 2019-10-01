package az.java.hospital.service;

import az.java.hospital.model.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> getPaymentList () throws Exception;

    boolean addPayment (Payment payment) throws Exception;

    Payment getPaymentById(Long paymentId) throws Exception;

    boolean updatePayment (Payment payment, Long paymentId) throws Exception;

    boolean deletePayment(Long paymentId) throws Exception;

    List<Payment> seacrhPaymentData(String keyword) throws Exception;
}
