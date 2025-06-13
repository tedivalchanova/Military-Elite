package military.interfaces.entities;

import military.interfaces.LieutenantGeneral;
import military.interfaces.Private;

import java.util.ArrayList;
import java.util.List;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private List<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public String toString() {


            return String.format("Name %s %s Id: %d Salary: %.2f", this.getFirstName(), this.getLastName(),
                    this.getId(), this.getSalary());




    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }
}

