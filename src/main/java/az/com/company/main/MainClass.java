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
                Student student = new Student();
                student.setName(scanner.next());
                student.setSurname(scanner.next());
                student.setDob(dateFormat.parse(scanner.next()));
                student.setAddress(scanner.next());
                student.setPhone(scanner.next());
                studentDao.addStudent(student);
                System.out.println("Student successfully added!");
                break;
            case "update":
                Student studentUp = new Student();
                studentUp.setId(Long.parseLong(scanner.next()));
                studentUp.setName(scanner.next());
                studentUp.setSurname(scanner.next());
                studentUp.setDob(dateFormat.parse(scanner.next()));
                studentUp.setAddress(scanner.next());
                studentUp.setPhone(scanner.next());
                studentDao.updateStudent(studentUp);
                break;
            case "studentById":
                Student studentGetById = new Student();
                Student studentById = studentDao.getStudentById(Long.parseLong(scanner.next()));
                System.out.println(studentById);
                break;
            case "delete":
                Student studentDlt = new Student();
                studentDao.deleteStudent(Long.parseLong(scanner.next()));
                System.out.println("Student successfully deleted!");
                break;
            case "studentCount":
                Student studentCnt=new Student();
                Long studentCount= studentDao.studentCount();
                System.out.println(studentCount);

                break;
            default:
                System.out.println("Emelliyyati duzgun secin!");
        }

    }
}
