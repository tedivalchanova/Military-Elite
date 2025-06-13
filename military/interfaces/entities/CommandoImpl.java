
package military.interfaces.entities;

import military.enums.Corps;
import military.interfaces.Commando;
import military.interfaces.Mission;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);

    }


    @Override
    public Collection<Mission> getMissions() {
        return Collections.unmodifiableCollection(this.missions);
    }

    @Override
    public String toString() {

        return String.format("Name: %s %s Id: %d Salary: %.2f%nCorps: %s", this.getFirstName(), this.getLastName(), this.getId(),
                this.getSalary(), this.getCorps());
    }
}
