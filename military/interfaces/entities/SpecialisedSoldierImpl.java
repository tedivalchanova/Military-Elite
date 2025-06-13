package military.interfaces.entities;

import military.enums.Corps;
import military.interfaces.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corps corps;
    protected SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps=corps;
    }


    public Corps getCorps() {
        return corps;
    }
}
