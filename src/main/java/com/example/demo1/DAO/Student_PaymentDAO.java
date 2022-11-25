package com.example.demo1.DAO;

import com.example.demo1.Bean.Bills;
import com.example.demo1.Bean.Student_Payment;
import com.example.demo1.Bean.Students;

import java.util.List;

public interface Student_PaymentDAO {
    boolean addPayment(Student_Payment student_payment);
    //get Payments for particular bill
    List<Student_Payment> getPaymentList( int billid);
    List<Student_Payment> getAllPaymentsList();
}
