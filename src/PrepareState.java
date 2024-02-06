import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PrepareState {
    public static void main(String[] args) {
        try{
            String url="jdbc:mysql://localhost:3306/jdbc";
            String username="root";
            String password="";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
//            PreparedStatement ps = connection.prepareStatement("select * from users where id=?");
            PreparedStatement ps = connection.prepareStatement("insert into users values (?,?,?)");
            ps.setInt(1,4);
            ps.setString(2,"mk");
            ps.setString(3,"mk@gmail.com");
            int executeUpdate = ps.executeUpdate();
            System.out.println(executeUpdate);
//            while(resultSet.next()){
//
//                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2));
//            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
