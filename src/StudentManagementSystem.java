import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentManagementSystem {

    Student st = new Student();

    public void addStudent() {
        st.studentRollNumber();
        st.studentName();
        st.studentGrade();
        st.studentCityName();

        // db se connectioni liya hai
        Connection con = JDBC_CONNECTION.getConnection();

        try {

            String q = "INSERT INTO student_table(RollNumber,Name,Grade,City) VALUES (?,?,?,?)"; //rollNUmber autoincrement hai ,,

            PreparedStatement pstm = con.prepareStatement(q);

            pstm.setInt(1, st.rollNo);
            pstm.setString(2, st.name);
            pstm.setString(3, String.valueOf(st.grade)); // char to String
            pstm.setString(4, st.cityName);

            int rows = pstm.executeUpdate();
            if (rows > 0) {
                System.out.println("\nStudent inserted successfully....At Roll No: " + st.rollNo);
            } else {
                System.out.println("Failed to insert student.");
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Student Not Added !");
        }

    }

    public void displayAllStudent() {

        Connection con = JDBC_CONNECTION.getConnection();
        try {
            String q = "SELECT * FROM student_table";
            PreparedStatement pstm = con.prepareStatement(q);
            ResultSet rst = pstm.executeQuery();

            while (rst.next()) {
                int rollNo = rst.getInt("RollNumber");
                String name = rst.getString("Name");
                String grade = rst.getString("Grade");
                String city = rst.getString("City");

                System.out.println("Roll No: " + rollNo);
                System.out.println("Name: " + name);
                System.out.println("Grade: " + grade);
                System.out.println("City: " + city);
                System.out.println("----------------------------");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchStudent() {

        st.studentRollNumber(); // hum roll number ke through search krenge student ko....
        Connection con = JDBC_CONNECTION.getConnection();

        try {

            String q = "SELECT * FROM student_table WHERE RollNumber = ?";
            PreparedStatement pstm = con.prepareStatement(q);
            pstm.setInt(1, st.rollNo); // roll number set kiya

            ResultSet rst = pstm.executeQuery();

            if (rst.next()) {
                // Record mila to ye
                int rollNo = rst.getInt("RollNumber");
                String name = rst.getString("Name");
                String grade = rst.getString("Grade");
                String city = rst.getString("City");

                System.out.println("Student Found:");
                System.out.println("Roll No: " + rollNo);
                System.out.println("Name: " + name);
                System.out.println("Grade: " + grade);
                System.out.println("City: " + city);
            } else {
                // Record nahi mila
                System.out.println("No Student found with Roll No: " + st.rollNo);
            }


            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void removeStudent() {

        st.studentRollNumber();
        Connection con = JDBC_CONNECTION.getConnection();

        try {


            String q = "DELETE FROM student_table WHERE RollNumber = ?";
            PreparedStatement pstm = con.prepareStatement(q);

            pstm.setInt(1, st.rollNo);

            int rows = pstm.executeUpdate();
            if (rows > 0) {
                System.out.println("Student Removing successfully. Roll No: " + st.rollNo);
            } else {
                System.out.println("Failed to Remove student.");
            }


            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Student Not Remove Successfully !");
        }


    }

    public void editStudent() {
        Connection con = JDBC_CONNECTION.getConnection();

        try {
            st.studentRollNumber();
            st.studentName();
            st.studentGrade();
            st.studentCityName();


            String q = "UPDATE student_table SET Name = ?, Grade = ?, City = ? WHERE RollNumber = ?";
            PreparedStatement pstm = con.prepareStatement(q);

            pstm.setString(1, st.name);
            pstm.setString(2, String.valueOf(st.grade));
            pstm.setString(3, st.cityName);
            pstm.setInt(4, st.rollNo);

            int rows = pstm.executeUpdate();
            if (rows > 0) {
                System.out.println("Student details updated successfully....At Roll No: " + st.rollNo);
            } else {
                System.out.println("Failed to update student.");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Student Details Updated Successfully !!!");
        }

    }

}
