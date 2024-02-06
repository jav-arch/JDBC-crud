import java.util.List;

public class JdbcDaoMain {
    public static void main(String[] args) {
        // list of all students
//        List<Student> students = StudentDao.getStudents();
//        System.out.println(students);

        // get particular student
//        Student student = StudentDao.getStudent(3);
//        System.out.println(student);

        // add particular student
//        Student s = new Student();
//        s.rollno =5;
//        s.name="lk";
//        s.email="lk@gmail.com";
//        StudentDao.addStudent(s);

    // update student
//        Student st = new Student();
//        st.email = "zk@gmail.com";
//        st.name = "zk";
//        st.rollno = 5;
//        StudentDao.updateStudent(st);


        // delete student

        StudentDao.deleteStudent(5);
    }
}
