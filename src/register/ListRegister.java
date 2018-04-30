package register;

import java.util.ArrayList;
import java.util.List;

public class ListRegister<Person> implements Register {

    private List<Person> persons = new ArrayList<>();

    private int count;

    public ListRegister() {
        this.persons = persons;
        this.count = 0;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public register.Person getPerson(int index) {
        return null;
    }

    @Override
    public void addPerson(register.Person person) {

    }

    @Override
    public register.Person findPersonByName(String name) {
        return null;
    }

    @Override
    public register.Person findPersonByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public void removePerson(register.Person person) {

    }
}

