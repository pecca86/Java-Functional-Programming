package streamstutorial;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> people = getPeople();

        // FILTER FEMALES INTO OWN LIST
        List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

        //females.forEach(System.out::println);

        // SORT PEOPLE LIST BY AGE
        people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .forEach(System.out::println);

        // ALLMATCH - FIND OUT IF EVERYONE IS OLDE THAN 5
        boolean olderThanFive = people.stream()
                .allMatch(person -> person.getAge() > 5);
        System.out.println("All people are older than five?: " + olderThanFive);

        // ANYMATCH - AT LEAST ONE
        boolean atLeastOneOlderThan40 = people.stream()
                .anyMatch(person -> person.getAge() > 40);

        // NONE MATCH -
        boolean noOneNamedAntonio = people.stream()
                .noneMatch(person -> person.getName().equals("Antonio"));
        System.out.println("No 'Antonios' in our list?: " + noOneNamedAntonio);

        // MAX MIN VALUES
        System.out.println("Oldest fart: ");
        Optional<Person> maxAge =  people.stream()
                .max(Comparator.comparing(Person::getAge));
        maxAge.ifPresent(System.out::println);

        // GROUP INFORMATION
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach( (gender, persons) -> {
            System.out.println(gender);
            persons.stream()
                    .forEach(System.out::println);
        });

        // CHAINING
        Optional<String> oldestFemale = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);
        oldestFemale.ifPresent(System.out::println);

    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("Pekka", 36, Gender.MALE),
                new Person("Pittkuk", 40, Gender.MALE),
                new Person("Fis-Lisa", 28, Gender.FEMALE),
                new Person("Slid-Kajsa", 36, Gender.FEMALE),
                new Person("Nipp-Ulla", 66, Gender.FEMALE),
                new Person("Claus", 16, Gender.MALE),
                new Person("Horbut", 56, Gender.MALE),
                new Person("Knull-Ulla", 36, Gender.MALE)
        );
    }
}
