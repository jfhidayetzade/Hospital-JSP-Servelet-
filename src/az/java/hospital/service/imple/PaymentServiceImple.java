package az.java.hospital.service.imple;

import az.java.hospital.dao.PaymentDao;
import az.java.hospital.model.Payment;
import az.java.hospital.service.PaymentService;

import java.util.List;

public class PaymentServiceImple implements PaymentService{
    private PaymentDao paymentDao;

    public PaymentServiceImple(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public List<Payment> getPaymentList() throws Exception {
        return paymentDao.getPaymentList();
    }

    @Override
    public boolean addPayment(Payment payment) throws Exception {
        return paymentDao.addPayment(payment);
    }

    @Override
    public Payment getPaymentById(Long paymentId) throws Exception {
        return paymentDao.getPaymentById(paymentId);
    }

    @Override
    public boolean updatePayment(Payment payment, Long paymentId) throws Exception {
        return paymentDao.updatePayment(payment,paymentId);
    }

    @Override
    public boolean deletePayment(Long paymentId) throws Exception {
        return paymentDao.deletePayment(paymentId);
    }

    @Override
    public List<Payment> seacrhPaymentData(String keyword) throws Exception {
        return paymentDao.seacrhPaymentData(keyword);
    }
}
