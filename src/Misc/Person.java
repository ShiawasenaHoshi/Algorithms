package Misc;

import java.text.Collator;
import java.util.Locale;

public class Person implements Comparable<Person> {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public int compareTo(Person person) {
        if (age > person.age) {
            return 1;
        }
        if (age < person.age) {
            return -1;
        }
        return Collator.getInstance(new Locale("ru", "RU")).compare(name, person.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return age == person.age && !(name != null ? !name.equals(person.name) : person.name != null);

    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" + age + ", " + name + "}";
    }
}
