import java.sql.*;
import java.util.Collection;

public class ConnectMysql {
    private  static String DB_URL ="jdbc:mysql://localhost:3308/student";
    private  static String USER_NAME ="root";
    private static String PASSWORD = "123456";

    public static void main(String[] args) {
        try {
        //connect to database
        Connection conn = getConnection(DB_URL,USER_NAME,PASSWORD);

            //statement cung cap phuong thuc tao ra resultset
            Statement stst = conn.createStatement();
            ResultSet rst = stst.executeQuery("SELECT * FROM testdb");
            while (rst.next()) {
                System.out.println(rst.getInt(1) + "  " + rst.getString(2)
                        + "  " + rst.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection(String dbUrl, String userName, String password) {
     Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl,userName,password);
            System.out.println("connect successfully!");

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


}
