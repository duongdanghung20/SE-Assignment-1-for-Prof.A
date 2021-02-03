package a1_bi10010;
import utils.*;

/**
 * @overview UndergradStudent (Undergraduate Student) is a person who go to school and
             take part in the Bachelor program
 * @abstract_properties
 *    P_Student /\
 *    min(id) = 10^5 /\ max(id) = 10^8
 * @author Nguyen Ngoc Anh
 */


public class UndergradStudent extends Student {
    /**
     * @effects
     *            if id,name,phoneNumber,address are valid
     *              initialise this as UndergradStudent:<id,name,phoneNumber,address>
     *            else
     *              throw exception
     */
    public UndergradStudent(@AttrRef("id") int id, @AttrRef("name") String name,
                            @AttrRef("phoneNumber") String phoneNumber, @AttrRef("address") String address) throws NotPossibleException {
        super(id, name, phoneNumber, address);
    }

    /**
     * @effects
     *            if i is valid
     *              return true
     *            else
     *              return false
     */
    @Override
    @DomainConstraint(type = "Integer", min = 1.0E5, max = 1.0E8, optional = false)
    protected boolean validateId(int i) {
        if(!super.validateId(i))
            return false;
        if(i < 1.0E5 || i > 1.0E8)
            return false;

        return true;
    }

    @Override
    public String toString() {
        return ("UndergradStudent("+getName()+")");
    }

    @Override
    public boolean repOK() {
        return super.repOK();
    }
}
