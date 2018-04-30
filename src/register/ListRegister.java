package register;

import java.util.ArrayList;
import java.util.List;

public class ListRegister implements Register {
    List<Person> persons = new ArrayList<>();

    private int count;

    public ListRegister() {
        this.count = 0;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public Person getPerson(int index) {
        return persons.get(index);
    }

    @Override
    public void addPerson(Person person) {
        if (findPersonByName(person.getName()) == null) {
            if (findPersonByPhoneNumber(person.getPhoneNumber()) == null) {
                persons.add(person);
                count++;
            }
        } else {
            System.err.println("person is already in register");
        }

    }

    @Override
    public Person findPersonByName(String name) {
        for (int i = 0; i < getCount(); i++) {
            if (name.equals(getPerson(i).getName())) {
                return getPerson(i);
            }
        }
        return null;
    }

    @Override
    public Person findPersonByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < getCount(); i++) {
            if (phoneNumber.equals(getPerson(i).getPhoneNumber())) {
                return getPerson(i);
            }
        }
        return null;
    }

    @Override
    public void removePerson(Person person) {
        int i = 0;
        while (person != getPerson(i)) {
            i++;
        }
        persons.remove(i);
        count--;
        System.out.println("person is Removed");
    }
}


