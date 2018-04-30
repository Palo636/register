package register;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by jaro on 3.2.2014.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        //Register register = new ArrayRegister(20);
        ListRegister register = new ListRegister();


        register.addPerson(new Person("Janko Hrasko", "0900123456"));
        register.addPerson(new Person("ab", "0"));
        register.addPerson(new Person("ac", "1"));
        register.addPerson(new Person("ad", "2"));
        register.addPerson(new Person("af", "3"));



        ConsoleUI ui = new ConsoleUI(register);
        ui.run();
    }
}
