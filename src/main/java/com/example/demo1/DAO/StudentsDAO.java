package com.example.demo1.DAO;
import com.example.demo1.Bean.Students;

import java.util.HashMap;
import java.util.List;

public interface StudentsDAO {
    boolean addStudent(Students stuObj);
    List<Students> getStudentList();
    Students getStudent(int id);
}
