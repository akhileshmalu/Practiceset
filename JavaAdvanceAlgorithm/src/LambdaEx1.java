import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by akhi on 5/28/17.
 */
public class LambdaEx1 {

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Akhilesh","Maloo",29),
                new Person("Priya","Somani",29),
                new Person("Abhishek","Maloo",33),
                new Person("Anjali","Devpura",33)
        );

        // Ques1 : Sort list by First name
        Collections.sort(people, (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()));


        // Ques2 : Create method to print all elements from list.

        System.out.println("Function Interfacing");
        people.forEach(p -> {
            System.out.println(p.toString());
        });

        // Method Referencing
        System.out.println("After Method Referencing");
        people.forEach(Person::printPerson);


        // Ques3 : Print all people names whose last name starts with M

        people.stream().filter(t -> t.getLastName().startsWith("M")).forEach(p -> System.out.println(p.toString()));

        // Method Referencing
        System.out.println("After Method Referencing");
        people.parallelStream().filter(t -> t.getLastName().startsWith("M")).forEach(System.out::println);


        // Example of Collect
        System.out.println("Example Filtering and collecting in another collection \n \n");

        List<Person> NameByAupdate =
                people.stream()
                .filter(n -> n.getFirstName().startsWith("A"))
                .map(temp -> new Person(temp.getFirstName().toUpperCase(),temp.getLastName().toLowerCase(),temp.getAge()))
                .collect(Collectors.toList());

        NameByAupdate.forEach(System.out::println);


        // Groupify
        System.out.println("Example Grouping a collection By Age \n \n");

        Map<Integer, List<Person>> peopleByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        peopleByAge.forEach((age, p) -> System.out.format("Age %s: %s \n",age,p));



        // Average / Other Operations
        System.out.println("Example Average of collection By Age \n \n");

        double avg = people.parallelStream()
                .collect(Collectors.averagingInt(Person::getAge));

        System.out.println(avg);

        // Statistical Analysis of Age
        System.out.println("Example Statistical Analysis of collection By Age \n \n");
        IntSummaryStatistics ageSummary = people.parallelStream()
                .collect(Collectors.summarizingInt(Person::getAge));

        System.out.println(ageSummary);


        // joining and forming a mean
        System.out.println("Example Joining Analysis of collection By Age \n \n");

        String relation = people.parallelStream()
                .filter(p -> p.getLastName().equals("Maloo"))
                .map(Person::getFirstName)
                .collect(Collectors.joining(" and ","In this group "," are from same family."));
        System.out.println(relation);

    }

}
