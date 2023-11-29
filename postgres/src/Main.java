import java.sql.*;

public class Main {

    private static Connection connection;
    private static String jdbcUrl = "jdbc:postgresql://172.18.1.233:5432/javaTest";
    private static String username = "postgres";
    private static String password = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, username, password);
    }

    public static void main(String[] args) throws SQLException {

        try {
            Studenci student = new Studenci();
            student.menu();
        }
        catch(Exception e) {
            System.out.println(e.getMessage()+"\n");
            e.printStackTrace();
        }
    }
}
