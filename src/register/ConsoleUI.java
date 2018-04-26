package register;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User interface of the application.
 */
public class ConsoleUI {
    /**
     * arrayRegister.ArrayRegister of persons.
     */
    private Register register;

    /**
     * In JDK 6 use Console class instead.
     *
     * @see //readLine()
     */
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Menu options.
     */
    private enum Option {
        PRINT, ADD, UPDATE, REMOVE, FIND, EXIT
    }

    ;

    public ConsoleUI(Register register) {
        this.register = register;
    }

    public void run() {
        while (true) {
            switch (showMenu()) {
                case PRINT:
                    printRegister();
                    break;
                case ADD:
                    addToRegister();
                    break;
                case UPDATE:
                    updateRegister();
                    break;
                case REMOVE:
                    removeFromRegister();
                    break;
                case FIND:
                    findInRegister();
                    break;
                case EXIT:
                    return;
            }
        }
    }

    private String readLine() {
        //In JDK 6.0 and above Console class can be used
        //return System.console().readLine();

        try {
            return input.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    private Option showMenu() {
        System.out.println("Menu.");
        for (Option option : Option.values()) {
            System.out.printf("%d. %s%n", option.ordinal() + 1, option);
        }
        System.out.println("-----------------------------------------------");

        int selection = -1;
        do {
            System.out.println("Option: ");
            selection = Integer.parseInt(readLine());
        } while (selection <= 0 || selection > Option.values().length);

        return Option.values()[selection - 1];
    }

    //TODO: Implement the method printRegister
    private void printRegister() {

        for (int i = 0; i < register.getCount(); i++) {
            StringBuilder sb = new StringBuilder();
            System.out.println(sb.append(i + 1).append(' ').append(register.getPerson(i).toString()));
        }
    }

    private void addToRegister() {
        System.out.println("Enter Name: ");
        String name = readLine();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = readLine();
        for (int i = 0; i < register.getCount(); i++) {
            if (name.equals(register.getPerson(i).getName()) || phoneNumber.equals(register.getPerson(i).getPhoneNumber())) {
                System.out.println("duplicited name or phone number ");
                addToRegister();
            }
        }
        register.addPerson(new Person(name, phoneNumber));
    }

    //TODO: Implement the method updateRegister
    private void updateRegister() {
        System.out.println("Enter index: ");
        int index = Integer.parseInt(readLine());
        Person person = register.getPerson(index - 1);
        System.out.println("Enter new name: ");
        String newName = readLine();
        System.out.println("Enter new phone number: ");
        String newNumber = readLine();
        person.setName(newName);
        person.setPhoneNumber(newNumber);

    }

    //TODO: Implement the method findInRegister
    private void findInRegister() {
        System.out.println("Enter NAME for finding by name or NUMBER for number :");
        String nameOrNum = readLine().toUpperCase();
        String finding;
        Person printedPerson;

        switch (nameOrNum) {
            case "NAME":
                System.out.println("Enter name: ");
                finding = readLine();
                printedPerson = register.findPersonByName(finding);
                if(printedPerson==null){
                    System.out.println("not found");
                    findInRegister();
                }
                System.out.println(printedPerson.toString());
                break;
            case "NUMBER":
                System.out.println("Enter number: ");
                finding = readLine();
                printedPerson = register.findPersonByName(finding);
                if(printedPerson==null){
                    System.out.println("not found");
                    findInRegister();
                }
                System.out.println(printedPerson.toString());
                break;
        }
    }

    private void removeFromRegister() {
        System.out.println("Enter index: ");
        int index = Integer.parseInt(readLine());
        Person person = register.getPerson(index - 1);
        register.removePerson(person);
    }

}
