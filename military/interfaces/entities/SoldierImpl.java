package military.interfaces.entities;

import military.enums.Corps;
import military.interfaces.Soldier;

public abstract class SoldierImpl implements Soldier {
    private int id;
    private String firstName;
    private String lastName;
    private Corps  corps;


    protected SoldierImpl(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

}
