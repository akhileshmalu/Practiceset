/**
 * @author: Akhilesh Maloo
 * @date: 9/4/17.
 */

class Student{

    private String name;
    private int rollNo;

    static int count = 0;
    static String collegeName;

    Student(String name) {
        this.name = name;
        this.rollNo = setRollno();
    }

    private static int setRollno() {
        return ++count;
    }

    static void setcollegeName(String name) {
        collegeName = name;
    }

    @Override
    public String toString() {
        return "Student name is : "+ this.name + " Roll Number is : "+this.rollNo;
    }

}


//Driver class
public class StaticUsage {

    public static void main(String[] args) {
        Student.setcollegeName("USC, Columbia Campus");

        Student stu1 = new Student("Akhilesh Maloo");

        Student stu2 = new Student("Priya Somani");

        System.out.println("Total Student in "+ Student.collegeName +" are:");

        System.out.println(stu1.toString());
        System.out.println(stu2.toString());

    }

}
