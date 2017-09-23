/**
 * Created by akhi on 5/28/17.
 * For Purpose of Lambda exercise
 */
public class Person {

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Firstname is:"+firstName+", Lastname is:"+lastName+", Age is:"+age;
    }

    public void printPerson() {
        System.out.println("Firstname is:"+firstName+", Lastname is:"+lastName+", Age is:"+age);
    }

}
