import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    static Connection con = null;
    public static void connect(){
        try {
            String url = "jdbc:mysql://localhost:3306/jdbc";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static List<Student> getStudents() {
        try {
            connect();
            PreparedStatement ps = con.prepareStatement("select * from users");
            ResultSet rs = ps.executeQuery();
            List<Student> st = new ArrayList<>();

                while (rs.next()) {
                    Student stud = new Student();
                    stud.name = rs.getString(2);
                    stud.rollno = rs.getInt(1);
                    stud.email = rs.getString(3);
                    st.add(stud);
                }
                return st;

        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static Student getStudent(int rollno) {
        try{
            connect();
            PreparedStatement preparedStatement = con.prepareStatement("select * from users where id =?");
            preparedStatement.setInt(1,rollno);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Student st = new Student();
                st.rollno = resultSet.getInt(1);
                st.name= resultSet.getString(2);
                st.email = resultSet.getString(3);
                return st;

            }else return null;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static void addStudent(Student s) {
        try {
            connect();
            PreparedStatement statement = con.prepareStatement("insert into users values (?,?,?)");
            statement.setInt(1, s.rollno);
            statement.setString(2,s.name);
            statement.setString(3,s.email);
            int i = statement.executeUpdate();
            System.out.println(i+" rows inserted");

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void updateStudent(Student stud) {
        try{
            connect();
            PreparedStatement st = con.prepareStatement("update users set email=?,name=? where id=?");
            st.setInt(3,stud.rollno);
            st.setString(1,stud.email);
            st.setString(2,stud.name);
            int i = st.executeUpdate();
            System.out.println(i);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void deleteStudent(int rollno){
        try {
            connect();
            PreparedStatement statement = con.prepareStatement("delete from users where id = ?");
            statement.setInt(1,rollno);
            int i = statement.executeUpdate();
            System.out.println(i);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
