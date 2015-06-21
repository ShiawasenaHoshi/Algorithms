package Find;

import Misc.Person;
import Sort.ShellSort;
import Sort.Strategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static Find.SimpleBinarySearch.binarySearch;

/**
 * Created by vasily on 20.06.15.
 */
public class BinarySearchTest {
    List<Integer> ints;
    List<Person> persons;
    Random random = new Random();
    StringBuilder sb;

    @Test
    public void testSimpleBinarySearch() throws Exception {
        ints = new ArrayList<Integer>();
        for (int i = 0; i < 75 + random.nextInt(50); i++) {
            ints.add(i);
        }
        for (int i = 0; i < 1000; i++) {
            int toFind = random.nextInt(ints.size() - 1);
            Assert.assertEquals(toFind, binarySearch(ints, toFind));
        }
    }

    @Test
    public void testSimpleBinarySearch2() throws Exception {
        ints = new ArrayList<Integer>();
        for (int i = 0; i < 75 + random.nextInt(50); i++) {
            ints.add(i);
        }
        for (int i = 0; i < 10; i++) {
            int toFind = random.nextInt(ints.size() - 1);
            ints.remove(new Integer(toFind));
            Assert.assertEquals(-1, binarySearch(ints, toFind));
        }
    }

    @Test
    public void testSimpleBinarySearch3() throws Exception {
        ints = new ArrayList<>();
        sb = new StringBuilder();
        sb.append("Массив: ");
        for (int i = 0; i < 75 + random.nextInt(50); i++) {
            for (int j = 0; j < random.nextInt(5); j++) {
                ints.add(i);
                sb.append(i);
                sb.append(", ");
            }
        }
        sb.append("\n");
        sb.append("Размер: ");
        sb.append(ints.size());
        sb.append("\n");

        for (int i = 0; i < 1000; i++) {
            int toFind = random.nextInt(ints.size() - 1);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Искомое: ");
            sb2.append(toFind);
            if (ints.indexOf(new Integer(toFind)) != binarySearch(ints, toFind)) {
                sb.append(sb2);
                int index = ints.indexOf(new Integer(toFind));
                sb.append("\nИндекс в массиве: ");
                sb.append(index);
                System.out.println(sb.toString());
                Assert.assertEquals(ints.indexOf(new Integer(toFind)), binarySearch(ints, toFind));
            }
        }
    }

    //Тест, чтобы выявить даже самые маловероятные ошибки.
    @Test
    public void testSimpleBinarySearch4() throws Exception {
        for (int i = 0; i < 10000; i++) {
            testSimpleBinarySearch3();
        }
    }

    @Test
    public void testBinarySearch1() throws Exception {
        Person[] persons = {
                new Person(1, "Петя"),
                new Person(1, "Степа"),
                new Person(14, "Дима"),
                new Person(19, "Катя"),
                new Person(19, "Миша"),
                new Person(129, "Ваня"),
                new Person(14, "Дима"),
                new Person(126, "Катя"),
                new Person(190, "Миша"),
                new Person(12, "Дима"),
                new Person(9, "Катя"),
                new Person(7, "Миша")
        };
        List<Person> sortedPersons = (List<Person>) Strategy.sort(Arrays.asList(persons), new ShellSort<>());
        Person personToFind = persons[5];
        BinarySearch<Person> bs = new BinarySearch<>();
        Assert.assertEquals(bs.indexOf(sortedPersons, personToFind), sortedPersons.indexOf(personToFind));
    }

    @Test
    public void testBinarySearch2() throws Exception {
        persons = new ArrayList<>();
        sb = new StringBuilder();
        for (int i = 0; i < 75 + random.nextInt(50); i++) {
            for (int j = 0; j < random.nextInt(5); j++) {
                persons.add(new Person((i + j * 5), "Имя" + i + j));

            }
        }
        persons = (List<Person>)Strategy.sort(persons, new ShellSort<Person>());
        sb.append("Массив: ");
        for (Person person : persons) {
            sb.append(person.toString());
            sb.append(", ");
        }
        sb.append("\n");
        sb.append("Размер: ");
        sb.append(persons.size());
        sb.append("\n");
        for (int i = 0; i < 1000; i++) {
            Person toFind = persons.get(random.nextInt(persons.size() - 1));
            if(random.nextInt(50) == 1){
                toFind = new Person(999, "Неизвестный чел");
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Искомое: ");
            sb2.append(toFind.toString());
            if (persons.indexOf(toFind) != new BinarySearch().indexOf(persons, toFind)) {
                sb.append(sb2);
                int index = persons.indexOf(toFind);
                sb.append("\nИндекс в массиве: ");
                sb.append(index);
                System.out.println(sb.toString());
                Assert.assertEquals(persons.indexOf(toFind), new BinarySearch().indexOf(persons, toFind));
            }
        }
    }
    public void testBinarySearch3() throws Exception {
        for (int i = 0; i < 10000; i++) {
            testBinarySearch2();
        }
    }
}