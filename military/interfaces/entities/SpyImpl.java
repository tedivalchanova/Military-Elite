package military.interfaces.entities;

import military.interfaces.Soldier;
import military.interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {
    private String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.setCodeNumber(codeNumber);
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d Salary: %s",this.getFirstName(),this.getLastName(),this.getId(),
                this.codeNumber);
    }
}
