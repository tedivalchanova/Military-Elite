package military.interfaces.entities;

import military.enums.Corps;
import military.interfaces.Engineer;
import military.interfaces.Repair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);

    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d Salary: %f Corps: %s", this.getFirstName()
                , this.getLastName(), this.getId(), this.getSalary(), this.getCorps());
    }

    @Override
    public Collection<Repair> getRepairs() {
        return Collections.unmodifiableCollection(this.repairs);
    }
}
