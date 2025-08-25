import java.util.Scanner;

public class Student {
    String name;
    int rollNo;
    char grade;
    String cityName;

    Scanner sc = new Scanner(System.in);

    public void studentName() {
        System.out.print("Enter Student Name : ");
        name = sc.nextLine();
    }

    public void studentRollNumber() {
        System.out.print("Enter Student Roll Number : ");
        rollNo = sc.nextInt();
        sc.nextLine();
    }

    public void studentGrade() {
        System.out.print("Enter Student Grade : ");
        grade = sc.next().charAt(0); // agr kisi se glti se AB like type ho jaye to sirf 0 index wala hi le ,,like AB -- A lega bs
        sc.nextLine();
    }

    public void studentCityName() {
        System.out.print("Enter Student City Name : ");
        cityName = sc.nextLine();
    }
}
