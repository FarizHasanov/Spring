package az.com.company.main;

import az.com.company.dao.StudentDao;
import az.com.company.dao.StudentDaoImpl;
import az.com.company.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainClass {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        StudentDao studentDao = (StudentDao) applicationContext.getBean("studentDao");
        List<Student> studentList = studentDao.getStudentList();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
