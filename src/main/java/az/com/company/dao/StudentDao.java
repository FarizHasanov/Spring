package az.com.company.dao;

import az.com.company.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getStudentList() throws Exception;
}
