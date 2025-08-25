import java.sql.*;

public class JDBC_CONNECTION {
    public static Connection getConnection() {
        Connection con = null;

        try {

            // load the driver......
            Class.forName("com.mysql.cj.jdbc.Driver"); // new version use kr rhe hai to ye optiional hota hai,,

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "23012025");

            //String q = "Create table table1(tId INT(20) PRIMARY KEY AUTO_INCREMENT , tName VARCHAR(200) NOT NULL,tCity VARCHAR(400))";        // query bann gyiiii means table create ho gyi table1 naam se and uske column names bhi
            String q = " CREATE TABLE IF NOT EXISTS student_table(RollNumber INT PRIMARY KEY AUTO_INCREMENT , Name VARCHAR(200) NOT NULL ,Grade VARCHAR(5), City VARCHAR(400))";

            // Execute query
            Statement stm = con.createStatement();
            stm.executeUpdate(q);


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("EEEEErrrrrrrooooorrrrrr");
        }
        return con;
    }
}
