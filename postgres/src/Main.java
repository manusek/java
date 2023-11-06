import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

//        try {

//            String jdbcUrl = "jdbc:postgresql://localhost:5432/javaTest";
//            String username = "postgres";
//            String password = "admin";
//
//            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
//
//            Statement statement = connection.createStatement();

//            String sqlQuery = "SELECT * FROM students";
//            ResultSet resultSet = statement.executeQuery(sqlQuery);
//
//            while (resultSet.next()) {
//
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String secondname = resultSet.getString("secondname");
//                int album = resultSet.getInt("album");
//
//                System.out.println("ID: " + id + ", Name: " + name + ", Second Name: " + secondname + ", Ablum number: " + album);
//            }
//
//            resultSet.close();
//            statement.close();
//            connection.close();
//
//        } catch (Exception e){
//            e.printStackTrace();
//        }


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
