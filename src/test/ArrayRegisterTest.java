import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import register.ArrayRegister;
import register.Person;
import register.Register;

import static org.junit.Assert.*;

public class ArrayRegisterTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addPerson1() {
        Register register = new ArrayRegister(20);
        register.addPerson(new Person("janko", "12345"));
        assertEquals(1, register.getCount());
        assertEquals("janko", register.getPerson(0).getName());
        assertEquals("12345", register.getPerson(0).getPhoneNumber());
        register.addPerson(new Person("janko2", "12348"));
        assertEquals(2, register.getCount());

    }

    @Test (expected = RuntimeException.class)
    public void addPerson2(){
        Register register = new ArrayRegister(20);
        register.addPerson(new Person("janko", "123"));
        register.addPerson(new Person("jozko", "nemaToIst"));

    }

    @Test
    public void addPerson3(){
        Register register = new ArrayRegister(20);
        register.addPerson(new Person("janko", "123"));
        register.addPerson(new Person("janko", "123"));
        assertEquals(1, register.getCount());

    }

    @Test
    public void findPersonByName() {
        Register register = new ArrayRegister(20);
        register.addPerson(new Person("janko", "12345"));
        register.addPerson(new Person("jankos", "123456"));
        assertNotNull(register.findPersonByName("janko"));
        assertNotNull(register.findPersonByName("jankos"));
        assertEquals(null, register.findPersonByName("afgafgaf"));

    }

    @Test
    public void findPersonByPhoneNumber() {
        Register register = new ArrayRegister(20);
        register.addPerson(new Person("janko", "12345"));
        register.addPerson(new Person("jankos", "123456"));
        assertNotNull(register.findPersonByPhoneNumber("12345"));
        assertNotNull(register.findPersonByPhoneNumber("123456"));
    }

    @Test
    public void findPersonByPhoneNumber2(){
        Register register = new ArrayRegister(20);
        register.addPerson(new Person("janko", "123456"));
        assertNull(register.findPersonByPhoneNumber("158"));
    }

    @Test
    public void removePerson() {
        Register register = new ArrayRegister(20);
        register.addPerson(new Person("janko", "12345"));
        register.addPerson(new Person("jankos", "123456"));
        register.removePerson(register.getPerson(0));
        register.removePerson(register.getPerson(1));
        assertEquals(0, register.getCount());
        assertNull(register.getPerson(1));
    }
}