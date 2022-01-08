package az.com.company.main;

import az.com.company.dao.StudentDao;
import az.com.company.dao.StudentDaoImpl;
import az.com.company.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        StudentDao studentDao = (StudentDao) applicationContext.getBean("studentDao");
        switch (scanner.next()) {
            case "view":
                List<Student> studentList = studentDao.getStudentList();
                for (Student student : studentList) {
                    System.out.println(student);
                }
                break;

            case "add":
                Student student=new Student();
                student.setName(scanner.next());
                student.setSurname(scanner.next());
                student.setDob(dateFormat.parse(scanner.next()));
                student.setAddress(scanner.next());
                student.setPhone(scanner.next());
                studentDao.addStudent(student);
                System.out.println("Student successfully added!");
                break;
            case "update":

                break;
            case "":

                break;
            case "delete":

                break;
            case "studentCount":

                break;
        }

    }
}
