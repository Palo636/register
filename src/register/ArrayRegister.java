package register;

/**
 * register.Person register.
 */
public class ArrayRegister implements Register {
    /** register.Person array. */
    private Person[] persons;
    
    /** Number of persons in this register. */
    private int count;
    
    /**
     * Constructor creates an empty register with maximum size specified.
     * @param size maximum size of the register
     */
    public ArrayRegister(int size) {
        persons = new Person[size];
        count = 0;
    }
    
    /**
     * Returns the number of persons in this register.
     * @return the number of persons in this register
     */
    @Override
    public int getCount() {
        return count;
    }
    
    /**
     * Returns the maximum number of persons in this register.
     * @return the maximum number of persons in this register.
     */
    @Override
    public int getSize() {
        return persons.length;
    }
    
    /**
     * Returns the person at the specified position in this register.
     * @param index index of the person to return 
     * @return person the person at the specified position in this register 
     */
    @Override
    public Person getPerson(int index) {
        return persons[index];
    }

    /**
     * Appends the specified person to the end of this register. 
     * @param person person to append to this register
     */
    @Override
    public void addPerson(Person person) {
        persons[count] = person;
        count++;
    }       
    
    //TODO: Implement the method findPersonByName
    /**
     * Returns the person with specified name in this register or <code>null</code>,
     * if match can not be found.
     * @param name name of a person to search for
     * @return person with specified phone number
     */
    @Override
    public Person findPersonByName(String name) {
        for(int i = 0; i < getCount(); i++){
            if (name.equals(getPerson(i).getName())){
                return getPerson(i);

            }
        } return null;
    }
    
    //TODO: Implement the method findPersonByPhoneNumber
    /**
     * Returns the person with specified phone number in this register or <code>null</code>,
     * if match can not be found.
     * @param phoneNumber phone number of a person to search for
     * @return person with specified phone number
     */
    @Override
    public Person findPersonByPhoneNumber(String phoneNumber) {
        for(int i = 0; i<getCount(); i++){
            if (phoneNumber.equals(getPerson(i).getPhoneNumber())){
                return getPerson(i);
            }
        }
        return null;
    }
    
    //TODO: Implement the method removePerson
    /**
     * Removes the specified person from the register.
     * @param person person to remove
     */
    @Override
    public void removePerson(Person person) {
        int i = 0;
        while(person != getPerson(i)){
            i++;
        }
        for(int j = i; i< getCount(); i++){
            persons[i]= persons[i+1];

        }
        count--;
    }
}
