package military.interfaces.entities;

import military.interfaces.Repair;

public class RepairImpl  implements Repair {
    private String partName;
    private int hoursWorked;

    public RepairImpl(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }
}
