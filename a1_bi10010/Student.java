package a1_bi10010;
import utils.*;

/**
 * @overview Student is a person who go to school
 * @attributes
 *  id          Integer     int
 *  name        String
 *  phoneNumber String
 *  address     String
 * @object
 *  A typical Student is s = <id,name,phoneNumber,address>
 * @abstract_properties
 *    mutable(id) = false /\ optional(id) = false /\ min(id) = 1 /\ max(id) = 10^9 /\
 *    mutable(name) = true /\ optional(name) = false /\ length(name) = 50 /\
 *    mutable(phoneNumber) = true /\ optional(phoneNumber) = false /\ length(phoneNumber) = 10 /\
 *    mutable(address) = true /\ optional(address) = false /\ length(address) = 100
 * @author Nguyen Ngoc Anh
 */


public class Student implements Comparable<Student> {
    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1, max = 1.0E9)
    private int id;
    @DomainConstraint(type = "String", mutable = true, optional = false, length = 50)
    private String name;
    @DomainConstraint(type = "String", mutable = true, optional = false, length = 10)
    private String phoneNumber;
    @DomainConstraint(type = "String", mutable = true, optional = false, length = 100)
    private String address;

    Student(){}
     /**
     * @effects
     * 
     *           if <id,name,phoneNumber,address,gpa> are not valid:
     *              throw exception
     *           else
     *              initialise this as Student:<id,name,phoneNumber,address>
     *
     */
    public Student(@AttrRef("id") int id,@AttrRef("name") String name,@AttrRef("phoneNumber") String phoneNumber,@AttrRef("address") String address)
            throws NotPossibleException {
        if (!validateId(id)) {
            throw new NotPossibleException("Student invalid id init: " + id);
        }
        if (!validateName(name)) {
            throw new NotPossibleException("Student invalid name init: " + name);
        }
        if (!validatePhoneNumber(phoneNumber)) {
            throw new NotPossibleException("Student invalid phone number init: " + phoneNumber);
        }
        if (!validateAddress(address)) {
            throw new NotPossibleException("Student invalid address init: " + address);
        }
        else {
            this.id = id;
            this.address = address;
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }

    /**
     * @effects
     *  return the result of comparing this.name and o.name
     *
     */
    @Override
    public int compareTo(Student o) {
        return (this.getName().compareTo(o.getName()));
    }

    /**
     * @effects
     *           if id is valid:
     *              set this.id = id
     *           else
     *              print error
     */
    public void setId(int id) {
        if (validateId(id)) {
            this.id = id;
        }
        else {
            System.err.println("Invalid id");
        }
    }

    /**
     * @effects
     *           if address is valid:
     *              set this.address = address
     *           else
     *              print error
     */
    public void setAddress(String address) {
        if (validateName(address)) {
            this.address = address;
        }
        else {
            System.err.println("Invalid address");
        }
    }

    /**
     * @effects
     *           if name is valid:
     *              set this.name = name
     *           else
     *              print error
     */
    public void setName(String name) {
        if (validateName(name)) {
            this.name = name;
        }
        else {
            System.err.println("Invalid name");
        }
    }

    /**
     * @effects
     *           if phoneNumber is valid:
     *              set this.phoneNumber = phoneNumber
     *           else
     *              print error
     */
    public void setPhoneNumber(String phoneNumber) {
        if (validatePhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }
        else {
            System.err.println("Invalid phone number");
        }
    }

    /**
     * @effects
     *           return this.id
     */
    public int getId() {
        return id;
    }

    /**
     * @effects
     *           return this.address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @effects
     *           return this.name
     */
    public String getName() {
        return name;
    }

    /**
     * @effects
     *           return this.phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @effects
     *           if id is valid
     *              return true
     *           else
     *              return false
     */
    protected boolean validateId(int i) {
        if (i<1 || i>1.0E9) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * @effects
     *           if name is valid
     *              return true
     *           else
     *              return false
     */
    private boolean validateName(String n) {
        if (n == null || n.length() > 50) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * @effects
     *           if phone number is valid
     *              return true
     *           else
     *              return false
     */
    private boolean validatePhoneNumber(String p) {
        if (p == null || p.length() > 10) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * @effects
     *           if address is valid
     *              return true
     *           else
     *              return false
     */
    private boolean validateAddress(String a) {
        if (a == null || a.length() > 100) {
            return false;
        }
        else {
            return true;
        }
    }

    private boolean validate(int id, String name, String address, String phoneNumber) {
        return validateId(id) && validateName(name) && validatePhoneNumber(phoneNumber) && validateAddress(address);
    }

    public boolean repOK() {
        return this.validate(this.id, this.name, this.address, this.phoneNumber);
    }

    @Override
    public String toString() {
        if (this.getClass().getSimpleName() == "UndergradStudent") {
            return("UndergradStudent("+this.getName()+")");
        }
        else if (this.getClass().getSimpleName() == "PostgradStudent") {
            return("PostgradStudent("+this.getName()+")");
        }
        else {
            return("Student("+this.getName()+")");
        }
    }
}
