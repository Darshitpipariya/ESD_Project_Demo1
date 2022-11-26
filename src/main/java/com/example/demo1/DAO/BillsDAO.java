package com.example.demo1.DAO;

import com.example.demo1.Bean.Bills;
import com.example.demo1.Bean.Students;

import java.util.List;

public interface BillsDAO {
    boolean addBills(Bills bills);
    // get bill for perticulat student
    List<Bills> getBillList(int stuid);
    List<Bills> getAllBillsList();
    Bills getBill(int billid);
}
