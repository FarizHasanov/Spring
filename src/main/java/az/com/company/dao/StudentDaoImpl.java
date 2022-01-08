package az.com.company.dao;

import az.com.company.model.Student;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class StudentDaoImpl implements StudentDao {

    private DataSource dataSource;

    public List<Student> getStudentList() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM STUDENT WHERE ACTIVE=1";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Student.class));
        return studentList;
    }
}
