package functional_programming.immutability.examplea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Person {
    private final String nameField;
    private final int ageField;
    private final Address addressField;
    private final College collegeField;
    private final List<String> hobbiesField;

    public Person(String name, int age, Address address, College college, List<String> hobbies) {
        nameField = name; // String is immutable
        ageField = age; // primitive are assigned by value
        addressField = address; // No deep copy needed since address references an immutable object
        collegeField = new College(college.getNameField(), college.getAddressField()); // Deep copy since college references mutable object
        hobbiesField = new ArrayList<>(hobbies); // deep copy since hobbies is a mutable object
    }

    public String getNameField() {
        return nameField;
    }

    public int getAgeField() {
        return ageField;
    }

    public Address getAddressField() {
        return addressField; // since addressField reference immutable object
    }

    public College getCollegeField() {
        return new College(collegeField.getNameField(), collegeField.getAddressField()); // deep copy since collegeField references a mutable object

    }

    public List<String> getHobbiesField() {
        return Collections.unmodifiableList(hobbiesField);
    }

    public static void main(String[] args) {

        String name = "Prem Raj Oli";
        int age = 25;
        Address address = new Address("123 Main St", "DC");
        Address collegeAddress = new Address("Bison Street", "DC");
        College college = new College("Howard University", collegeAddress);
        List<String> hobbies = new ArrayList<>(List.of("Coding", "Programming"));

        Person person = new Person(name, age, address, college, hobbies);

        // collegeField = college;
        college.setNameField("changed");
        System.out.println(person.collegeField.getNameField());
        //return collegeField;
        College collegeField = person.getCollegeField();
        collegeField.setNameField("changed");
        System.out.println(person.collegeField.getNameField());
    }
}
