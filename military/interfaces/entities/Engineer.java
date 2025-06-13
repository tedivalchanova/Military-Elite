package military.interfaces;

import java.util.Collection;

public interface Engineer extends Private {
    public void addRepair(Repair repair);

    public Collection<Repair> getRepairs();
}
