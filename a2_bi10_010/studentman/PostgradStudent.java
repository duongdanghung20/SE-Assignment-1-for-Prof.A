package a2_bi10_010.studentman;
import utils.*;
import java.util.*;
import java.math.*;

/**
 * @overview PostgradStudent is a person who go to school after completed Bachelor program
 * @attributes
 *  gpa Float float
 * @object A typical PostgradStudent is <i,n,p,a,g> where id(i), name(n), phoneNumber(p), address(a), gpa(g)
 * @abstract_properties
 *    P_Student /\
 *    min(id) = 10^8+1 /\ max(id) = 10^9 /\
 *    mutable(gpa) = true /\ optional(gpa) = false /\ min(gpa) = 0 /\ max(gpa) = 4
 * @author Nguyen Ngoc Anh
 */
public class PostgradStudent extends Student {
    @DomainConstraint(type = "Float",mutable = true, optional = false, min = 0.0, max = 4.0)
    private float gpa;

    /**
     * @effects
     *            if i,n,p,a,g are valid
     *              initialise this as PostgradStudent:<i,n,p,a,g>
     *            else
     *              print error message
     *
     */
    public PostgradStudent(@AttrRef("id") int id,@AttrRef("name") String name, @AttrRef("phoneNumber") String phoneNumber, @AttrRef("address") String address, @AttrRef("gpa") float gpa) {
        super(id,name,phoneNumber,address);
        if(!validateGpa(gpa)) {
            System.err.println("PostgradStudent.init: invalid gpa");
        }
        else {
            this.gpa = gpa;
        }
    }


    /**
     * @effects
     *            if i is valid
     *              return true
     *            else
     *              return false
     */
    @Override
    @DomainConstraint(type = "Integer", min = 1.0E8+1, max = 1.0E9, optional = false)
    protected boolean validateId(int i) {
        if(!super.validateId(i))
            return false;
        if(i < 1.0E8+1 || i > 1.0E9)
            return false;

        return true;
    }

    /**
     *
     * @effects
     *  if gpa is not vaild
     *      throw Exception
     *  else
     *      set this.gpa = gpa
     */
    public void setGpa(int gpa) throws Exception {
        if (validateGpa(gpa)) {
            this.gpa = gpa;
        }
        else {
            System.err.println("Invalid Gpa");
        }
    }

    public float getGpa() {
        return gpa;
    }

    private boolean validateGpa(float gpa) {
        if (gpa < 0 || gpa > 4) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public String toString() {
        return ("PostgradStudent("+getName()+")");
    }

    @Override
    public boolean repOK() {
        if( super.repOK()) {
            return validateGpa(this.gpa);
        }
        else {
            return false;
        }
    }

    /**
     * @effects
     *            return a String containing the text of a simple HTML document generated from the state of the current object
     */
    @Override
    public String toHtmlDoc() {
        return "<html>\n<head><title>PostgradStudent:" + getId() + "-" + getName() + "</title></head>\n<body>\n" + getId() + " " + getName() + " " + getPhoneNumber() + " " + getAddress() + " " + getGpa() + "\n</body></html>";
    }
}
