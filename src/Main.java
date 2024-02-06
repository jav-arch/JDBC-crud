import java.sql.*;
public class Main {
    public static void main(String[] args) throws Exception {
    Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/jdbc";
    String username="root";
    String password="";
    String insertQuery="insert into users values (3,'ok','ok@gmail.com')";
    String fetchQuery="select * from users";
    Connection con = DriverManager.getConnection(url,username,password);
        Statement statement = con.createStatement();
//        ResultSet rs = statement.executeQuery(fetchQuery);
        int i = statement.executeUpdate(insertQuery);
//        while(rs.next())
//            System.out.println(rs.getInt("id")+" "+rs.getString("email"));

        statement.close();
        con.close();
    }
}