import org.junit.Test;
import register.ArrayRegister;
import register.Person;
import register.Register;

import javax.swing.text.html.HTMLDocument;

import static org.junit.Assert.*;

public class PersonTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @Test
    public void getName() {
        Register register = new ArrayRegister(20);
        register.addPerson(new Person("janko", "12345"));
        assertEquals("janko", register.getPerson(0).getName());
    }

    @Test (expected = NullPointerException.class)
    public void getName2(){
        Register register = new ArrayRegister(20);
        register.getPerson(15).getName();
    }

    @Test
    public void setName() {
        Register register = new ArrayRegister(20);
        register.addPerson(new Person("janko", "12345"));
        register.findPersonByName("janko").setName("ferko");
        assertEquals("ferko",register.getPerson(0).getName() );
    }

    @Test
    public void getPhoneNumber() {
        Register register = new ArrayRegister(20);
        register.addPerson(new Person("janko", "12345"));
        assertEquals("12345", register.getPerson(0).getPhoneNumber());
    }

    @Test (expected = NullPointerException.class)
    public void getPhoneNumber2(){
        Register register = new ArrayRegister(20);
        register.getPerson(15).getPhoneNumber();
    }

    @Test
    public void setPhoneNumber() {
        Register register = new ArrayRegister(20);
        register.addPerson(new Person("janko", "12345"));
        register.findPersonByName("janko").setPhoneNumber("585");
        assertEquals("585",register.getPerson(0).getPhoneNumber() );

    }

    @Test(expected = RuntimeException.class)
    public void setPhoneNumber2() {
        Register register = new ArrayRegister(20);
        register.addPerson(new Person("janko", "12345"));
        register.findPersonByName("janko").setPhoneNumber("abeceda");

    }
}