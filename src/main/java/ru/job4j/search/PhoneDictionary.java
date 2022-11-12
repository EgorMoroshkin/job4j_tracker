package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> name = Person -> Person.getName().equals(key);
        Predicate<Person> surName = Person -> Person.getSurname().equals(key);
        Predicate<Person> phone = Person -> Person.getPhone().equals(key);
        Predicate<Person> address = Person -> Person.getPhone().equals(key);
        Predicate<Person> combine = name.or(surName).or(phone).or(address);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}